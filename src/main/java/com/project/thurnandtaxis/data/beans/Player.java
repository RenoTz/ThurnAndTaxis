package com.project.thurnandtaxis.data.beans;

import java.awt.Color;
import java.util.List;

public class Player {
    
    private String name;
    private Color color;
    private List<House> listeHouses;
    private List<City> listHandCityCards;
    private List<City> listRoadCityCards;
    private List<Bonus> listeBonus;
    private Long points;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public List<House> getListeHouses() {
        return this.listeHouses;
    }
    
    public void setListeHouses(List<House> listeHouses) {
        this.listeHouses = listeHouses;
    }
    
    public List<City> getListHandCityCards() {
        return this.listHandCityCards;
    }
    
    public void setListHandCityCards(List<City> listHandCityCards) {
        this.listHandCityCards = listHandCityCards;
    }
    
    public List<City> getListRoadCityCards() {
        return this.listRoadCityCards;
    }
    
    public void setListRoadCityCards(List<City> listRoadCityCards) {
        this.listRoadCityCards = listRoadCityCards;
    }
    
    public List<Bonus> getListeBonus() {
        return this.listeBonus;
    }
    
    public void setListeBonus(List<Bonus> listeBonus) {
        this.listeBonus = listeBonus;
    }
    
    public Long getPoints() {
        return this.points;
    }
    
    public void setPoints(Long points) {
        this.points = points;
    }

}
