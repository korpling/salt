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
package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltWrongParameterException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class STimelineImpl extends SSequentialDSImpl<String, Integer> implements STimeline {

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

	/** {@inheritDoc} **/
	@Override
	public void setGraph(@SuppressWarnings("rawtypes") Graph graph) {
		if (!(graph instanceof SDocumentGraph)) {
			throw new SaltWrongParameterException("graph", "setGrah", getClass(), "The parameter was not of type SDocumentGraph. ");
		}
		super.setGraph(graph);
	}

	/** {@inheritDoc} **/
	@Override
	public List<String> getPointsOfTime() {
		List<String> retVal = null;
		String timelineStr = (String) super.getData();
		if (timelineStr != null) {
			String[] timelineStrArr = timelineStr.split(SaltUtil.TIMELINE_SEPARATOR);
			retVal = Collections.unmodifiableList(Arrays.asList(timelineStrArr));
		}
		return (retVal);
	}
	/** stored the number of points of time **/
	protected int numPOS= 0;
	
	/** {@inheritDoc} **/
	@Override
	public void addPointOfTime(String pointOfTime) {
		if (pointOfTime == null) {
			throw new SaltInsertionException(this, pointOfTime, "Cannot add an empty point of time. ");
		}
		String timeline = (String) super.getData();
		if (timeline == null) {
			String pot = null;
			if (pointOfTime.isEmpty()) {
				pot = "0";
			} else {
				pot = pointOfTime;
			}
			timeline = pot;
		} else {
			String pot = null;
			if (pointOfTime.isEmpty()) {
				pot = getPointsOfTime().size() + "";
			} else {
				pot = pointOfTime;
			}
			timeline = timeline + SaltUtil.TIMELINE_SEPARATOR + pot;
		}
		numPOS++;
		super.setData(timeline);
	}

	@Override
	public Integer getStart() {
		if (getData() != null) {
			return (0);
		} else {
			return null;
		}
	}

	@Override
	public Integer getEnd() {
		if (getData() != null) {
			return (numPOS);
		} else {
			return null;
		}
	}
} // STimelineImpl
