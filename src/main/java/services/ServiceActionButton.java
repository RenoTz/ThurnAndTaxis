package services;

import java.util.List;

import data.beans.secondaire.Adjacence;

public interface ServiceActionButton {

    void addActionButtonDeckCard();
    
    void addActionButtonCardVisible();
    
    void addActionButtonRules();

    void addActionButtonPlayersCards(final List<Adjacence> listAdjacences);
}
