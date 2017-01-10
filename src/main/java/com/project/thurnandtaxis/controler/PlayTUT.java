package com.project.thurnandtaxis.controler;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.beans.Player;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.services.ParserJSON;
import com.project.thurnandtaxis.services.ServiceActionButton;
import com.project.thurnandtaxis.services.ServiceLoading;
import com.project.thurnandtaxis.utils.CardsUtils;

public class PlayTUT {
    
    public static void main(String[] args) throws JSONException, IOException {
        
        // 1. on parse le fichier xml avec un convertisseur Json
        final ParserJSON parser = new ParserJSON();
        final JSONObject jsonGameElements = parser.recupererGameElementsEnJSON(ConstantesStatics.FILENAME_PARAMS);
        
        // 2. on récupère et on construit les éléments du jeu à partir du json
        final ServiceLoading loading = new ServiceLoading();
        final Game game = loading.chargerTousLesParametresDuJeuDepuisFichier(jsonGameElements);
        
        // 3. on effectue les taches de préparation du jeu
        CardsUtils.melangerLesCartes(game.getListeCityCards());

        // 4. Création des joueurs (seulement 1 dans un premier temps -> pour le développement)
        final List<Player> listPlayer = Lists.newArrayList();
        final Player pDev = new Player();
        pDev.setColor(Color.BLUE);
        pDev.setName("Gaston");
        listPlayer.add(pDev);

        // 4. on construit l'interface de jeu à partir des éléments du jeu
        final InterfaceJeu ihm = new InterfaceJeu(game, listPlayer);
        final ServiceActionButton serviceActionButton = new ServiceActionButton();
        serviceActionButton.addActionButtonDeckCard(ihm.getBtnDeckCard(), listPlayer.get(0), game.getListeCityCards());
        
    }
}
