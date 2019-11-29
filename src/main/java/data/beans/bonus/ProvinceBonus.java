package data.beans.bonus;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import data.beans.secondaire.Tile;

public class ProvinceBonus implements Serializable
{

    private static final long serialVersionUID = -2088592408856189092L;

    private List<String> listeNames;

    private List<Tile> tiles;

    public ProvinceBonus()
    {
        this.listeNames = Lists.newArrayList();
        this.tiles = Lists.newArrayList();
    }

    public List<String> getListNames()
    {
        return this.listeNames;
    }

    public void setListeNames(final List<String> listeNames)
    {
        this.listeNames = listeNames;
    }

    public List<Tile> getTiles()
    {
        return this.tiles;
    }

    public void setTiles(final List<Tile> tiles)
    {
        this.tiles = tiles;
    }
}
