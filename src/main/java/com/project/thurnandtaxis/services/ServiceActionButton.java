package com.project.thurnandtaxis.services;

import java.util.List;

import com.project.thurnandtaxis.data.beans.secondaire.Adjacence;

public interface ServiceActionButton {

    void addActionButtonDeckCard();
    
    void addActionButtonCardVisible();
    
    void addActionButtonRules();

    void addActionButtonPlayersCards(final List<Adjacence> listAdjacences);
}
