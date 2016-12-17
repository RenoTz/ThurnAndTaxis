package com.project.thurnandtaxis.controler;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.services.ParserJSON;

public class Main {
    
    public static void main(String[] args) throws JSONException, IOException {
        
        final ParserJSON parser = new ParserJSON();
        final JSONObject jsonGameElements = parser.recupererGameElementsEnJSON(ConstantesStatics.RACINE_STATICS_XML + "tutParams.xml");
        
        final GameLoading gameLoading = new GameLoading(jsonGameElements);
    }
    
}
