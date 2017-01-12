package com.project.thurnandtaxis.controler;

import java.awt.Color;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.beans.Player;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;
import com.project.thurnandtaxis.services.ServiceActionButton;
import com.project.thurnandtaxis.services.ServiceActionOfficials;
import com.project.thurnandtaxis.services.ServiceLoading;
import com.project.thurnandtaxis.services.impl.ServiceActionButtonImpl;
import com.project.thurnandtaxis.services.impl.ServiceActionOfficialsImpl;
import com.project.thurnandtaxis.services.parser.ParserJSON;
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
        CardsUtils.melangerLesCartes(game.getListCityCards());

        // 4. Création des joueurs (seulement 1 dans un premier temps -> pour le développement)
        final Player pDev = new Player();
        pDev.setColor(Color.BLUE);
        pDev.setName("Gaston");
        game.getListPlayers().add(pDev);

        // 4. on construit l'interface de jeu à partir des éléments du jeu
        final InterfaceJeu ihm = new InterfaceJeu();
        ihm.createInterface(game);
        
        // 5. on ajoute les évènements sur les boutons
        final ServiceActionButton serviceActionButton = new ServiceActionButtonImpl(ihm.getBtnDeckCard(), ihm.getLblNbCardRemaining(),
                        ihm.getListeCardsHand(), ihm.getListeCardsRoad(), game.getListCardsDiscarded(), ihm.getListeCardsVisible());
        // - bouton deckCard
        serviceActionButton.addActionButtonDeckCard(game.getListPlayers().get(0), game.getListCityCards());
        // - boutons cards visibles
        serviceActionButton.addActionButtonCardVisible(pDev);
        // - officials
        final ServiceActionOfficials serviceActionOfficial = new ServiceActionOfficialsImpl(ihm.getListeButtonsOfficials(),
                        ihm.getListeCardsVisible(), game.getListCardsDiscarded(), game.getListCityCards());
        serviceActionOfficial.addActionButtonAdministrator(EnumOfficials.ADMINISTRATOR);
        serviceActionOfficial.addActionButtonCartwright(EnumOfficials.CARTWRIGHT);
        serviceActionOfficial.addActionButtonPostalCarrier(EnumOfficials.POSTAL_CARRIER);
        serviceActionOfficial.addActionButtonPostmaster(EnumOfficials.POSTMASTER);
        
    }
}
