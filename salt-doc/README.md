Salt Documentation
===================

Salt model guide
-----
The Salt model guide is written in docbook format and can be exported to html, pdf or eclipse help pages. The default settings export a pdf file to ./target/manual. To run the transformation execute
```
mvn site
```


Doxygen Documentation (including javadoc)
-----

To generate this documentation, you need to install Doxygen (http://www.doxygen.org).
The "doxygen" executable must be in the system path.

Then you can execute
```
mvn clean package -P doxygen
```
to compile everything. The result will be located in the "target/doxygen" folder.

