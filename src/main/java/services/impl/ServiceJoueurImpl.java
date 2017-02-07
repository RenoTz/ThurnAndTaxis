package services.impl;

import services.ServiceJoueur;
import data.beans.secondaire.Player;

public class ServiceJoueurImpl implements ServiceJoueur {

    private Player playerEnCours;
    
    @Override
    public Player getPlayerEnCours() {
        return this.playerEnCours;
    }
    
    @Override
    public void setPlayerEnCours(Player playerEnCours) {
        this.playerEnCours = playerEnCours;
    }
    
}
