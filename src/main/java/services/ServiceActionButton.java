package services;

import java.util.List;

import data.beans.secondaire.Adjacence;
import data.beans.secondaire.Player;

public interface ServiceActionButton {

    void addActionButtonDeckCard();
    
    void addActionButtonCardVisible();
    
    void addActionButtonRules();

    void addActionButtonPlayersCards(final List<Adjacence> listAdjacences, final List<Player> listPlayers);
    
    void addActionButtonDiscard();
    
    void addActionButtonBuild();
    
    Player getPlayerEnCours();
    
    void setPlayerEnCours(Player playerEnCours);
}
