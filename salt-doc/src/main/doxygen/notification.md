# Notification {#notification}

Salt has the possibility to inform listeners about changes in the model. You can listen to changes of an individual object and to changes to all objects in a container. 
Notification means, that each object notifies a registered listener when an attribute or a contained object changed. A change can be one of the types defined in @ref org.corpus_tools.salt.extensions.notification.Listener#NOTIFICATION_TYPE and can affect one of the attributes defined in @ref org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES.  
To get notifications from a Salt model, you need to create a class implementing the interface @ref org.corpus_tools.salt.extensions.notification.Listener and to either add this listener to each object separately or you can pass the listener to the SaltNotificationFactory.   

~~~{.java}
SaltNotificationFactory factory = new SaltNotificationFactory();
SaltFactory.setFactory(factory);
factory.addListener(new Listener() {
    @Override
    public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
        System.out.println(type + ", " + attributes + ", " + oldValue + ", " + container);
	}
});
~~~ 

The notification mechanism is a part of the project salt-extensions and could be integrated via the delegator mechanism (see \ref delegator). 