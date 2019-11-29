package data.beans.bonus;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import data.beans.secondaire.Tile;

public class LongRoadBonus implements Serializable
{

    private static final long serialVersionUID = 2709134171595886739L;

    private List<Tile> listLongRoadTile;

    public LongRoadBonus()
    {
        this.listLongRoadTile = Lists.newArrayList();
    }

    public List<Tile> getListLongRoadTile()
    {
        return this.listLongRoadTile;
    }

    public void setListLongRoadTile(final List<Tile> listLongRoadTile)
    {
        this.listLongRoadTile = listLongRoadTile;
    }

}
