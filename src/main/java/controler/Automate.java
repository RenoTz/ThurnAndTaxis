package controler;

import javax.swing.JOptionPane;

import services.ServiceActionButton;
import services.ServiceActionOfficials;
import services.ServiceCards;
import services.ServiceJoueur;
import services.impl.ServiceActionButtonImpl;
import services.impl.ServiceActionOfficialsImpl;
import services.impl.ServiceCardsImpl;
import services.impl.ServiceJoueurImpl;
import utils.PlayerUtils;
import data.beans.principal.AllItems;
import data.beans.principal.Game;
import data.beans.secondaire.Player;
import data.enumerations.EnumPlayers;

public class Automate {

    private AllItems allItems;
    
    private ServiceJoueur serviceJoueur;
    private ServiceCards serviceCards;
    private ServiceActionButton serviceActionButton;
    private ServiceActionOfficials serviceActionOfficials;

    public Automate(final AllItems allItems, final Sounds sounds) {
        this.allItems = allItems;
        this.serviceJoueur = new ServiceJoueurImpl();
        this.serviceCards = new ServiceCardsImpl();
        this.serviceActionButton = new ServiceActionButtonImpl(allItems, sounds);
        this.serviceActionOfficials = new ServiceActionOfficialsImpl(allItems, sounds);
    }
    
    public void demarrerUnePartie(final Game game) {
        
        // ------------------------
        // PREPARATION DE LA PARTIE
        // ------------------------
        // on melange les cartes
        this.serviceCards.shuffleListCards(game.getListCityCards());
        this.allItems.getAllListsCards().getListeCardsRemaining().addAll(game.getListCityCards());
        // mise en place des 6 cartes visibles
        this.serviceCards.addSixCardsVisible(this.allItems.getAllListsCards().getListCardsVisibles(), this.allItems.getAllListsCards()
                        .getListeCardsRemaining(), this.allItems.getAllLabels().getLblNbCardRemaining());
        
        this.serviceActionOfficials.removeActionAdministrator();
        // --------------------------
        // DEMARRAGE DES TOURS DE JEU
        // --------------------------
        while (PlayerUtils.aucunVainqueur(game.getListPlayers())) {

            double time = System.currentTimeMillis();
            
            // ------------
            // PREMIER TOUR
            // ------------
            // tous les joueurs doivent utiliser le PostMaster
            System.out.println("début du premier tour");
            while (this.premierTour(game, time)) {
            }
            System.out.println("fin du premier tour");
            // le joueur 1 commence
            this.serviceJoueur.setPlayerEnCours(game.getListPlayers().get(EnumPlayers.INDICE_PLAYER_1.getIndice()));
            final Player playerEnCours = this.serviceJoueur.getPlayerEnCours();
            System.out.println("Le joueur " + playerEnCours.getName() + " joue en ce moment.");
        }
        final Player winner = PlayerUtils.getWinner(game.getListPlayers());
        JOptionPane.showMessageDialog(null, winner.getName() + " has won !!!");
    }

    private boolean premierTour(final Game game, double time) {
        for (Player player : game.getListPlayers()) {
            System.out.println(player.getName() + " joue en ce moment.");
            // le joueur 1 commence
            this.serviceJoueur.setPlayerEnCours(player);
            System.out.println("Vous devez prendre une carte.");
            
            this.activerPaquetDeCartesEtCartesVisibles();
            while (!player.getActions().isTakeOneCard()) {
                time = this.uneSecondeDePause(time);
            }
            System.out.println("Vous avez pris une carte.");
            // désactivation du paquet de cartes et des cartes visibles
            this.desactiverPaquetDeCartesEtCartesVisibles();

            this.serviceJoueur.setPlayerEnCours(player);
            player.getActions().setTakeOneCard(false);
            System.out.println("Vous devez utiliser le Postmaster.");
            this.serviceActionOfficials.addActionPostmaster();
            boolean changementFait = false;
            while (!(player.getActions().isUsePostMaster() && player.getActions().isTakeOneCard())) {
                if (player.getActions().isUsePostMaster() && !changementFait) {
                    this.serviceActionOfficials.removeActionPostmaster();
                    // activation du paquet de cartes et des cartes visibles uniquement
                    this.activerPaquetDeCartesEtCartesVisibles();
                    changementFait = true;
                }
                time = this.uneSecondeDePause(time);
            }
            player.getActions().setUsePostMaster(false);
            player.getActions().setTakeOneCard(false);
            // désactivation du paquet de cartes et des cartes visibles
            this.desactiverPaquetDeCartesEtCartesVisibles();
            System.out.println("Vous avez utilisé le Postmaster.");
        }
        return false;
    }

    private void desactiverPaquetDeCartesEtCartesVisibles() {
        this.serviceActionButton.removeActionButtonDeckCard();
        this.serviceActionButton.removeActionVisibleCards();
    }

    private void activerPaquetDeCartesEtCartesVisibles() {
        this.serviceActionButton.addActionButtonDeckCard();
        this.serviceActionButton.addActionVisibleCards();
    }

    private double uneSecondeDePause(double time) {
        if (System.currentTimeMillis() > (time + 300)) {
            time = System.currentTimeMillis();
            System.out.print(".");
        }
        return time;
    }
}
