package data.beans.secondaire;

import java.util.List;

import com.google.common.collect.Lists;

public class Bonus {

    private List<ProvinceBonus> listProvincesBonus;
    private ProvinceBonus allProvincesBonus;
    private List<LongRoadBonus> listLongRouteBonus;
    private List<Tile> listEndGameBonus;
    
    public Bonus() {
        this.listProvincesBonus = Lists.newArrayList();
        this.listLongRouteBonus = Lists.newArrayList();
        this.listEndGameBonus = Lists.newArrayList();
    }

    public List<ProvinceBonus> getListProvincesBonus() {
        return this.listProvincesBonus;
    }

    public void setListProvincesBonus(List<ProvinceBonus> listProvincesBonus) {
        this.listProvincesBonus = listProvincesBonus;
    }

    public ProvinceBonus getAllProvincesBonus() {
        return this.allProvincesBonus;
    }

    public void setAllProvincesBonus(ProvinceBonus allProvincesBonus) {
        this.allProvincesBonus = allProvincesBonus;
    }

    public List<LongRoadBonus> getListLongRouteBonus() {
        return this.listLongRouteBonus;
    }

    public void setListLongRouteBonus(List<LongRoadBonus> listLongRouteBonus) {
        this.listLongRouteBonus = listLongRouteBonus;
    }

    public List<Tile> getListEndGameBonus() {
        return this.listEndGameBonus;
    }

    public void setListEndGameBonus(List<Tile> listEndGameBonus) {
        this.listEndGameBonus = listEndGameBonus;
    }
}
