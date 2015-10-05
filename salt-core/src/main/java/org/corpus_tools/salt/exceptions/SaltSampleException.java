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
package org.corpus_tools.salt.exceptions;

import org.corpus_tools.salt.samples.SampleGenerator;

/**
 * An Exception class used by the {@link SampleGenerator}.
 * 
 * @author florian
 *
 */
@SuppressWarnings("serial")
public class SaltSampleException extends SaltException {
	public SaltSampleException() {
		super();
	}

	public SaltSampleException(String s) {
		super(s);
	}

	public SaltSampleException(String s, Throwable ex) {
		super(s, ex);
	}
}
