package data.beans.secondaire;

import java.awt.Color;
import java.util.List;

import com.google.common.collect.Lists;

public class Player {

    private String name;
    private Color color;
    private List<House> listeHouses;
    private List<CityCard> listHandCityCards;
    private List<CityCard> listRoadCityCards;
    private List<Bonus> listeBonus;
    private Long points;
    private boolean won;

    public Player() {
        this.listHandCityCards = Lists.newArrayList();
        this.listRoadCityCards = Lists.newArrayList();
        this.listeBonus = Lists.newArrayList();
    }

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

    public List<CityCard> getListHandCityCards() {
        return this.listHandCityCards;
    }

    public void setListHandCityCards(List<CityCard> listHandCityCards) {
        this.listHandCityCards = listHandCityCards;
    }

    public List<CityCard> getListRoadCityCards() {
        return this.listRoadCityCards;
    }

    public void setListRoadCityCards(List<CityCard> listRoadCityCards) {
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
    
    public boolean isWon() {
        return this.won;
    }
    
    public void setWon(boolean won) {
        this.won = won;
    }

}
