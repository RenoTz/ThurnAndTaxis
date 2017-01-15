package com.project.thurnandtaxis.controler;

import java.awt.Color;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.beans.principal.AllItems;
import com.project.thurnandtaxis.data.beans.principal.Game;
import com.project.thurnandtaxis.data.beans.secondaire.Player;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;
import com.project.thurnandtaxis.services.ServiceActionButton;
import com.project.thurnandtaxis.services.ServiceActionOfficials;
import com.project.thurnandtaxis.services.ServiceCards;
import com.project.thurnandtaxis.services.ServiceLoading;
import com.project.thurnandtaxis.services.impl.ServiceActionButtonImpl;
import com.project.thurnandtaxis.services.impl.ServiceActionOfficialsImpl;
import com.project.thurnandtaxis.services.impl.ServiceCardsImpl;
import com.project.thurnandtaxis.services.parser.ParserJSON;

public class PlayTUT {
    
    public static void main(String[] args) throws JSONException, IOException {
        
        // 1. on parse le fichier xml avec un convertisseur Json
        final ParserJSON parser = new ParserJSON();
        final JSONObject jsonGameElements = parser.recupererGameElementsEnJSON(ConstantesStatics.FILENAME_PARAMS);
        
        // 2. on récupère et on construit les éléments du jeu à partir du json
        final ServiceLoading loading = new ServiceLoading();
        final Game game = loading.chargerTousLesParametresDuJeuDepuisFichier(jsonGameElements);
        
        // 3. Création des joueurs (seulement 1 dans un premier temps -> pour le développement)
        final Player pDev = new Player();
        pDev.setColor(Color.BLUE);
        pDev.setName("Gaston");
        game.getAllPlayers().setPlayer1(pDev);
        
        // 4.) on construit l'interface de jeu à partir des éléments du jeu
        final InterfaceJeu ihm = new InterfaceJeu();
        final AllItems allItems = ihm.createInterface(game);

        final ServiceCards serviceCards = new ServiceCardsImpl();
        serviceCards.shuffleListCards(game.getListCityCards());
        allItems.getAllListsCards().getListeCardsRemaining().addAll(game.getListCityCards());
        
        // 6. on ajoute les évènements sur les boutons
        final ServiceActionButton serviceActionButton = new ServiceActionButtonImpl(allItems, game.getAllPlayers());
        serviceActionButton.addActionButtonDeckCard();
        serviceActionButton.addActionButtonRules();
        // a) boutons cards visibles
        serviceActionButton.addActionButtonCardVisible();
        // b) officials
        final ServiceActionOfficials serviceActionOfficial = new ServiceActionOfficialsImpl(allItems);
        serviceActionOfficial.addActionButtonAdministrator(EnumOfficials.ADMINISTRATOR);
        serviceActionOfficial.addActionButtonCartwright(EnumOfficials.CARTWRIGHT);
        serviceActionOfficial.addActionButtonPostalCarrier(EnumOfficials.POSTAL_CARRIER);
        serviceActionOfficial.addActionButtonPostmaster(EnumOfficials.POSTMASTER);
        
        // 7.
        // mise en place des 6 cards visible
        serviceCards.addSixCardsVisible(allItems.getAllListsCards().getListCardsVisibles(),
                        allItems.getAllListsCards().getListeCardsRemaining(), allItems.getAllLabels().getLblNbCardRemaining());
    }
}
