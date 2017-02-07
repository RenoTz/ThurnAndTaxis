package controler;

import java.awt.Color;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import services.ServiceActionButton;
import services.ServiceLoading;
import services.impl.ServiceActionButtonImpl;
import services.parser.ParserJSON;
import view.InterfaceJeu;
import data.beans.principal.AllItems;
import data.beans.principal.Game;
import data.beans.secondaire.Player;
import data.constantes.ConstantesStatics;

public class Play {

    public static void main(String[] args) throws JSONException, IOException {

        // 1. on parse le fichier xml avec un convertisseur Json
        final ParserJSON parser = new ParserJSON();
        final JSONObject jsonGameElements = parser.recupererGameElementsEnJSON(ConstantesStatics.FILENAME_PARAMS);

        // 2.a) on récupère et on construit les éléments du jeu à partir du json
        final ServiceLoading loading = new ServiceLoading();
        final Game game = loading.chargerTousLesParametresDuJeuDepuisFichier(jsonGameElements);

        // 2.b) on crée les sons du jeu
        final Sounds sounds = new Sounds();

        // 3. Création des joueurs (seulement 1 dans un premier temps -> pour le développement)
        final Player pDev = new Player();
        pDev.setColor(Color.BLUE);
        pDev.setName("Gaston");
        game.getListPlayers().add(pDev);

        // 4.) on construit l'interface de jeu à partir des éléments du jeu
        final InterfaceJeu ihm = new InterfaceJeu();
        final AllItems allItems = ihm.createInterface(game);
        
        // 6. on ajoute les évènements sur les boutons
        final ServiceActionButton serviceActionButton = new ServiceActionButtonImpl(allItems, sounds);
        serviceActionButton.addActionButtonPlayersCards(game.getListAdjacences(), game.getListPlayers());
        serviceActionButton.addActionButtonDiscard();
        
        // CYCLE DE JEU
        final Automate automate = new Automate(allItems, sounds);
        automate.demarrerUnePartie(game);
        
    }
}
