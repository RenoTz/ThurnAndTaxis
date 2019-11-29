package data.beans.bonus;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import data.beans.secondaire.Tile;

public class Bonus implements Serializable
{

    private static final long serialVersionUID = -7838640822217384440L;

    private List<ProvinceBonus> listProvincesBonus;

    private ProvinceBonus allProvincesBonus;

    private List<LongRoadBonus> listLongRouteBonus;

    private List<Tile> listEndGameBonus;

    public Bonus()
    {
        this.listProvincesBonus = Lists.newArrayList();
        this.listLongRouteBonus = Lists.newArrayList();
        this.listEndGameBonus = Lists.newArrayList();
    }

    public List<ProvinceBonus> getListProvincesBonus()
    {
        return this.listProvincesBonus;
    }

    public void setListProvincesBonus(final List<ProvinceBonus> listProvincesBonus)
    {
        this.listProvincesBonus = listProvincesBonus;
    }

    public ProvinceBonus getAllProvincesBonus()
    {
        return this.allProvincesBonus;
    }

    public void setAllProvincesBonus(final ProvinceBonus allProvincesBonus)
    {
        this.allProvincesBonus = allProvincesBonus;
    }

    public List<LongRoadBonus> getListLongRouteBonus()
    {
        return this.listLongRouteBonus;
    }

    public void setListLongRouteBonus(final List<LongRoadBonus> listLongRouteBonus)
    {
        this.listLongRouteBonus = listLongRouteBonus;
    }

    public List<Tile> getListEndGameBonus()
    {
        return this.listEndGameBonus;
    }

    public void setListEndGameBonus(final List<Tile> listEndGameBonus)
    {
        this.listEndGameBonus = listEndGameBonus;
    }
}
