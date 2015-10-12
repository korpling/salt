import glob, os, fileinput, sys, re
import fnmatch
os.chdir(".")

def rename(file):
	for line in fileinput.input(file, inplace = 1): 
		
		#change imports for pepper modules
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.pepper.common.DOCUMENT_STATUS;', 'import org.corpus_tools.pepper.common.DOCUMENT_STATUS;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.pepper.modules.PepperMapper;', 'import org.corpus_tools.pepper.modules.PepperMapper;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.pepper.modules.exceptions.PepperModuleDataException;', 'import org.corpus_tools.pepper.modules.exceptions.PepperModuleDataException;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.pepper.modules.impl.PepperMapperImpl;', 'import org.corpus_tools.pepper.modules.PepperMapper;')
		
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;', 'import org.corpus_tools.salt.common.SCorpus;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;', 'import org.corpus_tools.salt.common.SDocument;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;', '')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;', 'import org.corpus_tools.salt.common.SDocumentGraph;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;', 'import org.corpus_tools.salt.common.SPointingRelation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SALT_TYPE;', 'import org.corpus_tools.salt.SALT_TYPE')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;', 'import org.corpus_tools.salt.common.SToken;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;', 'import org.corpus_tools.salt.core.SAnnotation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;', 'import org.corpus_tools.salt.core.SNode;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;', 'import org.corpus_tools.salt.core.SRelation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;', 'import org.corpus_tools.salt.common.SSpan;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;', 'import org.corpus_tools.salt.SaltFactory;')
		line= line.replace('import org.eclipse.emf.common.util.BasicEList;', 'import java.util.ArrayList;')
		line= line.replace('import org.eclipse.emf.common.util.EList;', 'import java.util.List;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;', 'import org.corpus_tools.salt.SaltFactory;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;', 'import org.corpus_tools.salt.common.SDominanceRelation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;', 'import org.corpus_tools.salt.common.SStructure;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;', 'import org.corpus_tools.salt.common.STextualDS;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;', 'import org.corpus_tools.salt.common.SSpanningRelation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;', 'import org.corpus_tools.salt.common.STextualRelation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;', 'import org.corpus_tools.salt.semantics.SPOSAnnotation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SWordAnnotation;', 'import org.corpus_tools.salt.semantics.SWordAnnotation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;', 'import org.corpus_tools.salt.core.SLayer;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;', 'import org.corpus_tools.salt.core.SLayer;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;', 'import org.corpus_tools.salt.common.STimeline;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;', 'import org.corpus_tools.salt.common.STimelineRelation;')
		line= line.replace('import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode;', 'import org.corpus_tools.salt.common.SStructuredNode;')
		
		
		#global 
		line= line.replace('SaltFactory.eINSTANCE', 'SaltFactory')
		line= line.replace('new BasicEList<', 'new ArrayList<') # must be before next row
		line= line.replace('EList<', 'List<')
		line= line.replace('STYPE_NAME', 'SALT_TYPE')
		
		#salt core
		line= line.replace('setSName', 'setName')
		line= line.replace('getSName', 'getName')
		line= line.replace('setSId', 'setId')
		line= line.replace('getSId', 'getId')
		line= line.replace('getOutEdges(', 'getOutRelations(')
		line= line.replace('getInEdges(', 'getInRelations(')
		line= line.replace('addSNode', 'addNode')
		line= line.replace('addSRelation', 'addRelation')
		line= line.replace('getSNodes', 'getNodes')
		line= line.replace('getSNode', 'getNode')
		line= line.replace('getSRelations', 'getRelations')
		line= line.replace('getSRelation', 'getRelation')
		line= line.replace('Edge', 'Relation')
		#line= line.replace('edge', 'relation')
		line= line.replace('createSAnnotation(', 'createAnnotation(')
		line= line.replace('createSMetaAnnotation(', 'createMetaAnnotation(')
		line= line.replace('createSProcessingAnnotation(', 'createProcessingAnnotation(')
		line= line.replace('createSFeature(', 'createFeature(')
		line= line.replace('getSAnnotations()', 'getAnnotations()')
		line= line.replace('getSMetaAnnotations()', 'getMetaAnnotations()')
		line= line.replace('getSProcessingAnnotations()', 'getProcessingAnnotations()')
		line= line.replace('getSFeature()', 'getFeature()')
		line= line.replace('getSTarget()', 'getTarget()')
		line= line.replace('setSTarget(', 'setTarget(')
		line= line.replace('getSSource()', 'getSource()')
		line= line.replace('setSSource(', 'setSource(')
		line= line.replace('addSType(', 'setType(')
		line= line.replace('getSNS()', 'getNamespace()')
		line= line.replace('setSNS(', 'setNamespace(')
		line= line.replace('getSValue()', 'getValue()')
		line= line.replace('setSValue(', 'setValue(')

		#corpus structure
		line= line.replace('addSSubCorpus(', 'addSubCorpus(')
		line= line.replace('getSDocument', 'getDocument')
		line= line.replace('getSCorpusGraphs', 'getCorpusGraphs')
		line= line.replace('setSCorpus', 'setCorpus')
		line= line.replace('setSDocument', 'setDocument')
		line= line.replace('getSCorpusDocumentRelations', 'getCorpusDocumentRelations')
		line= line.replace('addSSubCorpus', 'addSubCorpus')
		line= line.replace('addSDocument', 'addDocument')
		line= line.replace('getSCorpus', 'getCorpus')
		line= line.replace('getSRootCorpus', 'getRoots')

		#document structure
		line= line.replace('SAudioDSRelation', 'SMedialRelation')
		line= line.replace('SAudioDataSource', 'SMedialDS')
		line= line.replace('createSAudioDS(', 'createSMedialDS(')
		line= line.replace('SDataSourceSequence', 'DataSourceSequence')
		line= line.replace('SaltFactory.createDataSourceSequence();', 'new DataSourceSequence();')
		line= line.replace('setSSequentialDS(', 'setDataSource(')
		line= line.replace('getSSequentialDS()', 'getDataSource()')
		line= line.replace('setSStart(', 'setStart(')
		line= line.replace('getSStart()', 'getStart()')
		line= line.replace('setSEnd(', 'setEnd(')
		line= line.replace('getSEnd()', 'getEnd()')
		line= line.replace('setSTextualDS(', 'setTarget(')
		line= line.replace('getSSpan()', 'getSource()')
		line= line.replace('setSSpan(', 'setSource(')
		line= line.replace('getSStructuredTarget()', 'getTarget()')
		line= line.replace('setSStructuredTarget(', 'setTarget(')
		line= line.replace('getSStructuredSource()', 'getSource()')
		line= line.replace('setSStructuredSource(', 'setSource(')
		line= line.replace('getSStructure()', 'getTarget()')
		line= line.replace('setSStructure(', 'setTarget(')
		line= line.replace('getSDocumentGraph()', 'getGraph()')
		line= line.replace('setSDocumentGraph(', 'setGraph(')
		line= line.replace('getSTextualDSs()', 'getTextualDSs()')
		line= line.replace('getSText()', 'getText()')
		line= line.replace('setSText(', 'setText(')
		line= line.replace('setSTimeline(', 'setTimeline(')
		line= line.replace('getSTimeline()', 'getTimeline()')
		line= line.replace('getSPointsOfTime()', 'getEnd()')
		line= line.replace('getSTokens()', 'getTokens()')
		line= line.replace('getSSpans()', 'getSpans()')
		line= line.replace('getSStructures()', 'getStructures()')
		line= line.replace('getSTextualRelations()', 'getTextualRelations()')
		line= line.replace('getSSpanningRelations()', 'getSpanningRelations()')
		line= line.replace('getSPointingRelations()', 'getPointingRelations()')
		line= line.replace('getSDominanceRelations()', 'getDominanceRelations()')
		line= line.replace('getSOrderRelations()', 'getOrderRelations()')
		line= line.replace('getSTimelineRelations()', 'getTimelineRelations()')
		line= line.replace('sortSTokenByText()', 'sortTokenByText()')
		line= line.replace('getSortedSTokenByText()', 'getSortedTokenByText()')
		line= line.replace('getRootsBySRelation(', 'getRootsByRelation(')
		line= line.replace('getNodeBySequence', 'getNodesBySequence')
		line= line.replace('getSLayerByName', 'getLayerByName')
		line= line.replace('addSLayer', 'addLayer')	
		line= line.replace('getLayers().add', 'addLayer')	
		line= line.replace('SMetaAnnotatableElement', 'SAnnotationContainer')	
		line= line.replace('hasLabel', 'containsLabel')	
		line= line.replace('getSCorpora', 'getCorpora')	
		line= line.replace('SElementId', 'Identifier')	
		line= line.replace('getSValue_STEXT()', 'getValue_STEXT()')	
		line= line.replace('getSElementPath()', 'getPath()')
		line= line.replace('addSAnnotation', 'addAnnotation')
		line= line.replace('getSLayers()', 'getLayers()')
		line= line.replace('getSMetaAnnotation', 'getMetaAnnotation')
		line= line.replace('getSAudioReference()', 'getMediaReference()')
		line= line.replace('getSText', 'getText')
		line= line.replace('getOverlappedSTokens', 'getOverlappedTokens')
		line= line.replace('getSortedSTokenByText', 'getSortedTokenByText')
		line= line.replace('getSValueSTEXT()', 'getValue_STEXT()')
		line= line.replace('getSValueSURI()', 'getValue_SURI()')
		line= line.replace('annotation.getSValueType()', 'annotation.getValueType()')
		line= line.replace('SDATATYPE', 'SALT_TYPE')
		line= line.replace('getCorpusGraph()', 'getGraph()')
		line= line.replace('getSRoots()', 'getRoots()')
		line= line.replace('getRootsBySRelationSType(', 'getRootsByRelationType(')
		line= line.replace('SGraphTraverseHandler', 'GraphTraverseHandler')
		line= line.replace('getOverlappedSTokens', 'getOverlappedTokens')
		line= line.replace('setSAudioReference', 'setMediaReference')
		line= line.replace('getSMedialDSs()', 'getMedialDSs()')
		line= line.replace('getSMedialRelations()', 'getMedialRelations()')
		line= line.replace('getDocumentGraph().createSToken(', 'getDocumentGraph().createToken(')
		line= line.replace('getSAnnotation(', 'getAnnotation(')
		line= line.replace('getSAnnotatableElement()', 'getContainer()')
		line= line.replace('addSMetaAnnotation(', 'addMetaAnnotation(')
		line= line.replace('getLayers().add(', 'addLayer(')
		line= line.replace('.getCorpusGraphs().add(', '.addCorpusGraph(')
		line= line.replace('.insertSTokensAt(', '.insertTokensAt(')
		line= line.replace('.getSTokensBySequence(', '.getTokensBySequence(')
		line= line.replace('.getNodes().add(', '.addNode(')
		line= line.replace('.getRelations().add', '.addRelation(')
		
		
		
		#in tests
		line= line.replace('this.getFixture()', 'getFixture()')
		
		#exceptions
		line= line.replace('SaltElementNotContainedInGraphException', 'SaltElementNotInGraphException')
		
		#repair 
		line= line.replace('SaltFactory.createAnnotation();', 'SaltFactory.createSAnnotation();')
		line= line.replace('SaltFactory.createMetaAnnotation();', 'SaltFactory.createSMetaAnnotation();')
		
		
		sys.stdout.write(line)

def recursive_glob(treeroot, pattern):
    results = []
    for base, dirs, files in os.walk(treeroot):
        goodfiles = fnmatch.filter(files, pattern)
        results.extend(os.path.join(base, f) for f in goodfiles)
    return results

if len(sys.argv)>1:
    sourcePath= sys.argv[1]
else:
    sourcePath="" 

print sourcePath
if os.path.isdir(sourcePath):
	files= recursive_glob(sourcePath, "*.java")
	for file in files:
		print "rename "+file
		rename(file)
else:
    rename(sourcePath)
