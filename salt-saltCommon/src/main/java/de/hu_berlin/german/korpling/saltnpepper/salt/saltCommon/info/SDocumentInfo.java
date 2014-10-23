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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * This class is able to count Objects in a SDocument.
 * @author jschmolling
 *
 */
public class SDocumentInfo {
	
	static private Logger log = LoggerFactory.getLogger(SDocumentInfo.class);
	
//	public final int ALL_TOP_OBJECTS = 0;
//	public final int ALL_TOP_ANNOTATIONS = 1;
//	public final int LAYERS = 2;
//	public final int ELEMENTS_WITHOUT_LAYERS = 3;
	
	public static final String NOSLAYER_TAG = "NOSLAYER";
	public static final String ALL_LAYERS = "ALL_LAYERS";
	public static final String META_DATA = "META_DATA";
//	private final List<Identifier> addBuffer = new ArrayList<Identifier>();
	private final Map<Identifier, Identifier> all = new HashMap<SDocumentInfo.Identifier, SDocumentInfo.Identifier>();
	private final Count allCounts = new Count(new Identifier(ALL_LAYERS), 0);
	private final Count noLayer = new Count(new Identifier(NOSLAYER_TAG), 0);
	private final Count metaData= new Count(new Identifier(META_DATA), 0);
	
	private final Identifier iDocument;
	private final Count cDocument;
	
	/**
	 * 
	 * @param sDocumentGraph
	 */
	private SDocumentInfo(SDocumentGraph sDocumentGraph) {
		assert sDocumentGraph != null;
		this.iDocument = new Identifier(sDocumentGraph.getId());
		this.cDocument = new Count(iDocument, 0);
		for (SLayer slayer : sDocumentGraph.getSLayers()) {
			Identifier iLayer = getIdentifier(slayer.getSName());
			cDocument.putSubIdentifierIfAbsent(iLayer, 0);
		}
		cDocument.putSubIdentifierIfAbsent(allCounts);
		cDocument.putSubIdentifierIfAbsent(noLayer);
		cDocument.putSubIdentifierIfAbsent(metaData);
//		log.debug("MetaData: " + sDocumentGraph.getSMetaAnnotations().size());
//		for (SMetaAnnotation metaanno : sDocumentGraph.getSMetaAnnotations()) {
//			addMetaDataItem(metaanno);
//		}
	}

	private SDocumentInfo(String docName) {
		this.iDocument = new Identifier(docName);
		this.cDocument = new Count(iDocument, 0);
	}

	private void addMetaDataItem(SMetaAnnotation metaanno) {
		Identifier snode = getIdentifier(metaanno.getName());
		Identifier svalue = getIdentifier(metaanno.getValue().toString());
//		Count eCount = metaData.putSubIdentifierIfAbsent(snode,0);
//		eCount.increase();
		metaData.increase();
		increaseCountForNestedElement(metaData, snode,svalue);
	}

	public static SDocumentInfo init(SDocumentGraph sDocumentGraph) {
		return new SDocumentInfo(sDocumentGraph);
	}
	public static SDocumentInfo init(String s) {
		return new SDocumentInfo(s);
	}

	public void addAllObjects(EList<? extends EObject> sTokens) {
		for (EObject eObject : sTokens) {
			add(eObject);
		}
	}

	public int getCount(String name, String layerName) {
		Identifier layer = getIdentifier(layerName);
		Identifier iName = getIdentifier(name);
		Count cLayer = cDocument.getSubCount(layer);
		return cLayer.getSubCount(iName).getValue();
	}

	public void add(EObject eObject) {
		cDocument.increase();
		List<SLayer> slayers = getSLayers(eObject);
		increase(allCounts,eObject);
		if (slayers.isEmpty()){
			increase(noLayer, eObject);
		}
		for (SLayer sLayer : slayers) {
			Identifier iLayer = getIdentifier(sLayer.getSName());
			Count cLayer = cDocument.putSubIdentifierIfAbsent(iLayer,0);
			increase(cLayer,eObject);
		}
		
	}

	/**
	 * increases the counts for the given parent count
	 * depending on the eObject the method will: 
	 * may increase count for "SNode"
	 * may increase count for "SRelation"
	 * increase count for "eObject.eClass().getName()"
	 * 
	 * may increase the subcounts for depending on the annotations' name and value
	 * @param eObject
	 * @param cLayer
	 */
	private void increase(Count cLayer, EObject eObject) {
		cLayer.increase();
		Identifier iObject = getIdentifier(eObject.eClass().getName());
		increaseCountForNestedElement(cLayer, iObject);
		// Counting SRelation, SNode separated
		if (eObject instanceof SRelation) {
			Identifier snode = getIdentifier(SRelation.class.getSimpleName());
			increaseCountForNestedElement(cLayer, snode);
		}  
		if (eObject instanceof SNode) {
			Identifier iRelation = getIdentifier(SNode.class.getSimpleName());
			increaseCountForNestedElement(cLayer, iRelation);
		}

		
		// cAnnotation -> aCount -> vCount
		if (eObject instanceof SAnnotatableElement) {
			SAnnotatableElement sanno = (SAnnotatableElement) eObject;
			Identifier iAnnotation = getIdentifier(sanno.eClass().getName());
			for (SAnnotation anno : sanno.getSAnnotations()) {
				Identifier iAnno  = getIdentifier(anno.getName());
				Identifier iValue = getIdentifier(anno.getValue().toString());
				increaseCountForNestedElement(cLayer.putSubIdentifierIfAbsent(iObject, 0), iAnno, iValue);
			}
		
		}
	}
	
	private void increaseCountForNestedElement(final Count parent,final Identifier... id){
		Count current = parent;
		for (Identifier identifier : id) {
			Count sub = current.putSubIdentifierIfAbsent(identifier,0);
			sub.increase();
			current = sub;
		}
	}


	
	private Identifier getIdentifier(String string) {
		Identifier id = new Identifier(string);
		if (all.containsKey(id)){
			
		}else{
			all.put(id, id);
		}
		return all.get(id);
	}

	static int createHash(String name, String type, String value){
		return (name + type + value).hashCode();
	}

	private class Identifier{		
		private final String clazz;
		
		private Identifier(EObject e){
			this.clazz = e.getClass().getSimpleName();
		}
		
		public Identifier(SLayer slayer) {
			this.clazz = slayer.getSName();
		}
		
		public Identifier(SAnnotation anno) {
			this.clazz = anno.getName();
//			this.id = clazz.hashCode();
		}

		public Identifier(String string) {
			if (string != null){
				this.clazz = string;
			}else{
				this.clazz = "";
			}
		}

		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof Identifier){
				return this.clazz.equals((((Identifier)arg0).clazz));
			}
			return super.equals(arg0);
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.clazz.hashCode();
		}	
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("(iden=\"%s\")", clazz);
		}
		
	}
	
	class Count{
		public final Map<Identifier,Count> subElements = new HashMap<SDocumentInfo.Identifier, SDocumentInfo.Count>();
		public final Identifier id;
		private Integer n;
		
		public Count(Identifier i, Integer n) {
			this.n = n;
			this.id = i;
		}
		
		public void putSubIdentifierIfAbsent(Count allCounts) {
			subElements.put(allCounts.id, allCounts);
		}

		public int getValue() {
			return n;
		}

		public Count getSubCount(Identifier iName) {
			if (subElements.containsKey(iName)){
				return subElements.get(iName);
			}else{
				return new Count(iName, 0);
			}
		}
		
		@Override
		public String toString() {
			return String.format("(%s, %s, %s)", id.clazz, n, Arrays.toString(subElements.keySet().toArray()));
		}

		public Count putSubIdentifierIfAbsent(Identifier identifier,int n) {
			if(subElements.containsKey(identifier)){
				return subElements.get(identifier);
			}else{
				Count count = new Count(identifier,n);
				subElements.put(identifier,count);
				return count;
			}
		}

		public void increase() {
			++n;
		}
		
		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof Count) {
				return ((Count)arg0).id == this.id;
			} else {
				return super.equals(arg0);
			}
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.id.hashCode();
		}

		public Map<Identifier, Count> getSubMap() {
			return Collections.unmodifiableMap(this.subElements);
		}

		public String getID() {
			return this.id.clazz;
		}
		
		/**
		 * Method to create new Count Instance from Static calls
		 * @param i
		 * @param n
		 * @return
		 */
		public Count getNew(Identifier i, Integer n) {
			return new Count(i, n);
		}

		/**
		 * Returns the count for the sub element
		 * @param key
		 * @return
		 */
		public Count get(Identifier key) {
			if(this.subElements.containsKey(key)){
				return this.subElements.get(key);
			}else{
				return new Count(key, 0);
			}
		}

		public boolean hasSubLayers() {
			return !this.subElements.isEmpty();
		}
	}
	
	private List<SLayer> getSLayers(EObject eObject) {
		if (eObject instanceof SNode){
			SNode snode = (SNode) eObject;
			return snode.getSLayers();
		} else if (eObject instanceof SRelation){
			SRelation srel = (SRelation) eObject;
			return srel.getSLayers();
		}else{
			return Collections.emptyList();
		}
	}

	public Collection<String> getLayerNames() {
		Set<Identifier> cLayers = cDocument.getSubMap().keySet();
		List<String> name = new ArrayList<String>(cLayers.size());
		for (Identifier id : cLayers) {
			if(!id.clazz.equals(ALL_LAYERS) && !id.clazz.equals(NOSLAYER_TAG) && !id.clazz.equals(META_DATA)){
				name.add(id.clazz);
			}
		}
		return Collections.unmodifiableList(name);
	}
	
	public void print() {
		log.debug("SDocumentInfo for " + iDocument.clazz);
		recPrint("", cDocument);
	}
	
	public void print(String layer) {
		log.debug("SDocumentInfo for layer " + layer + " in "+ iDocument.clazz);
		recPrint("", cDocument.getSubCount(this.getIdentifier(layer)));
	}
	
	public void recPrint(String tabs, Count c) {
		log.debug(tabs + c.id.clazz + ": " + c.n);
		if (c.getSubMap().isEmpty()){
			return;
		}
		for(Count count : c.getSubMap().values()){
			recPrint(tabs + "\t", count);
		}
	}

	public Map<String,Integer> getTopLevelCounts(int option) {
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (Count c : allCounts.subElements.values()) {
			if(c.subElements.isEmpty()){
				counts.put(c.getID(), c.getValue());
			}
		}
		return counts;
	}

	public Map<String, String> getMetaData() {
		Map<String, String> counts = new HashMap<String, String>();
		for (Count c : metaData.subElements.values()) {
			// meta data must be unique
			counts.put(c.getID(), c.subElements.values().iterator().next().getID());
		}
		return counts;
	}



	public static SDocumentInfo merge(SDocumentInfo left, SDocumentInfo right) {
		
		// merge nicely with null or empty documents 
		if (left == null || right == null) {	
			if (left == null && right != null) {
				return right;
			} else if (right == null && left != null) {
				return left;
			}else if (left == null || right == null) {
				return new SDocumentInfo("empty");
			}
		}
		log.debug(String.format("==Merging %s %s", left.getName(), right.getName()));
		log.debug("Left  total sToken " + left.getCount("SToken", SDocumentInfo.ALL_LAYERS));
		log.debug("Right total sToken " + right.getCount("SToken", SDocumentInfo.ALL_LAYERS));
		SDocumentInfo merged = new SDocumentInfo(left.getName());
		Count cMerging = merged.cDocument;
		Count lRoot    = left.cDocument;
		Count rRoot    = right.cDocument;
		rMerge(cMerging, lRoot, rRoot);
		log.debug(" Merged total sToken " + merged.getCount("SToken", SDocumentInfo.ALL_LAYERS));
		return merged;
	}

	/**
	 * Recursive merge function 
	 * 
	 * @param cMerging merge target
	 * @param lRoot
	 * @param rRoot
	 */
	private static void rMerge(Count cMerging, Count lRoot, Count rRoot) {
		cMerging.n = lRoot.n + rRoot.n;
		Set<Identifier> keys = new HashSet<SDocumentInfo.Identifier>();
		keys.addAll(lRoot.subElements.keySet());
		keys.addAll(rRoot.subElements.keySet());
		for (Identifier key : keys) {
			int m = 0;
			if (lRoot != null && lRoot.subElements.containsKey(key)){
				m += lRoot.getSubCount(key).n;
			}
			if (lRoot != null && rRoot.subElements.containsKey(key)){
				m += rRoot.getSubCount(key).n;
			}
			Count cMerged = lRoot.getNew(key, m);
			cMerging.putSubIdentifierIfAbsent(cMerged);	
			rMerge(cMerged, lRoot.get(key), rRoot.get(key));
		}
	}

	public String getName() {
		return iDocument.clazz;
	}

//	public List<String> getAnnotations(String allLayers) {
//		List<String> annos = new LinkedList<String>();
//		Count layer = cDocument.get(getIdentifier(allLayers));
//		for (Count anno : layer.getSubMap().values()) {
//			if(anno.hasSubLayers()){
//				annos.add(anno.getID());
//			}
//		}
//		
//		return annos;
//	}

//	public Map<String, Integer> getAnnotations(String allLayers, String annoName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public Map<String, Integer> getCounts(String... idName){
		Map<String, Integer> counts = new HashMap<String, Integer>();
//		Count current = cDocument;
		Count next = cDocument;
		for (String id : idName) {
			next = next.get(getIdentifier(id));
		}
		if (next.hasSubLayers()){
			for (Count c : next.getSubMap().values()) {
				counts.put(c.getID(), c.getValue());
			}
		}
		return counts;
	}

	public Set<String> getAnnotationCount(String layerName, String key) {
		return this.getCounts(layerName,key).keySet();
	}

	public static SDocumentInfo init(SDocument sdoc) {
		if(sdoc.getSDocumentGraph() == null){
			return new SDocumentInfo("");
		}else{
			return init(sdoc.getSDocumentGraph());
		}
	}

	public static SDocumentInfo init(SaltProject sp) {
		return init(sp.getSName());
	}

	public void addAllMetaData(EList<SMetaAnnotation> sMetaAnnotations) {
		for (SMetaAnnotation sMetaAnnotation : sMetaAnnotations) {
			addMetaDataItem(sMetaAnnotation);
		}
		
	}
	
	@Override
	public String toString() {
		return String.format("(SDocInfo, iDocument=%s, cDocCount=%s)", this.iDocument.clazz, this.cDocument.getValue());
	}


}

