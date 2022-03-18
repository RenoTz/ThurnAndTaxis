package model.beans.bonus;

import lombok.Data;
import model.beans.secondaire.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class LongRoadBonus implements Serializable {

    private static final long serialVersionUID = 2709134171595886739L;

    private List<Tile> longRoadTiles;

    public LongRoadBonus() {
        this.longRoadTiles = new ArrayList<>();
    }

}
