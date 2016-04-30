/**
 * Copyright 2016 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.common.tokenizer;

import java.util.regex.Pattern;

import org.corpus_tools.salt.common.STextualDS;

/**
 * Models clitics for a given language, with support for 
 * proclitics (({@link #proclitic}) and enclitics ({@link #enclitic})
 * in this version. Meso- and endoclitics are not yet supported.
 * <p>
 * The {@link String} representation of the respective clitics
 * needs to be a regular expression, as it will be used to 
 * {@link Pattern#compile(String)} a pattern to split the 
 * {@link STextualDS}'s text, i.e., as below.
 * <p>
 * <code>
 * Pattern.compile("^"  XClitic  "(.)$")
 * </code>
 * <p>
 * Two examples for such a regex string are (<b>note the main group!</b>):
 * <ul>
 * <li>Enclitics for English: <code>"('(s|re|ve|d|m|em|ll)|n't)"</code></li>
 * <li>Proclitics for French: <code>"([dcjlmnstDCJLNMST]'|[Qq]u'|[Jj]usqu'|[Ll]orsqu')"</code></li>
 * </ul>
 * From {@link Tokenizer}.
 * 
 * @author Stephan Druskat
 *
 */
public class Clitics {

	// character sequences which have to be cut off at the beginning of a word
	private String proclitic = "";

	// character sequences which have to be cut off at the end of a word
	private String enclitic = "";

	public String getProclitic() {
		return proclitic;
	}
	public Clitics setProclitic(String pClitic) {
		proclitic = pClitic;
		return this;
	}
	public String getEnclitic() {
		return enclitic;
	}
	public Clitics setEnclitic(String fClitic) {
		enclitic = fClitic;
		return this;
	}

}