package services;

import java.util.List;

import data.beans.secondaire.Adjacence;
import data.beans.secondaire.Player;

public interface ServiceActionButton {

    // ----------------- ACTIVATION ---------------------
    void addActionButtonDeckCard();
    
    void addActionVisibleCards();
    
    void addActionButtonRules();

    void addActionButtonPlayersCards(final List<Adjacence> listAdjacences, final List<Player> listPlayers);
    
    void addActionButtonDiscard();
    
    void addActionButtonBuild();
    
    // ---------------- DESACTIVATION -------------------

    void removeActionButtonDeckCard();

    void removeActionVisibleCards();
    
}
