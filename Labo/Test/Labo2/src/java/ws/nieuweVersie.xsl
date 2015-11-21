<?xml version="1.0"?>

<!--
    Document   : nieuweVersie.xsl
    Created on : November 21, 2015, 11:42 AM
    Author     : bjorn
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:ns2="http://ws/">
    <xsl:output method="xml"/>
    <xsl:template match="/">
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="ns2:solveQuadratic">
        <ns2:solveQuadratic xmlns:ns2="http://ws/">
            <xsl:apply-templates/>
        </ns2:solveQuadratic>
    </xsl:template>
    <xsl:template match="a|c1">
        <c1><xsl:value-of select="."/></c1>
    </xsl:template>
    <xsl:template match="b|c2">
        <c2><xsl:value-of select="."/></c2>
    </xsl:template>
    <xsl:template match="c|c3">
        <c3><xsl:value-of select="."/></c3>
    </xsl:template>
</xsl:stylesheet>
