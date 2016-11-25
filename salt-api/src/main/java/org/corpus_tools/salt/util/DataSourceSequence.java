/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.util;

import org.corpus_tools.salt.common.SSequentialDS;
import org.corpus_tools.salt.common.STextualDS;

/**
 * This class is a helper class to address a sequence inside a data source. For
 * instance to address the text "sample" in a {@link STextualDS#getText()} "This
 * is a sample text.", a {@link DataSourceSequence} object needs to be
 * initialized like this: {@link #getStart()} =10, {@link #getEnd()} = 16 and
 * {@link #getDataSource()} = the data source containing the entire text. <br/>
 * 
 * @author florian
 *
 */
public class DataSourceSequence<P extends Number> {

	public DataSourceSequence() {
	}

	public DataSourceSequence(SSequentialDS dataSource, P start, P end) {
		this.dataSource = dataSource;
		this.start = start;
		this.end = end;
	}

	/** start value for this sequence **/
	protected P start = null;

	/**
	 * @return start value of this sequence
	 */
	public P getStart() {
		return start;
	}

	/**
	 * @param start
	 *            start value of this sequence
	 */
	public void setStart(P start) {
		if (start != null) {
			if (start instanceof Integer) {
				if (start.intValue() < 0) {
					start = null;
				}
			} else {
				if (start.doubleValue() < 0) {
					start = null;
				}
			}
		}
		this.start = start;
	}

	/** end value for this sequence **/
	protected P end = null;

	public P getEnd() {
		return end;
	}

	public void setEnd(P end) {
		if (end != null) {
			if (end instanceof Integer) {
				if (end.intValue() < 0) {
					end = null;
				}
			} else {
				if (end.doubleValue() < 0) {
					end = null;
				}
			}
		}
		this.end = end;
	}

	/** data source which is addressed by this sequence **/
	protected SSequentialDS dataSource;

	/**
	 * @return data source which is addressed by this sequence
	 */
	public SSequentialDS getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource
	 *            data source which is addressed by this sequence
	 */
	public void setDataSource(SSequentialDS dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (");
		result.append(getDataSource().getId());
		result.append(getStart());
		result.append(", ");
		result.append(getEnd());
		result.append(')');
		return result.toString();
	}

	public static class Builder {

		public <P extends Number> Builder2<P> on(SSequentialDS<?, P> dataSource) {
			final DataSourceSequence<P> sequence = new DataSourceSequence<>();
			sequence.setDataSource(dataSource);
			return new Builder2<P>(sequence);
		}

		public static class Builder2<P extends Number> {
			private final DataSourceSequence<P> sequence;

			public Builder2(DataSourceSequence<P> sequence) {
				this.sequence = sequence;
			}

			public Builder2<P> from(P start) {
				sequence.setStart(start);
				return this;
			}

			public Builder2<P> to(P end) {
				sequence.setEnd(end);
				return this;
			}

			public DataSourceSequence<P> build() {
				return sequence;
			}
		}
	}
}
