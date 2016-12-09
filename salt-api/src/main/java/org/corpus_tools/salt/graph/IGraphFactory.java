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

import org.corpus_tools.salt.graph.impl.GraphImpl;
import org.corpus_tools.salt.graph.impl.IdentifierImpl;
import org.corpus_tools.salt.graph.impl.LabelImpl;
import org.corpus_tools.salt.graph.impl.NodeImpl;
import org.corpus_tools.salt.graph.impl.RelationImpl;

public interface IGraphFactory {

	/**
	 * Creates a new {@link Graph} object of type {@link GraphImpl}.
	 * 
	 * @return new {@link Graph} object
	 */
	public<N extends Node,R extends Relation<? extends N, ? extends N>, L extends Layer<N,R>> 
		Graph<N,R,L> createGraph(Class<N> nodeClass, Class<R> relationClass, Class<L> layerClass);

	/**
	 * Creates a new {@link Node} object of type {@link NodeImpl}.
	 * 
	 * @return new {@link Node} object
	 */
	public Node createNode();

	/**
	 * Creates a new {@link Relation} object of type {@link RelationImpl}.
	 * 
	 * @return new {@link Relation} object
	 */
	public <S extends Node, T extends Node> Relation<S,T> 
		createRelation(Class<S> sourceClass, Class<T> targetClass);
	

	/**
	 * Creates a new {@link Label} object of type {@link LabelImpl}. The value
	 * of this label is defined to be of type {@link String}. To use another
	 * value type, use one of the other create methods createLabelXXX() or the
	 * generic method {@link #createLabel(Class)}.
	 * 
	 * @return new {@link Label} object
	 */
	public abstract Label createLabel();

	/**
	 * Creates a new {@link Identifier} object of type {@link IdentifierImpl}.
	 * Its {@link IdentifiableElement} is set to the passed container and its id
	 * value is set to passed id.
	 * 
	 * @param container
	 *            {@link IdentifiableElement} which contains this
	 *            {@link Identifier}
	 * @param id
	 *            the id value of the {@link Identifier}
	 * @return new {@link Identifier} object
	 */
	public abstract Identifier createIdentifier(IdentifiableElement container, String id);

	/**
	 * Creates a new {@link Layer} object. A layer is a kind of a subgraph,
	 * which can contain nodes, relations and other layers.
	 * 
	 * @return new layer object
	 */
	public abstract Layer<Node, Relation<Node, Node>> createLayer();

}