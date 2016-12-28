package com.project.thurnandtaxis.controler;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.services.ParserJSON;
import com.project.thurnandtaxis.services.ServiceLoading;

public class PlayTUT {
    
    public static void main(String[] args) throws JSONException, IOException {
        
        // 1. on parse le fichier xml avec un convertisseur Json
        final ParserJSON parser = new ParserJSON();
        final JSONObject jsonGameElements = parser.recupererGameElementsEnJSON(ConstantesStatics.FILENAME_PARAMS);
        
        // 2. on récupère et on construit les éléments du jeu à partir du json
        final ServiceLoading loading = new ServiceLoading();
        final Game game = loading.chargerTousLesParametresDuJeu(jsonGameElements);
        
        // 3. on construit l'interface de jeu
        // final InterfaceJeu fenetre = new InterfaceJeu();
        // fenetre.createInterfaceToPlay(game);
        final InterfaceTest iTest = new InterfaceTest();
    }
    
}
