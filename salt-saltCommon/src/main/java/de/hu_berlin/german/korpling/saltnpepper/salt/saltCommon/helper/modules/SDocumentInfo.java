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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public class SDocumentInfo {

	public static final String NOSLAYER_TAG = "NO_LAYER";
	public static final String ALL_LAYERS = "ALL_LAYERS";
//	private final EMap<String,InfoEntry> allEntries = new BasicEMap<String,InfoModule.InfoEntry>();
//	private final EMap<String,AnnoInfoEntry> allAnnoEntries = new BasicEMap<String,InfoModule.AnnoInfoEntry>();
	private final EMap<String, EMap<String,InfoEntry>>     layeredInfoEntries;
	private final EMap<String, EMap<String,AnnoInfoEntry>> layeredAnnoInfoEntries;
	private final EMap<String, String> metaData;
	private final EMap<String, AnnoInfoEntry> totalAnnoEntries;

	private SDocumentGraph sdocgraph;
	
	@Override
	public String toString(){
		final StringBuilder ret = new StringBuilder("SDocumentInfo( SDocGraph: " + sdocgraph + " ");
		for (String annoEntrie : layeredAnnoInfoEntries.keySet()) {
			ret.append(", ");
			ret.append(annoEntrie);
		}
		return ret.toString();
	}
	private SDocumentInfo() {
		// TODO Auto-generated constructor stub
		layeredInfoEntries     = new BasicEMap<String, EMap<String,InfoEntry>>();
		layeredAnnoInfoEntries = new BasicEMap<String, EMap<String,AnnoInfoEntry>>();
		totalAnnoEntries = new BasicEMap<String, AnnoInfoEntry>();
		metaData = new BasicEMap<String, String>();
	}
	
	public SDocumentInfo mergeTotal(SDocumentInfo other){
//		this.totalAnnoEntries.addAll(other.totalAnnoEntries);
		return this;
	}
	
	public void setSDocumentGraph(final SDocumentGraph sdocgraph){
		this.sdocgraph = sdocgraph;
		layeredInfoEntries.clear();
		layeredAnnoInfoEntries.clear();
		metaData.clear();
		totalAnnoEntries.clear();
		for (SLayer slayer : sdocgraph.getSLayers()) {
			EMap<String,InfoEntry> layerMap = new BasicEMap<String,InfoEntry>();
			EMap<String,AnnoInfoEntry> layerAnnoMap = new BasicEMap<String,AnnoInfoEntry>();
			layeredInfoEntries.put(slayer.getSName(), layerMap);
			layeredAnnoInfoEntries.put(slayer.getSName(), layerAnnoMap);
		}
		EMap<String,InfoEntry> layerMap = new BasicEMap<String,InfoEntry>();
		EMap<String,InfoEntry> allEntries = new BasicEMap<String,InfoEntry>();
		EMap<String,AnnoInfoEntry> layerAnnoMap = new BasicEMap<String,AnnoInfoEntry>();
		EMap<String,AnnoInfoEntry> allAnnoEntries = new BasicEMap<String,AnnoInfoEntry>();
		layeredInfoEntries.put(NOSLAYER_TAG, layerMap);
		layeredAnnoInfoEntries.put(NOSLAYER_TAG, layerAnnoMap);
		layeredInfoEntries.put(ALL_LAYERS, allEntries);
		layeredAnnoInfoEntries.put(ALL_LAYERS, allAnnoEntries);
	}
	
	 public static SDocumentInfo init(SDocumentGraph sdocgraph) {
		SDocumentInfo sdocinfo = new SDocumentInfo();
		if(sdocgraph == null){
			throw new SaltException("Can't init SDocumentInfo with SDocumentGraph == null");
		}
		sdocinfo.setSDocumentGraph(sdocgraph);
		return sdocinfo;
	}
	
//	public void addMetaData(final SDocument sdoc){
//		for(SMetaAnnotation smetaAnno: sdoc.getSMetaAnnotations()){
//			metaData.put(smetaAnno.getName(), smetaAnno.getSValueSTEXT());
//		}
//	}

	public Collection<AnnoInfoEntry> getAnnoEntries(String sLayerName) {
		return layeredAnnoInfoEntries.get(sLayerName).values();
	}
	public Collection<InfoEntry> getEntries(String sLayerName) {
		return layeredInfoEntries.get(sLayerName).values();
	}


	//TODO: Not mutable list?
	public void addAllObjects(final EList<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			add(eObject);
		}
		
	}

	/**
	 * @param eObject
	 */
	public void add(EObject eObject) {
		if(eObject == null){
			return;
		}
		EList<SLayer> layers = null;
		//TODO: Which Type captures both?
		if (eObject instanceof SNode){
			SNode snode = (SNode) eObject;
			layers = snode.getSLayers();
		} else if (eObject instanceof SRelation){
			SRelation srel = (SRelation) eObject;
			layers = srel.getSLayers();
		}
		countElementInEntryMaps(eObject,layeredInfoEntries.get(ALL_LAYERS),layeredAnnoInfoEntries.get(ALL_LAYERS));
		if (layers.isEmpty()){
			countElementInEntryMaps(eObject,layeredInfoEntries.get(NOSLAYER_TAG),layeredAnnoInfoEntries.get(NOSLAYER_TAG));	
		}else{
			for(SLayer sLayer: layers){
				countElementInEntryMaps(eObject, layeredInfoEntries.get(sLayer.getSName()), layeredAnnoInfoEntries.get(sLayer.getSName()));
			}
		}
	}

	/**
	 * @param eObject
	 * @param allAnnoEntries 
	 * @param allEntries 
	 */
	private void countElementInEntryMaps(final EObject eObject, final EMap<String, InfoEntry> entries, final EMap<String, AnnoInfoEntry> annoEntries) {
		String classString = eObject.eClass().getName();
		// increase Element Count (count EObjects by class name)
		increaseEntry(entries, classString);
		// Extra Count
		if(eObject instanceof SNode){
			increaseEntry(entries, "SNode");
		}else if(eObject instanceof SRelation){
			increaseEntry(entries, "SRelation");
		}

		// increase Annotation Count
		if(eObject instanceof SAnnotatableElement){
			SAnnotatableElement sAnnotated = (SAnnotatableElement) eObject;
			for (SAnnotation sAnno : sAnnotated.getSAnnotations()) {
				final String sAnnoName = sAnno.getName();
				// Seperate entries for annotations with same name 
				AnnoInfoEntry annoEntry = annoEntries.get(sAnnoName + eObject.eClass().getName());
//				AnnoInfoEntry globalAnnoEntry = totalAnnoEntries.get(sAnnoName + eObject.eClass().getName());
				if(annoEntry == null){
					annoEntry = new AnnoInfoEntry(sAnnoName,sAnnotated.eClass().getName());
					annoEntries.put(annoEntry.getKey(), annoEntry);
				}
//				if(globalAnnoEntry == null){
//					globalAnnoEntry = new AnnoInfoEntry(sAnnoName,sAnnotated.eClass().getName());
//					totalAnnoEntries.put(annoEntry.getKey(), globalAnnoEntry);
//				}
				annoEntry.count(sAnno);
//				globalAnnoEntry.count(sAnno);
			}
		}
	}

	/**
	 * @param entries
	 * @param classString
	 */
	private void increaseEntry(final EMap<String, InfoEntry> entries,
			String classString) {
		InfoEntry ie = entries.get(classString);
		if(ie == null){
			ie = new InfoEntry(classString);
			entries.put(ie.getKey(), ie);
		}else{
			ie.increase();
		}
	}
	
	public class InfoEntry{
		public final String name;
		public final String type;
		private long amount;
		
		
		public InfoEntry(final String sClassName) {
			this.name = sClassName;
			this.type = null;
			amount = 1l;
		}
		
		protected InfoEntry(final String sClassName, long n, final String type) {
			this.name = sClassName;
			this.type = type;
//			this.key = this.getKey();
			amount = n;
		}
		
		/**
		 * Sets the amount to 1 
		 * @param sClassName
		 * @param type
		 */
		public InfoEntry(final String sClassName, final String type) {
			this.name = sClassName;
			this.type = type;
			amount = 1l;
		}
		public void setCount(long l) {
			this.amount = l;	
		}
		/**
		 * Appends type to key if available 
		 * @return
		 */
		public String getKey() {
			return name + ((type != null)?type:"");
		}

		public long getCount() {
			return amount;
		}


		
		public long increase() {
			return ++amount;
		}

		public void merge(InfoEntry otherEntry) {
			this.amount += otherEntry.amount;
		}
	}

	public class AnnoInfoEntry extends InfoEntry{
		final EMap<String, InfoEntry> SValuesInfoEntries;
		public AnnoInfoEntry(final String sName,final String type) {
			// because count() will also increase this AnnoInfoEntry 
			super(sName,0,type);
			this.SValuesInfoEntries = new BasicEMap<String, InfoEntry>();
		}
		public void merge(AnnoInfoEntry other) {
			this.setCount(this.getCount() + other.getCount());
			for (InfoEntry otherEntry :other.SValuesInfoEntries.values()) {
				if (this.SValuesInfoEntries.contains(type)){
					this.SValuesInfoEntries.get(type).merge(otherEntry);
				}else{
					this.SValuesInfoEntries.put(otherEntry.name, otherEntry);
				}
			}
		}

		public Collection<InfoEntry> getSValuesInfoEntries() {
			return SValuesInfoEntries.values();
		}
		//TODO: SValue text hier ok?
		public void count(SAnnotation sAnno) {
			InfoEntry sValEntry = SValuesInfoEntries.get(sAnno.getSValueSTEXT());
			if(sValEntry == null){
				sValEntry = new InfoEntry(sAnno.getSValueSTEXT(),null);
				SValuesInfoEntries.put(sValEntry.getKey(), sValEntry);
			}else{
				sValEntry.increase();
			}	
			this.increase();
//			System.out.println("Name: " + this.key + " count: " + this.getCount());
		}
	}

	public Collection<String> getLayerNames() {
		// TODO Auto-generated method stub
		return layeredAnnoInfoEntries.keySet();
	}

	public Collection<InfoEntry> getAllEntries() {
		// TODO Auto-generated method stub
		return getEntries(ALL_LAYERS);
	}

	public Collection<AnnoInfoEntry> getAllAnnoInfoEntries() {
		// TODO Auto-generated method stub
		System.out.println(totalAnnoEntries.values());
		return totalAnnoEntries.values();
	}


}

