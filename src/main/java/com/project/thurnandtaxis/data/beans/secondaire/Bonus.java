package com.project.thurnandtaxis.data.beans.secondaire;

import java.util.List;

import com.google.common.collect.Lists;

public class Bonus {
    
    private List<ProvinceBonus> listeProvincesBonus;
    private ProvinceBonus allProvincesBonus;
    private List<Tile> longRouteBonus;
    private List<Tile> endGameBonus;

    public Bonus() {
        this.listeProvincesBonus = Lists.newArrayList();
        this.longRouteBonus = Lists.newArrayList();
        this.endGameBonus = Lists.newArrayList();
    }
    
    public List<ProvinceBonus> getListeProvincesBonus() {
        return this.listeProvincesBonus;
    }
    
    public void setListeProvincesBonus(List<ProvinceBonus> listeProvincesBonus) {
        this.listeProvincesBonus = listeProvincesBonus;
    }
    
    public ProvinceBonus getAllProvincesBonus() {
        return this.allProvincesBonus;
    }
    
    public void setAllProvincesBonus(ProvinceBonus allProvincesBonus) {
        this.allProvincesBonus = allProvincesBonus;
    }
    
    public List<Tile> getLongRouteBonus() {
        return this.longRouteBonus;
    }
    
    public void setLongRouteBonus(List<Tile> longRouteBonus) {
        this.longRouteBonus = longRouteBonus;
    }
    
    public List<Tile> getEndGameBonus() {
        return this.endGameBonus;
    }
    
    public void setEndGameBonus(List<Tile> endGameBonus) {
        this.endGameBonus = endGameBonus;
    }
}
