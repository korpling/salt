import glob, os, fileinput, sys
os.chdir(".")

def rename(file):
    print("rename "+file)
    for line in fileinput.input(file, inplace = 1): 
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
	line= line.replace('edge', 'relation')

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
	line= line.replace('getSDocumentGraph()', 'getGraph()')
	line= line.replace('setSDocumentGraph(', 'setGraph(')
	getSDocumentGraph()

        sys.stdout.write(line)


if len(sys.argv)>1:
    sourcePath= sys.argv[1]
else:
    sourcePath="" 

if os.path.isdir(sourcePath):
    for file in glob.glob(sourcePath+"*.java"):
        rename(file)
else:
   rename(sourcePath)


