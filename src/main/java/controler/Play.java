package controler;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import services.ServiceActionButton;
import services.ServiceActionOfficials;
import services.ServiceCards;
import services.ServiceLoading;
import services.impl.ServiceActionButtonImpl;
import services.impl.ServiceActionOfficialsImpl;
import services.impl.ServiceCardsImpl;
import services.parser.ParserJSON;
import data.beans.principal.AllItems;
import data.beans.principal.AllPlayers;
import data.beans.principal.Game;
import data.beans.secondaire.Player;
import data.constantes.ConstantesStatics;
import data.enumerations.EnumOfficials;

public class Play {

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
        serviceActionButton.addActionButtonPlayersCards(game.getListAdjacences());
        serviceActionButton.addActionButtonDiscard();
        // a) cards visibles
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

        // CYCLE DE JEU
        while (AllPlayers.aucunVainqueur(game.getAllPlayers())) {
            
        }
        Player winner = game.getAllPlayers().getWinner();
        JOptionPane.showMessageDialog(null, winner.getName() + " has won !!!");
        
    }

}
