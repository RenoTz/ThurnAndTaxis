package data.beans.principal;

import java.util.List;

import com.google.common.collect.Lists;

import data.beans.secondaire.CityCard;

public class AllListsCards {

    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listeCardsRemaining;
    private List<CityCard> listCardsRoad;
    private List<CityCard> listCardsVisibles;

    public AllListsCards() {
        this.listCardsDiscarded = Lists.newArrayList();
        this.listeCardsRemaining = Lists.newArrayList();
        this.listCardsRoad = Lists.newArrayList();
        this.listCardsVisibles = Lists.newArrayList();
    }

    public List<CityCard> getListCardsVisibles() {
        return this.listCardsVisibles;
    }

    public void setListCardsVisibles(List<CityCard> listCardsVisibles) {
        this.listCardsVisibles = listCardsVisibles;
    }

    public List<CityCard> getListCardsDiscarded() {
        return this.listCardsDiscarded;
    }

    public void setListCardsDiscarded(List<CityCard> listCardsDiscarded) {
        this.listCardsDiscarded = listCardsDiscarded;
    }

    public List<CityCard> getListeCardsRemaining() {
        return this.listeCardsRemaining;
    }

    public void setListeCardsRemaining(List<CityCard> listeCardsRemaining) {
        this.listeCardsRemaining = listeCardsRemaining;
    }

    public List<CityCard> getListCardsRoad() {
        return this.listCardsRoad;
    }

    public void setListCardsRoad(List<CityCard> listCardsRoad) {
        this.listCardsRoad = listCardsRoad;
    }

}
