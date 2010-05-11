package de.hub.corpling.salt.saltCommon.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltExceptions.SaltException;

public class GrAFResource extends ResourceImpl
{	
	/**
	 * Stores a SDocumentGraph-object in GrAF-format.
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
		if (this.getURI()== null)
			throw new SaltException("Cannot write resource, because no uri is given.");
		
		if (this.getContents().size()>1)
			throw new SaltException("Cannot write more than one salt-graph.");
		
		if (this.getContents().size()== 0)
		{//do nothing, if no content is given
			return;
		}//do nothing, if no content is given
		
		if (this.getContents().get(0)== null)
			throw new SaltException("Cannot write an empty SDocument-graph object.");
		
		if (this.getContents().get(0) instanceof SDocumentGraph)
		{
			SDocumentGraph sDocGraph= (SDocumentGraph)this.getContents().get(0); 
			File outputFile= new File(this.getURI().toFileString());
			if (outputFile.isDirectory())
			{
			}
			else if (outputFile.isFile())
			{
				File textFile= null;
				{//create text file
					String[] parts= outputFile.getAbsolutePath().split("[.]");
					String ending= "."+parts[parts.length-1];
					textFile= new File(outputFile.getAbsolutePath().replace(ending, ".txt"));
					try
					{
						textFile.createNewFile();
					}
					catch (IOException e)
					{ 
						throw new SaltException("Cannot create file for primary data, nested exception is: ", e);
					}
				}//create text file
				GrAFWriter grafWriter= new GrAFWriter();
				grafWriter.setXSDName(xsdName);
				grafWriter.setTextFile(textFile);
				grafWriter.setsDocumentGraph(sDocGraph);
				grafWriter.setDestination(outputFile);
				grafWriter.save();
				this.printXSD(outputFile.getParentFile());
			}
			else 
			{
				throw new SaltException("Cannot write to resource, because given uri '"+this.getURI()+"' is neither of type directory nor of type file.");
			}
		}
		else 
		{
			throw new SaltException("Cannot export the given object of type: '"+this.getContents().get(0).getClass()+"'");
		}
	}
	
	private static final String xsdName="GRaF.xsd";
	
	private void printXSD(File folder)
	{
		File XSDFile= new File(folder.getAbsolutePath()+ "/"+ xsdName);
		StringBuffer outBuffer= new StringBuffer();
		
		outBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outBuffer.append("<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"\n");
		outBuffer.append("targetNamespace=\"http://www.tc37sc4.org/graf/v1.0.4b\"\n");
		outBuffer.append("xmlns:graf=\"http://www.tc37sc4.org/graf/v1.0.4b\"\n");
		outBuffer.append("elementFormDefault=\"qualified\">\n");
		outBuffer.append("\n\n");
		outBuffer.append("<xs:element name=\"graph\">\n");
		outBuffer.append("<xs:complexType>\n");
		outBuffer.append("<xs:choice maxOccurs=\"unbounded\">\n");
		outBuffer.append("<xs:element name=\"nodeSet\" type=\"graf:nodeSetType\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("<xs:element name=\"node\" type=\"graf:nodeType\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("<xs:element name=\"span\" type=\"graf:spanType\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("<xs:element name=\"edgeSet\" type=\"graf:edgeSetType\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("<xs:element name=\"edge\" type=\"graf:edgeType\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("</xs:choice>\n");
		outBuffer.append("<xs:attribute name=\"id\" type=\"xs:string\" use=\"required\"/>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("</xs:element>\n");
		outBuffer.append("\n");
		outBuffer.append("<xs:complexType name=\"edgeType\">\n");
		outBuffer.append("<xs:attribute name=\"id\" type=\"xs:ID\"/>\n");
		outBuffer.append("<xs:attribute name=\"from\" use=\"required\" type=\"xs:NMTOKEN\"/>\n");
		outBuffer.append("<xs:attribute name=\"to\" use=\"required\" type=\"xs:NMTOKEN\"/>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("\n");
		outBuffer.append("<xs:complexType name=\"edgeSetType\">\n");
		outBuffer.append("<xs:sequence>\n");
		outBuffer.append("<xs:element name=\"edge\" type=\"graf:edgeType\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("</xs:sequence>\n");
		outBuffer.append("<xs:attribute name=\"id\" type=\"xs:ID\"/>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("\n");
		outBuffer.append("<xs:complexType name=\"featureType\">\n");
		outBuffer.append("<xs:attribute name=\"n\" type=\"xs:string\" use=\"required\"/>\n");
		outBuffer.append("<xs:attribute name=\"v\" type=\"xs:string\" use=\"required\"/>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("\n");
		outBuffer.append("<xs:complexType name=\"featureStructureType\">\n");
		outBuffer.append("	<xs:choice maxOccurs=\"unbounded\">\n");
		outBuffer.append("<xs:element name=\"f\" type=\"graf:featureType\"/>\n");
		outBuffer.append("<xs:element name=\"fs\" type=\"graf:featureStructureType\"/>\n");
		outBuffer.append("</xs:choice>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("\n");
		outBuffer.append("<xs:complexType name=\"nodeSetType\">\n");
		outBuffer.append("<xs:choice maxOccurs=\"unbounded\">\n");
		outBuffer.append("<xs:element name=\"node\" type=\"graf:nodeType\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("<xs:element name=\"span\" type=\"graf:spanType\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("</xs:choice>\n");
		outBuffer.append("<xs:attribute name=\"id\" type=\"xs:string\"/>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("\n");
		outBuffer.append("<xs:complexType name=\"nodeType\">\n");
		outBuffer.append("<xs:sequence>\n");
		outBuffer.append("<xs:element name=\"fs\" type=\"graf:featureStructureType\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n");
		outBuffer.append("</xs:sequence>\n");
		outBuffer.append("<xs:attribute name=\"id\" type=\"xs:string\" use=\"required\"/>\n");
		outBuffer.append("<xs:attribute name=\"type\" type=\"xs:string\" use=\"required\"/>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("\n");
		outBuffer.append("<xs:complexType name=\"spanType\">\n");
		outBuffer.append("<xs:attribute name=\"id\" type=\"xs:string\"/>\n");
		outBuffer.append("<xs:attribute name=\"start\" use=\"required\" type=\"xs:string\"/>\n");
		outBuffer.append("<xs:attribute name=\"end\" use=\"required\" type=\"xs:string\"/>\n");
		outBuffer.append("</xs:complexType>\n");
		outBuffer.append("\n");
		outBuffer.append("</xs:schema>");
		
		{//write buffer to file
			PrintStream fileWriter= null;
			try {
				fileWriter= new PrintStream(new FileOutputStream(XSDFile), true, "utf-8");
				fileWriter.print(outBuffer.toString());
				fileWriter.flush();
			} catch (UnsupportedEncodingException e) 
			{
				throw new SaltException("Cannot write to resource '"+XSDFile.getAbsolutePath()+"'. ",e);
			} catch (FileNotFoundException e) 
			{
				throw new SaltException("Cannot write to resource '"+XSDFile.getAbsolutePath()+"'. ",e);
			}
			finally
			{
				if (fileWriter!= null)
					fileWriter.close();
			}
		}//write buffer to file
	}
	
	/**
	 * Loads a SDocumentGraph-object from file in  GrAF-format.
	 */
	public void load(java.util.Map<?,?> options) throws java.io.IOException
	{
		if (this.getURI()== null)
			throw new SaltException("Cannot write resource, because no uri is given.");
		
		File inputGrAFFile= new File(this.getURI().toFileString());
		SDocumentGraph sDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getContents().add(sDocumentGraph);
		
		GrAFReader grafReader= new GrAFReader();
		grafReader.setsDocumentGraph(sDocumentGraph);
		grafReader.setFileResource(inputGrAFFile);
		grafReader.load();
	}
}
