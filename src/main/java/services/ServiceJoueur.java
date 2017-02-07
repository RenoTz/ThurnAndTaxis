package services;

import data.beans.secondaire.Player;

public interface ServiceJoueur {

    Player getPlayerEnCours();
    
    void setPlayerEnCours(Player playerEnCours);
    
}
