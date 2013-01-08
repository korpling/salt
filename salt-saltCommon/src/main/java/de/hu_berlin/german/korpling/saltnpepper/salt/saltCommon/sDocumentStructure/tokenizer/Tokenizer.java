/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.callback.LanguageCallback;

import org.knallgrau.utils.textcat.TextCategorizer;

import com.neovisionaries.i18n.LanguageCode;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltTokenizerException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

/**
 * The general task of this class is to tokenize a given text in the same order as the tool TreeTagger will do. 
 * A list of tokenized text is returned with the text anchor (start and end position) in original text.
 * Reimplemented in Java with permission from the original TreeTagger tokenizer in Perl by Helmut Schmid 
 * (see http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/). 
 * This implementation uses sets of abbreviations to detect tokens, which are abbreviations in a specific language.
 * Therefore you can set a file containing abbreviations, to take others than the default ones. Because of 
 * abbreviations are language dependend, you can set a language, to use only a specific set of abbreviations.
 * The current version of the {@link TTTokenizer} supports abbreviations for english, french, italian and german language.
 * If no language is set, all available abbreviations will be used.    
 *  
 * @author Amir Zeldes
 * @author Florian Zipser
 *
 */
public class Tokenizer 
{
	/**
	 * Sets the {@link SDocumentGraph} to be used.
	 */
	private SDocumentGraph sDocumentGraph=null;
	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}
	
	/**
     * Initializes a new TTokenizer object.
     */
    public Tokenizer()  
    {
    }
    
//    private STextualDS sTextualDSs= null;
    
    /**
     * Sets the {@link STextualDS} to be tokenized. Its language will be detected automatically if possible.
     * @param sTextualDSs
     */
    public void tokenize(STextualDS sTextualDSs)
    {
    	this.tokenize(sTextualDSs, null);
    }
    
    /**
     * Sets the {@link STextualDS} to be tokenized and the language of the text. If language is null, it will 
     * be detected automatically if possible.
     * @param sTextualDSs
     */
    public void tokenize(STextualDS sTextualDSs, LanguageCode language)
    {
    	this.tokenize(sTextualDSs, language, null, null);
    }

    /**
     * Sets the {@link STextualDS} to be tokenized and the language of the text. If language is null, it will 
     * be detected automatically if possible.
     * @param sTextualDSs {@link STextualDS} object containing the text to be tokenized
     * @param language language of text, if null, language will be detected automatically
     * @param startPos start position, if text to be tokenized is subset (0 assumed if set to null)
     * @param startPos end position, if text to be tokenized is subset (length of text assumed if set to null)
     */
    public void tokenize(STextualDS sTextualDS, LanguageCode language, Integer startPos, Integer endPos)
    {
    	if (sTextualDS== null)
    		throw new SaltTokenizerException("Cannot tokenize an empty 'SSTextualDS' object.");
    	
    	if (sTextualDS.getSText()!= null)
    	{
	    	if (startPos== null)
	    		startPos= 0;
	    	if (endPos== null)
	    		endPos= sTextualDS.getSText().length();
	    	
	    	//detect language
	    	if (language== null)
	    		language= checkLanguage(sTextualDS.getSText().substring(startPos, endPos));
	    
	    	if (language!= null)
			{//set abbreviations
				if (this.getAbbreviations(language)== null)
				{
					if (LanguageCode.de.equals(language))
						this.addAbbreviation(LanguageCode.de, AbbreviationDE.createAbbriviations());
					else if (LanguageCode.en.equals(language))
						this.addAbbreviation(LanguageCode.en, AbbreviationEN.createAbbriviations());
					else if (LanguageCode.fr.equals(language))
						this.addAbbreviation(LanguageCode.fr, AbbreviationFR.createAbbriviations());
					else if (LanguageCode.it.equals(language))
						this.addAbbreviation(LanguageCode.it, AbbreviationIT.createAbbriviations());
				}
			}//set abbreviations
	    	
	    	this.setClitics(language);
	    	
	    	this.tokenizeToToken(sTextualDS, language, startPos, endPos);
    	}
    	
    }
    
    /**
     * Tries to detect language and returns ISO 639-2 language code
     * @param text
     * @return
     */
    public LanguageCode checkLanguage(String text)
    {
    	LanguageCode retVal= null;
    	if (text!= null)
    	{//detect language
    		TextCategorizer textCategorizer= new TextCategorizer();
    		String lang= textCategorizer.categorize(text);
    		return(mapISOLanguageCode(lang));
    	}//detect language
    	return(retVal);
    }
    
    /**
     * Maps the knallgrau {@link TextCategorizer} language description codes to ISO 639 codes.
     * @return
     */
    public LanguageCode mapISOLanguageCode(String language)
    {
    	LanguageCode retVal= null; 
    	if ("german".equals(language))
    		retVal= LanguageCode.de;
    	else if ("english".equals(language))
    		retVal= LanguageCode.en;
    	else if ("french".equals(language))
    		retVal= LanguageCode.fr;
    	
    	else if ("spanish".equals(language))
    		retVal= LanguageCode.es;
    	else if ("italian".equals(language))
    		retVal= LanguageCode.it;
    	else if ("swedish".equals(language))
    		retVal= LanguageCode.sv;
    	else if ("polish".equals(language))
    		retVal= LanguageCode.pl;
    	else if ("dutch".equals(language))
    		retVal= LanguageCode.nl;
    	else if ("norwegian".equals(language))
    		retVal= LanguageCode.no;
    	else if ("finnish".equals(language))
    		retVal= LanguageCode.fi;
    	else if ("albanian".equals(language))
    		retVal= LanguageCode.sq;
    	else if ("slovakian".equals(language))
    		retVal= LanguageCode.sk;
    	else if ("slovenian".equals(language))
    		retVal= LanguageCode.sl;
    	else if ("danish".equals(language))
    		retVal= LanguageCode.da;
    	else if ("hungarian".equals(language))
    		retVal= LanguageCode.hu;
    	return(retVal);	
    }
    
    
    private Map<LanguageCode, HashSet<String>> abbreviations= null;
    /**
     * Adds the given list of abbreviation to the internal map corresponding to given language.
     * @param language
     * @param abbreviations
     */
    public void addAbbreviation(LanguageCode language, HashSet<String> abbreviations)
    {
    	if (	(language!= null)&&
    			(abbreviations!= null))
    	{
    		if (this.abbreviations== null)
    			this.abbreviations= new ConcurrentHashMap<LanguageCode, HashSet<String>>();
    		if (!this.abbreviations.containsKey(language))
    			this.abbreviations.put(language, abbreviations);
    	}
    }
    
    /**
     * Adds the content of given file as a list of abbreviation to the internal map corresponding to given language.
     * Form of the file:
     * Adm.<br/>
     * Ala.<br/>
     * Ariz.<br/>
     * Ark.<br/>
     * Aug.<br/>
     * Ave.<br/>
     * Bancorp.<br/>
     * @param language
     * @param abbreviations
     */
    public void addAbbreviation(LanguageCode language, File abbreviationFile)
    {
    	HashSet<String> abbreviations= null;
    	try 
    	{
    		abbreviations= new HashSet<String>();
    		
    		BufferedReader inReader;
		
			inReader = new BufferedReader(new InputStreamReader(new FileInputStream(abbreviationFile), "UTF8"));
		
			String input = "";
			
			while((input = inReader.readLine()) != null)
			{
	           //putting
	           abbreviations.add(input);
			}
			inReader.close();
			
        } catch (FileNotFoundException e) 
        {
			throw new SaltTokenizerException("Cannot tokenize the given text, because the file for abbreviation '"+abbreviationFile.getAbsolutePath()+"' was not found.");
		} catch (IOException e) 
		{
			throw new SaltTokenizerException("Cannot tokenize the given text, because can not read file '"+abbreviationFile.getAbsolutePath()+"'.");
		}
		this.addAbbreviation(language, abbreviations);
    }
    
    /**
     * Returns a list of abbreviations corresponding to the given language.
     * @param language
     * @return
     */
    public HashSet<String> getAbbreviations(LanguageCode language)
	{
    	if (this.abbreviations== null)
			this.abbreviations= new ConcurrentHashMap<LanguageCode, HashSet<String>>();
		return(abbreviations.get(language));
	}

//======================= start: important issues
    // characters which have to be cut off at the beginning of a word
    protected final static String P_CHAR = "\\[\\{\\(´`\"»«‚„†‡‹‘’“”•–—›";
    // characters which have to be cut off at the end of a word
    protected final static String F_CHAR = "\\]\\}'`\"\\),;:!\\?%»«‚„…†‡‰‹‘’“”•–—›";

    // character sequences which have to be cut off at the beginning of a word
    private String PClitic="";
    // character sequences which have to be cut off at the end of a word
    private String FClitic="";
    
    /**
     * Sets clitics corresponding to the given language.
     * @param lngLang language
     */
    private void setClitics(LanguageCode language)
    {
    	if (LanguageCode.en.equals(language))
    		this.FClitic = "('(s|re|ve|d|m|em|ll)|n't)";
    	else if (LanguageCode.fr.equals(language))
    	{	
    		this.PClitic = "([dcjlmnstDCJLNMST]'|[Qq]u'|[Jj]usqu'|[Ll]orsqu')";
        	this.FClitic = "(-t-elles?|-t-ils?|-t-on|-ce|-elles?|-ils?|-je|-la|-les?|-leur|-lui|-mêmes?|-m'|-moi|-nous|-on|-toi|-tu|-t'|-vous|-en|-y|-ci|-là)";
    	}
    	else if (LanguageCode.es.equals(language))
    		this.PClitic = "([dD][ae]ll'|[nN]ell'|[Aa]ll'|[lLDd]'|[Ss]ull'|[Qq]uest'|[Uu]n'|[Ss]enz'|[Tt]utt')";
    	else if (LanguageCode.de.equals(language))
    		;//do nothing
    }
    
    /**
     * The general task of this class is to tokenize a given text in the same order as the tool TreeTagger will do. 
     * A list of tokenized text is returned with the text anchor (start and end position) in original text.
     * @param strInput original text
     * @return tokenized text fragments and their position in the original text
     */
    public void tokenizeToToken(	STextualDS sTextualDS, 
    								LanguageCode language, 
    								Integer startPos, 
    								Integer endPos) 
    {
    	List<String> strTokens = null;
    	String strInput= sTextualDS.getSText().substring(startPos, endPos);
    	strTokens= this.tokenizeToString(strInput, language);
    	if (	(strTokens!= null)&&
    			(strTokens.size()> 0))
    	{
    		char[] chrText= strInput.toCharArray();
    		int tokenCntr= 0;
    		
    		for (int i=0; i< chrText.length; i++ )
     		{
    			if (	(strTokens.get(tokenCntr).length()< 1) ||
    					(strTokens.get(tokenCntr).substring(0, 1).equals(String.valueOf(chrText[i]))))
     			{//first letter matches
     	 			StringBuffer pattern= new StringBuffer();
     				for (int y=0; y < strTokens.get(tokenCntr).length(); y++)
     				{//compute pattern in text
     					pattern.append(chrText[i+y]);
     				}//compute pattern in text
     				if (strTokens.get(tokenCntr).hashCode()== pattern.toString().hashCode())
     				{//pattern found
     					this.getsDocumentGraph().createSToken(sTextualDS, i, i+strTokens.get(tokenCntr).length());
     	    			i= i+strTokens.get(tokenCntr).length()-1;
     					tokenCntr++;
     					if (tokenCntr >= strTokens.size())
     						break;
     				}//pattern found
     			}//first letter matches
     		}
    	}
    }
    
    /**
     * The general task of this class is to tokenize a given text in the same order as the tool TreeTagger will do. 
     * Returns a list of tokenized text. 
     * @param strInput original text
     * @return tokeized text fragments
     */
    public List<String> tokenizeToString(String strInput, LanguageCode language) 
    {
        //insert missing blanks after punctuation
        strInput = strInput.replaceAll("\\.\\.\\."," ... ");
        strInput = strInput.replaceAll("([;\\!\\?])([^ ])","$1 $2");
            
        //replace any amount of white spaces with one space
        strInput = strInput.replaceAll("\\s+", " ");
        
        //make sure there are no leading or trailing spaces
        strInput = strInput.trim();
        
        String[] strOutput;
        //split based on whitespace
        strOutput = strInput.split(" ");

        ArrayList<String> lstTokens = new ArrayList<String>(Arrays.asList(strOutput));
        Pattern p = null;
        Matcher m = null;
        Pattern p2 = null;
        Matcher m2 = null;
        
           for (int i=0; i < lstTokens.size();i++)
           {
               //cut off preceding punctuation 
               p = Pattern.compile("^([" + P_CHAR + "])(.+)");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  continue; //advance further in the loop, checking the token without preceding punctuation
               }               
               
               //cut off trailing punctuation 
               p = Pattern.compile("^(.+)([" + F_CHAR + "])$");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i--; //do not advance, the token needs to be checked without trailing punctuation
                  continue; //repeat the loop, checking the same token without trailing punctuation
               }

               //cut off trailing periods if punctuation precedes
               p = Pattern.compile("^(.+[" + F_CHAR + "])(\\.)$");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i--; //do not advance, the token needs to be checked without trailing period
                  continue; //repeat the loop, checking the same token without trailing period
               }

               //check abbreviation list
               HashSet<String> abbreviations= this.getAbbreviations(language);
               if (	(abbreviations!= null)&&
               		(abbreviations.contains(lstTokens.get(i))))
               {
                   //known abbreviation found
                   continue;
               }

               //abbreviations of the form A. or U.S.A.
               p = Pattern.compile("^([A-Za-zÁÂÃÈý®Ð×ÝÞÍðÎÓÔÕØÙãõš›€ß‚ƒ„‡ˆ‰Š‹ŒŽøŸ÷·”“’]\\.)+$");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  continue; //leave this acronym token alone and advance the loop
               }
               
               //disambiguate periods
               p = Pattern.compile("^(.+)(\\.)$");
               m = p.matcher(lstTokens.get(i));
               p2 = Pattern.compile("^(\\.\\.\\.|[0-9]+\\.)$");
               m2 = p2.matcher(lstTokens.get(i));
               if (m.find() && !m2.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i++; //no need to check next token, as it is a separate period
                  continue; //advance the loop
               }

                //attempt to separate proclitics
                p = Pattern.compile("^(" + PClitic + ")(.+)$");
                m = p.matcher(lstTokens.get(i));
               if (m.find() && !PClitic.isEmpty())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  continue; //proclitic has been removed, but next token must still be checked
               }

               //attempt to separate enclitics
               p = Pattern.compile("(.+)(" + FClitic + ")$");
               m = p.matcher(lstTokens.get(i));
               if (m.find() && !FClitic.isEmpty())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i++; //next token is a known enclitic, skip it
                  continue; //advance to get past the enclitic
               }
           }
        return lstTokens;
    }
// ======================= end: important issues	
}

