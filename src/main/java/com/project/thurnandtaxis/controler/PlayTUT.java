package com.project.thurnandtaxis.controler;

import java.awt.Color;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.beans.AllButtons;
import com.project.thurnandtaxis.data.beans.AllLabels;
import com.project.thurnandtaxis.data.beans.AllListsCards;
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
        
        // 5.) on construit l'interface de jeu à partir des éléments du jeu
        final InterfaceJeu ihm = new InterfaceJeu();
        ihm.createInterface(game);
        
        // 6.a) agrégation des listes de cartes dans un bean
        final AllListsCards listsCards = new AllListsCards(game.getListCardsDiscarded(), game.getListCityCards(), ihm.getListeCardsRoad(),
                        ihm.getListeCardsVisible());
        
        // 6.b) agrégation de tous les boutons dans un bean
        final AllButtons allButtons = new AllButtons(ihm.getListeButtonsOfficials(), ihm.getListBonusButton(), ihm.getBtnDeckCard());
        
        // 6.c) agrégation de tous les labels dans un bean
        final AllLabels allLabels = new AllLabels(ihm.getLblNbCardRemaining());
        
        // 7. on ajoute les évènements sur les boutons
        final ServiceActionButton serviceActionButton = new ServiceActionButtonImpl(allButtons, allLabels, listsCards);
        // - bouton deckCard
        serviceActionButton.addActionButtonDeckCard(pDev, game.getListCityCards());
        // - boutons cards visibles
        serviceActionButton.addActionButtonCardVisible(pDev);
        // - officials
        final ServiceActionOfficials serviceActionOfficial = new ServiceActionOfficialsImpl(allButtons.getListOfficialsButtons(), listsCards,
                        allLabels);
        serviceActionOfficial.addActionButtonAdministrator(EnumOfficials.ADMINISTRATOR);
        serviceActionOfficial.addActionButtonCartwright(EnumOfficials.CARTWRIGHT);
        serviceActionOfficial.addActionButtonPostalCarrier(EnumOfficials.POSTAL_CARRIER);
        serviceActionOfficial.addActionButtonPostmaster(EnumOfficials.POSTMASTER);
        
    }
}
