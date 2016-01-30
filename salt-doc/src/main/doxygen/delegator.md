# Expanding Salt {#delegator}

Salt offers the possibility via the use of the [delegator pattern](https://en.wikipedia.org/wiki/Delegation_pattern), to extend the behavior of its base types: org.corpus_tools.salt.graph.Graph, org.corpus_tools.salt.graph.Node, org.corpus_tools.salt.graph.Relation, org.corpus_tools.salt.graph.Layer and org.corpus_tools.salt.graph.Label. In short words: 

_the delegation pattern is a design pattern in object-oriented programming where an object, instead of performing one of its stated tasks, delegates that task to an associated helper object. (see: https://en.wikipedia.org/wiki/Delegation_pattern)_

The object which delegates its tasks is called the _delegator_ and the object which performs the task is called the _delegate_. 
In Salt, the delegate is injected into the delegator on its creation time. Therefore all objects provide a constructor, which consumes the delegate as a parameter. You can use one of the extensions provided in the _salt-extensions_ project or create your own extensions. Usually an extension comes with a specific factory which injects the delegate into the delegator. For instance to use the notification mechanism of Salt (see \ref notification) you need to exchange Salt's factory implementation:

~~~{.java}
SaltNotificationFactory factory = new SaltNotificationFactory();
SaltFactory.setFactory(factory);
~~~

Now Salt's factory does not use the default factory org.corpus_tools.salt.impl.SaltFactoryImpl anymore, it uses the set factory instead. Each factory must implement the interface org.corpus_tools.salt.ISaltFactory. This enables, that every object which is created is created by the new factory and therefore code parts do not need to be changed and adapted to the extension. In our case, when using the org.corpus_tools.salt.extensions.notification.SaltNotificationFactory each created object will create a notification about a change in the object and will notify a registered listener.
The extension of Salt via the delegator pattern is a very powerful mechanism, further extensions will be developed to change the behavior of Salt. You can also create your own extensions to do so.   

You just need to create an implementation of Salt's base types:
* org.corpus_tools.salt.graph.Graph, 
* org.corpus_tools.salt.graph.Node, 
* org.corpus_tools.salt.graph.Relation, 
* org.corpus_tools.salt.graph.Layer and 
* org.corpus_tools.salt.graph.Label.

And adapt their behavior as needed. For instance if you need an extended behavior of the type org.corpus_tools.salt.common.SToken you can create the following class and overwrite the interesting methods:

~~~{.java}
...
public class MyNode extends NodeImpl implements Node{

   /**
	 * Change behavior of addLabel
	 **/
	@Override
	public void addLabel(Label label) {
	   //do something new
	   // eventually call super to keep old behavior
	   super.addLabel(label)
	}
}
~~~

When this was done, you need to create a new factory which creates all types in Salt and inject your delegate into the delegator. Therefore delegate needs to be derived from the same super class as the delegator:

~~~{.java}
public class SaltNotificationFactory extends SaltFactoryImpl implements ISaltFactory{
	
	...
	
	/** Creates a token with a new behavior when adding a label (annotation) **/
	@Override
	public SToken createSToken() {
		return (new STokenImpl(new MyNode()));
	} 
	...
}
~~~