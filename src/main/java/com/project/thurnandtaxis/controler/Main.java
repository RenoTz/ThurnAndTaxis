package com.project.thurnandtaxis.controler;

import java.io.IOException;

import javassist.NotFoundException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.services.ParserJSON;
import com.project.thurnandtaxis.services.ServiceLoading;

public class Main {
    
    public static void main(String[] args) throws JSONException, IOException, NotFoundException {
        
        final ParserJSON parser = new ParserJSON();
        final JSONObject jsonGameElements = parser.recupererGameElementsEnJSON(ConstantesStatics.FILENAME_PARAMS);
        
        final ServiceLoading loading = new ServiceLoading();
        Game game = null;
        try {
            game = loading.chargerTousLesParametresDuJeu(jsonGameElements);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
        
        final InterfaceJeu fenetre = new InterfaceJeu(game);
    }
    
}
