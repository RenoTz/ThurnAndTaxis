package model.beans.secondaire;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Province {

    private String name;
    private Color color;
    private List<CityCard> cities;
    private Long nbCities;

    public Province() {
        this.cities = new ArrayList<>();
    }

}
