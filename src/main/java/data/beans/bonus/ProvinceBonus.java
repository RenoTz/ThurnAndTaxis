package data.beans.bonus;

import java.util.List;

import com.google.common.collect.Lists;

import data.beans.secondaire.Tile;

public class ProvinceBonus {
    
    private List<String> listeNames;
    private List<Tile> tiles;
    
    public ProvinceBonus() {
        this.listeNames = Lists.newArrayList();
        this.tiles = Lists.newArrayList();
    }
    
    public List<String> getListNames() {
        return this.listeNames;
    }
    
    public void setListeNames(List<String> listeNames) {
        this.listeNames = listeNames;
    }
    
    public List<Tile> getTiles() {
        return this.tiles;
    }
    
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }
}
