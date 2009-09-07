<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xmi="http://www.omg.org/XMI" xmlns:sDocumentStructure="sDocumentStructure">
	
	<xsl:output method="text"/>
	
	<xsl:template match="/">
		<xsl:apply-templates/>
	</xsl:template>
		
	<!-- Matching template for SToken -->
	<xsl:template match="sDocumentStructure:SDocumentGraph/sTokens">
		<!-- compute posistion of token in list of tokens -->
		<xsl:variable name="tokPos">
			<xsl:call-template name="getTokPos">
				<xsl:with-param name="tokenId" select="@name" />
			</xsl:call-template>
		</xsl:variable>
		<!-- compute reference to token -->
		<xsl:variable name="tokRef"> 
			<xsl:value-of select="concat('//@sTokens.', $tokPos)"></xsl:value-of>
		</xsl:variable>
		
		<!-- compute start position of text -->
		<xsl:variable name="startPos"> 
			<xsl:value-of select="//sTextualRelations[@sToken=$tokRef]/@sStart"></xsl:value-of>
		</xsl:variable>
		
		<!-- compute end position of text -->
		<xsl:variable name="endPos"> 
			<xsl:value-of select="//sTextualRelations[@sToken=$tokRef]/@sEnd"></xsl:value-of>
		</xsl:variable>
			
		<xsl:variable name="text"> 
			<xsl:call-template name="getText">
				<xsl:with-param name="sTextualDS" select="//sTextualDSs" />
				<xsl:with-param name="startPos" select="$startPos" />
				<xsl:with-param name="endPos" select="$endPos" />
			</xsl:call-template>
  		</xsl:variable>
  		<xsl:value-of select="$text"></xsl:value-of>
		<xsl:apply-templates select="sAnnotations"/>
	</xsl:template>
	
	<!-- Matching template for SAnnotations -->
	<xsl:template match="sAnnotations">
		<xsl:text>&#9;</xsl:text>
		<xsl:value-of select="@SValue"></xsl:value-of>
	</xsl:template>
	
	<!-- Function to return the position of a given token in list of tokens-->
	<!-- parameter: tokPos= position of token in list of all tokens -->
	<xsl:template name= "getTokPos">
		<xsl:param name="tokenId"/>
		<!--  <xsl:value-of select="$tokenId"></xsl:value-of>-->
		<xsl:variable name="tokPosPre">
			<xsl:number/>
		</xsl:variable>
		<xsl:value-of select="$tokPosPre - 1"></xsl:value-of>
	</xsl:template>
	
	<!-- Function to return a text for a token -->
	<!-- parameter: startPos= start position of text -->
	<!-- parameter: endPos= end position of text -->
	<xsl:template name= "getText">
		<xsl:param name="sTextualDS"/>
		<xsl:param name="startPos"/>
		<xsl:param name="endPos"/>
		<xsl:variable name="text"> 
			<!-- <xsl:value-of select="substring(//sTextualDSs/@sText, $startPos, $endPos - $startPos)"/>-->
			<xsl:value-of select="substring($sTextualDS/@sText, $startPos, $endPos - $startPos)"/>
		</xsl:variable>
		<xsl:value-of select="$text"/>
	</xsl:template>
</xsl:stylesheet>
