#Salt

With Salt we provide an easily understandable meta model for linguistic data and an open source api to store, manipulate and represent data. Salt is an abstract model, poor of linguistic semantics. As a result, it is free of any linguistic schools or theories. The core model is graph-based and therefore keeps the structural restrictions very low and allows for a wide range of possible linguistic annotations like syntactic, morphological, coreferential annotations and many more. You can even model your own very personal annotation as long as it fits into a graph structure (and so far we have not seen a linguistic annotation which does not). Furthermore, Salt does not depend on a specific linguistic tagset which allows you to use every tagset you like.

##Maven

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
##Coorperations

Known projects using Salt:<br/>
[ANNIS](http://www.sfb632.uni-potsdam.de/annis/index.html) - ANNIS: Search and Visualization in Multilayer Linguistic Corpora<br/>
[ATOMIC](http://linktype.iaa.uni-jena.de/atomic/) - Atomic: A tool for multilevel corpus annotation <br/>
[Pepper](http://u.hu-berlin.de/saltnpepper) - Pepper: A multi converter framework for linguistic data


##Contribute

Please help us, to make the api better and give us feedback and send a bug report or a feature request. You can also write a mail to saltnpepper@lists.hu-berlin.de


##Funders

This project has been funded by several institutions:

<table>
  <tr>
    <td><a href="https://www.linguistik.hu-berlin.de/institut/professuren/korpuslinguistik/standardseite-en?set_language=en&cl=en"><img width="100" src="https://www.linguistik.hu-berlin.de/institut/professuren/korpuslinguistik/forschung/whig/Inhalte/609px-Huberlin-logo.svg.jpg"/></a></td> 
    <td><a href="https://www.linguistik.hu-berlin.de/institut/professuren/korpuslinguistik/standardseite-en?set_language=en&cl=en">Humboldt-Universität zu Berlin, department of corpus linguistics and morphology</a></td>
  </tr>
  <tr>
    <td><a href="http://www.inria.fr/en"><img width="150" src="http://www.inria.fr/extension/site_inria/design/site_inria/images/logos/logo_INRIA_en.png"/></a></td> 
    <td><a href="http://www.inria.fr/en">Institut national de recherche en informatique et en automatique (INRIA)</a></td>
  </tr>
  <tr>
    <td><a href="https://www.sfb632.uni-potsdam.de/en/"><img width="100" src="https://www.sfb632.uni-potsdam.de/images/SFB-Bilder/bridge_big.jpg"/></a></td> 
    <td><a href="https://www.sfb632.uni-potsdam.de/en/">Sonderforschungsbereich 632, Information structure: The linguistic means for structuring utterances, sentences and texts </a></td>
  </tr>
  <tr>
    <td><a href="http://www.dfg.de/en/"><img src="http://www.dfg.de/includes/images/dfg_logo.gif"/></a></td> 
    <td><a href="http://www.dfg.de/en/">Deutsche Forschungsgemeinschaft</a></td>
  </tr>
  <tr>
    <td><a href="http://de.clarin.eu/en/"><img width="100" src="http://www.bbaw.de/forschung/clarin/uebersicht/bild"/></a></td> 
    <td><a href="http://de.clarin.eu/en/">CLARIN-D</a></td>
  </tr>
</table>


##License

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
