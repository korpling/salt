salt
====

With Salt we provide an easily understandable meta model for linguistic data and an open source api to store, manipulate and represent data. Salt is an abstract model, poor of linguistic semantics. As a result, it is free of any linguistic schools or theories. The core model is graph-based and therefore keeps the structural restrictions very low and allows for a wide range of possible linguistic annotations like syntactic, morphological, coreferential annotations and many more. You can even model your own very personal annotation as long as it fits into a graph structure (and so far we have not seen a linguistic annotation which does not). Furthermore, Salt does not depend on a specific linguistic tagset which allows you to use every tagset you like.

maven
===
You can also plug-in this api into your code via maven. 

```xml
<groupId>de.hu_berlin.german.korpling.saltnpepper</groupId>
<artifactId>salt</artifactId>
<version>VERSION</version>
```

To access the maven coordinates, you need to include our maven repoitory:

```xml
<repositories>
  <repository>
    <id>korpling</id>
    <name>korpling maven repo</name>
    <url>http://korpling.german.hu-berlin.de/maven2</url>
  </repository>
</repositories>
```

contribute
===
Please help us, to make the api better and give us feedback and send a bug report or a feature request. You can also write a mail to saltnpepper@lists.hu-berlin.de

license
===
  Copyright 2009 Humboldt University of Berlin, INRIA.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
