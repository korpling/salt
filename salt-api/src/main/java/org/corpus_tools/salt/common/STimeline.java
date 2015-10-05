/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package org.corpus_tools.salt.common;

public interface STimeline extends SSequentialDS<Integer, Integer>, SDocumentGraphObject {
	// public List<String> getPointsOfTime();
	// public void addPointOfTime(String sPointOfTime);

	/**
	 * Increases the number of points of time by one. The points of time are
	 * stored as a single number determining the number of points of time. The
	 * maximal number of points of time can be retrieved by calling
	 * {@link #getEnd()}.
	 */
	public void increasePointOfTime();

	/**
	 * Increases the number of points of time by the passed number. The points
	 * of time are stored as a single number determining the number of points of
	 * time. The maximal number of points of time can be retrieved by calling
	 * {@link #getEnd()}.
	 */
	public void increasePointOfTime(Integer additionalPOS);
} // STimeline
