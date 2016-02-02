## Bidirectional references {#dev_bidirectionalReferences}

In Salt a lot of references between two objects are bidirectional. Bidirectional means, that object A refers to object B and object B refers to object A. 

Where such bidirectional references are used, you can find in \ref bidirectionalReferences.

To realize a bidirectional reference a reference in both objects _A_ and _B_ needs to be created and automatically updated on the other side. Which means, when  a reference for _A_ is created to _B_, a reference from _B_ to a is created automatically. To do so, we need a split of the method A.setB(B) into the public method A.setB(B) and the private method A.basicSetB(B). The same goes for B.setA(A). This is necessary to not create an endless loop. 

~~~
class A                         class B
=======                         =======

A.setB(B)                       B.setA(A)
   ||             \ /              ||
   ||              X               ||
   \/             / \              \/
A.basicSetB(B)                  B.basicSetA(A)
~~~

In many cases for instances between Graph and Node we have a 1:n-relation instead of a 1:1-relation. For these cases, the container object has a add method for instance A.addB(B). This is split into A.addB(B) and A.basicAddB(B). The same goes for A.removeB(B).
 