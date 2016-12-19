package com.project.thurnandtaxis.data.beans;

import java.util.List;

public class Game {

    private List<Official> listeOfficials = null;
    private List<House> listeHouses = null;
    private List<Carriage> listeCarriages = null;
    private GameParams gameParams = null;
    private List<Province> listeProvinces = null;
    private List<Adjacence> listeAdjacences = null;
    private Bonus bonus = null;

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
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
    
}
