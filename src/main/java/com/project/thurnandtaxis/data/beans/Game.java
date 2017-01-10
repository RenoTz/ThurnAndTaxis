package com.project.thurnandtaxis.data.beans;

import java.util.List;

import com.google.common.collect.Lists;

public class Game {

    private List<Official> listeOfficials;
    private List<House> listeHouses;
    private List<Carriage> listeCarriages;
    private GameParams gameParams;
    private List<CityCard> listeCityCards;
    private List<Province> listeProvinces;
    private List<Adjacence> listeAdjacences;
    private Bonus bonus;

    public Game() {
        this.listeOfficials = Lists.newArrayList();
        this.listeHouses = Lists.newArrayList();
        this.listeCarriages = Lists.newArrayList();
        this.listeCityCards = Lists.newArrayList();
        this.listeProvinces = Lists.newArrayList();
        this.listeAdjacences = Lists.newArrayList();
    }

    public List<Official> getListeOfficials() {
        return this.listeOfficials;
    }

    public void setListeOfficials(List<Official> listeOfficials) {
        this.listeOfficials = listeOfficials;
    }

    public List<House> getListeHouses() {
        return this.listeHouses;
    }

    public void setListeHouses(List<House> listeHouses) {
        this.listeHouses = listeHouses;
    }

    public List<Carriage> getListeCarriages() {
        return this.listeCarriages;
    }

    public void setListeCarriages(List<Carriage> listeCarriages) {
        this.listeCarriages = listeCarriages;
    }

    public GameParams getGameParams() {
        return this.gameParams;
    }

    public void setGameParams(GameParams gameParams) {
        this.gameParams = gameParams;
    }

    public List<Province> getListeProvinces() {
        return this.listeProvinces;
    }

    public void setListeProvinces(List<Province> listeProvinces) {
        this.listeProvinces = listeProvinces;
    }

    public List<Adjacence> getListeAdjacences() {
        return this.listeAdjacences;
    }

    public void setListeAdjacences(List<Adjacence> listeAdjacences) {
        this.listeAdjacences = listeAdjacences;
    }

    public Bonus getBonus() {
        return this.bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
    
    public List<CityCard> getListeCityCards() {
        return this.listeCityCards;
    }
    
    public void setListeCityCards(List<CityCard> listeCityCards) {
        this.listeCityCards = listeCityCards;
    }
    
}
