package controler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import services.ServiceActionButton;
import services.ServiceActionOfficials;
import services.ServiceCards;
import utils.PlayerUtils;
import data.beans.principal.AllItems;
import data.beans.principal.Game;
import data.beans.secondaire.Player;
import data.enumerations.EnumPlayers;

public class Automate {
    
	private boolean tourFini;
	
    private AllItems allItems;
    private static JLabel lblInfo;

    private ServiceCards serviceCards;
    private ServiceActionButton serviceActionButton;
    private ServiceActionOfficials serviceActionOfficials;
    
    public Automate(final AllItems allItems, final Sounds sounds) {
        this.allItems = allItems;
        lblInfo = allItems.getAllLabels().getLblInfo();
        this.serviceCards = new ServiceCards();
        this.serviceActionButton = new ServiceActionButton(allItems, sounds);
        this.serviceActionOfficials = new ServiceActionOfficials(allItems, sounds);
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

        // --------------------------
        // DEMARRAGE DES TOURS DE JEU
        // --------------------------
        boolean tourfini = false;
        
        while (PlayerUtils.aucunVainqueur(game.getListPlayers())) {
            
            double time = System.currentTimeMillis();

            // ------------
            // PREMIER TOUR
            // ------------
            // tous les joueurs doivent utiliser le PostMaster
            this.afficherInfoAvecPause("Début du premier tour");
            
            while (!isTourFini()) {
            	setTourFini(this.premierTour(game, time));
            }
            this.afficherInfoAvecPause("Fin du premier tour");
            // reinit indicateur tourFini
            setTourFini(false);
            // le joueur 1 commence
            PlayerUtils.setPlayerEnCours(game.getListPlayers().get(EnumPlayers.INDICE_PLAYER_1.getIndice()));
            this.afficherInfoAvecPause("C'est à " + PlayerUtils.getPlayerEnCours().getName() + " de jouer.");
            
            // -------------
            // DEUXIEME TOUR
            // -------------
            this.afficherInfoAvecPause("Début du deuxieme tour");
            
            while (!isTourFini()) {
            	setTourFini(true);// TODO
            }
            this.afficherInfoAvecPause("Fin du premier tour");
            // reinit indicateur tourFini
            setTourFini(false);
        }
        final Player winner = PlayerUtils.getWinner(game.getListPlayers());
        JOptionPane.showMessageDialog(null, winner.getName() + " has won !!!");
    }

    private void afficherInfoAvecPause(final String info) {
        lblInfo.setText(info);
        double timeStopped = System.currentTimeMillis();
        double currentTime = System.currentTimeMillis();
        while (currentTime < (timeStopped + 3000)) {
            currentTime = System.currentTimeMillis();
            if (currentTime > (timeStopped + 300)) {
                lblInfo.setText(lblInfo.getText() + ".");
            }
        }
    }
    
    private boolean premierTour(final Game game, double time) {
        for (Player player : game.getListPlayers()) {
            lblInfo.setText("C'est à " + player.getName() + " de jouer.");
            // le joueur 1 commence
            PlayerUtils.setPlayerEnCours(player);
            lblInfo.setText("Prendre une carte.");

            this.activerPaquetDeCartesEtCartesVisibles();
            while (!player.getActions().isTakeOneCard()) {
                time = uneSecondeDePause(time);
            }
            lblInfo.setText("Vous avez pris une carte.");
            // désactivation du paquet de cartes et des cartes visibles
            this.desactiverPaquetDeCartesEtCartesVisibles();
            
            PlayerUtils.setPlayerEnCours(player);
            player.getActions().setTakeOneCard(false);
            lblInfo.setText("Utiliser le Postmaster.");
            this.serviceActionOfficials.addActionPostmaster();
            boolean changementFait = false;
            while (!(player.getActions().isUsePostMaster() && player.getActions().isTakeOneCard())) {
                if (player.getActions().isUsePostMaster() && !changementFait) {
                    this.serviceActionOfficials.removeActionPostmaster();
                    // activation du paquet de cartes et des cartes visibles uniquement
                    this.activerPaquetDeCartesEtCartesVisibles();
                    changementFait = true;
                }
                time = uneSecondeDePause(time);
            }
            player.getActions().setUsePostMaster(false);
            player.getActions().setTakeOneCard(false);
            // désactivation du paquet de cartes et des cartes visibles
            this.desactiverPaquetDeCartesEtCartesVisibles();
            lblInfo.setText("Vous avez utilisé le Postmaster.");
        }
        return true;
    }
    
    private void desactiverPaquetDeCartesEtCartesVisibles() {
        this.serviceActionButton.removeActionButtonDeckCard();
        this.serviceActionButton.removeActionVisibleCards();
    }
    
    private void activerPaquetDeCartesEtCartesVisibles() {
        this.serviceActionButton.addActionButtonDeckCard();
        this.serviceActionButton.addActionVisibleCards();
    }
    
    private static double uneSecondeDePause(double time) {
        if (System.currentTimeMillis() > (time + 300)) {
            time = System.currentTimeMillis();
            lblInfo.setText(lblInfo.getText() + ".");
        }
        return time;
    }

	public boolean isTourFini() {
		return tourFini;
	}

	public void setTourFini(boolean tourFini) {
		this.tourFini = tourFini;
	}
}
