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
package org.corpus_tools.salt.graph;

/**
 * This enumeration contains all attributes which are used in several classes in
 * Salt's graph model.
 * 
 * @author florian
 *
 */
public enum GRAPH_ATTRIBUTES {
	/**
	 * Names the namespace of a label, attribute {@link Label#getNamespace()}.
	 **/
	LABEL_NAMESPACE,
	/** Names the name of a label, attribute {@link Label#getName()}. **/
	LABEL_NAME,
	/** Names the value of a label, attribute {@link Label#getValue()}. **/
	LABEL_VALUE,
	/**
	 * Names list of labels of a label, attribute {@link Label#getLabels()}.
	 **/
	LABEL_LABELS,
	/**
	 * Names the source of a relation, attribute {@link Relation#getSource()}.
	 **/
	RELATION_SOURCE,
	/**
	 * Names the target of a relation, attribute {@link Relation#getTarget()}.
	 **/
	RELATION_TARGET,
	/**
	 * Names list of labels of a relation, attribute
	 * {@link Relation#getLabels()}.
	 **/
	RELATION_LABELS,
	/** Names list of labels of a node, attribute {@link Node#getLabels()}. **/
	NODE_LABELS,
	/**
	 * Names list of labels of a graph, attribute {@link Graph#getLabels()}.
	 **/
	GRAPH_LABELS,
	/** Names list of nodes of a graph, attribute {@link Graph#getNodes()}. **/
	GRAPH_NODES,
	/**
	 * Names list of relations of a graph, attribute
	 * {@link Graph#getRelations()}.
	 **/
	GRAPH_RELATIONS,
	/** Names list of layers of graph attribute {@link Graph#getLayers()} **/
	GRAPH_LAYERS,
	/**
	 * Names list of labels of a layer, attribute {@link Graph#getLabels()}.
	 **/
	LAYER_LABELS,
	/** Names list of nodes of a layer, attribute {@link Graph#getNodes()}. **/
	LAYER_NODES,
	/**
	 * Names list of relations of a layer, attribute
	 * {@link Graph#getRelations()}.
	 **/
	LAYER_RELATIONS
}
