package com.project.thurnandtaxis;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.beans.Official;
import com.project.thurnandtaxis.services.ParserXML;

public class Main {
    
    public static void main(String[] args) throws JSONException, IOException {
        
        final ParserXML parser = new ParserXML();
        
        final JSONObject jsonGameElements = parser.recupererGameElementsEnJSON("tutParams.xml");
        // parser.xmlToJson(jsonGameElements);
        
        List<Official> listeOfficials = parser.recupererListeOfficialsJSON(jsonGameElements.getJSONObject("officials"));

        for (Official official : listeOfficials) {
            System.out.println(official.getNom());
            System.out.println(official.getSymbolImage());
            System.out.println(official.getPersonImage());
            System.out.println("-------------------------------------------");
        }
        
    }
    
}
