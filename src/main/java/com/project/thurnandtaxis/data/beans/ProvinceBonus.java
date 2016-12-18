package com.project.thurnandtaxis.data.beans;

import java.util.List;

import com.google.common.collect.Lists;

public class ProvinceBonus {
    
    private String name;
    private List<Tile> tiles;
    
    public ProvinceBonus() {
        this.tiles = Lists.newArrayList();
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Tile> getTiles() {
        return this.tiles;
    }
    
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }
}
