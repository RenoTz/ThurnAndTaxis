package controler;

import model.beans.principal.AllItems;
import model.beans.principal.Game;
import model.beans.secondaire.Player;
import model.enumerations.EnumPlayers;
import services.ServiceActionButton;
import services.ServiceActionOfficials;
import services.ServiceCards;
import utils.PlayerUtils;

import javax.swing.*;

public class Automate {

	private boolean tourFini;

	private final AllItems allItems;
	private static JLabel lblInfo;

	private final ServiceCards serviceCards;
	private final ServiceActionButton serviceActionButton;
	private final ServiceActionOfficials serviceActionOfficials;

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
        serviceCards.shuffleListCards(game.getCityCards());
        allItems.getAllListsCards().getCardsRemaining().addAll(game.getCityCards());
		// mise en place des 6 cartes visibles
        serviceCards.addSixCardsVisible(allItems.getAllListsCards().getCardsVisible(),
            allItems.getAllListsCards()
                .getCardsRemaining(),
            allItems.getAllLabels().getLblNbCardRemaining());

		// --------------------------
		// DEMARRAGE DES TOURS DE JEU
		// --------------------------
		final boolean tourfini = false;

        while (PlayerUtils.aucunVainqueur(game.getPlayers())) {

			final double time = System.currentTimeMillis();

			// ------------
			// PREMIER TOUR
			// ------------
			// tous les joueurs doivent utiliser le PostMaster
            showInfoDuringThreeSeconds("Début du premier tour");

            while (!isTourFini()) {
                setTourFini(premierTour(game, time));
			}
            showInfoDuringThreeSeconds("Fin du premier tour");
			// reinit indicateur tourFini
            setTourFini(false);
			// le joueur 1 commence
            PlayerUtils.setPlayerEnCours(game.getPlayers().get(EnumPlayers.INDICE_PLAYER_1.getIndice()));
            showInfoDuringThreeSeconds("C'est à " + PlayerUtils.getPlayerEnCours().getName() + " de jouer.");

			// -------------
			// DEUXIEME TOUR
			// -------------
            showInfoDuringThreeSeconds("Début du deuxieme tour");

            while (!isTourFini()) {
                setTourFini(true);// TODO
			}
            showInfoDuringThreeSeconds("Fin du premier tour");
			// reinit indicateur tourFini
            setTourFini(false);
		}
        final Player winner = PlayerUtils.getWinner(game.getPlayers());
		JOptionPane.showMessageDialog(null, winner.getName() + " has won !!!");
	}

    private void showInfoDuringThreeSeconds(final String info) {
		lblInfo.setText(info);
		final double timeStopped = System.currentTimeMillis();
		double currentTime = System.currentTimeMillis();
		while (currentTime < (timeStopped + 3000)) {
			currentTime = System.currentTimeMillis();
            if (currentTime > (timeStopped + 3000)) {
				lblInfo.setText(lblInfo.getText() + ".");
			}
		}
	}

	private boolean premierTour(final Game game, double time) {
        for (final Player player : game.getPlayers()) {
			lblInfo.setText("C'est à " + player.getName() + " de jouer.");
			// le joueur 1 commence
			PlayerUtils.setPlayerEnCours(player);
			lblInfo.setText("Prenez une carte.");

            activerPaquetDeCartesEtCartesVisibles();
			while (!player.getActions().isTakeOneCard()) {
				time = uneSecondeDePause(time);
			}
			lblInfo.setText("Vous avez pris une carte.");
			// désactivation du paquet de cartes et des cartes visibles
            desactiverPaquetDeCartesEtCartesVisibles();

			PlayerUtils.setPlayerEnCours(player);
			player.getActions().setTakeOneCard(false);
			lblInfo.setText("Utiliser le Postmaster.");
            serviceActionOfficials.addActionPostmaster();
			boolean changementFait = false;
			while (!(player.getActions().isUsePostMaster() && player.getActions().isTakeOneCard())) {
				if (player.getActions().isUsePostMaster() && !changementFait) {
                    serviceActionOfficials.removeActionPostmaster();
					// activation du paquet de cartes et des cartes visibles uniquement
                    activerPaquetDeCartesEtCartesVisibles();
					changementFait = true;
				}
				time = uneSecondeDePause(time);
			}
			player.getActions().setUsePostMaster(false);
			player.getActions().setTakeOneCard(false);
			// désactivation du paquet de cartes et des cartes visibles
            desactiverPaquetDeCartesEtCartesVisibles();
			lblInfo.setText("Vous avez utilisé le Postmaster.");
		}
		return true;
	}

	private void desactiverPaquetDeCartesEtCartesVisibles() {
        serviceActionButton.removeActionButtonDeckCard();
        serviceActionButton.removeActionVisibleCards();
	}

	private void activerPaquetDeCartesEtCartesVisibles() {
        serviceActionButton.addActionButtonDeckCard();
        serviceActionButton.addActionVisibleCards();
	}

	private static double uneSecondeDePause(double time) {
		if (System.currentTimeMillis() > (time + 300)) {
			time = System.currentTimeMillis();
		}
		return time;
	}

	public boolean isTourFini() {
        return tourFini;
	}

	public void setTourFini(final boolean tourFini) {
		this.tourFini = tourFini;
	}
}
