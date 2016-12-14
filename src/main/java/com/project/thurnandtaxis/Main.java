package com.project.thurnandtaxis;

import com.project.thurnandtaxis.services.ParserXML;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ParserXML parser = new ParserXML();
        parser.recupererFichierXML("tutParams.xml");
    }

}
