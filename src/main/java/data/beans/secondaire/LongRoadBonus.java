package data.beans.secondaire;

import java.util.List;

import com.google.common.collect.Lists;

public class LongRoadBonus {

    private List<Tile> listLongRoadTile;

    public LongRoadBonus() {
        this.listLongRoadTile = Lists.newArrayList();
    }

    public List<Tile> getListLongRoadTile() {
        return this.listLongRoadTile;
    }

    public void setListLongRoadTile(List<Tile> listLongRoadTile) {
        this.listLongRoadTile = listLongRoadTile;
    }

}
