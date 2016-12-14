package com.project.thurnandtaxis.services;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ParserXML {
    
    public Document recupererFichierXML(final String nomFichier) {
        
        final DocumentBuilder builderXML = this.creerParserXML();
        
        Document document = null;
        try {
            document = builderXML.parse(new File(nomFichier));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        
        return document;
    }

    private DocumentBuilder creerParserXML() {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder;
    }
    
}
