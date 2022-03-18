package model.beans.principal;

import lombok.Data;
import model.beans.secondaire.CityCard;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllListsCards {

    private List<CityCard> cardsDiscarded;
    private List<CityCard> cardsRemaining;
    private List<CityCard> cardsRoad;
    private List<CityCard> cardsVisible;

    public AllListsCards() {
        this.cardsDiscarded = new ArrayList<>();
        this.cardsRemaining = new ArrayList<>();
        this.cardsRoad = new ArrayList<>();
        this.cardsVisible = new ArrayList<>();
    }

}
