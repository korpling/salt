package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules;

import java.util.LinkedHashSet;
import java.util.Set;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;

/**
 * This class compares two {@link SDocumentGraph} objects for isomoprhie. 
 * @author florian
 *
 */
public class Diff {
	public enum DIFF_TYPES{
		
	}
	
	public class Difference{
		/** type of the difference **/
		public DIFF_TYPES diffType;
		/** an informal description of the difference. **/
		public String description;
		/** Object of graph template, if this difference type has one**/
		public Object templateObject;
		/** Object of graph other, if this difference type has one**/
		public Object otherObject;
	}
	
	private Set<Difference> differences= null;
	/** Returns a list containing all computed differences. **/
	public Set<Difference> getDifferences() {
		if (differences== null){
			differences= new LinkedHashSet<Diff.Difference>();
		}
		return differences;
	}
	/**
	 * Initializes Diff object with the two graphs <code>template</code> and <code>other</code>.
	 * @param template
	 * @param other
	 */
	public Diff(SDocumentGraph template, SDocumentGraph other){
		
	}
	/**
	 * Compares the set graphs and returns if they are isomorph or not. In case of the graphs are not
	 * isomorph, this method does not record all differences. TO speed up the computation.
	 * it just detects the first difference and returns false. To get a full list of all differences, 
	 * use method {@link #findDiffs()}.
	 * @return true, if graphs are isomorph, false otherwise.
	 */
	public boolean isIsomorph(){
		return(start(false));
	}
	/**
	 * Compares the set graphs and returns if they are isomorph or not. If graphs are not isomporph, 
	 * this method finds and records  all differences and lists them. That means the entire graphs 
	 * have to be compared and could slow down the computation. If you are only interested in the 
	 * result and not in the particular differences, use method {@link #isIsomorph()}. 
	 * @return true, if graphs are isomorph, false otherwise.
	 */
	public boolean findDiffs(){
		return(start(true));
	}
	/**
	 * Compares the set graphs and returns if they are isomorph or not. 
	 * @param findDiffs if true, differences will be recorded. 
	 * @return true, if graphs are isomorph, false otherwise.
	 */
	private boolean start(boolean findDiffs){
		return false;
	}

}
