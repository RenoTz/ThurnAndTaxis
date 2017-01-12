package com.project.thurnandtaxis.services;

import java.util.List;

import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;

public interface ServiceActionButton {

    void addActionButtonDeckCard(final Player player, final List<CityCard> listCardRemaining);
    
    void addActionButtonCardVisible(Player player);
}
