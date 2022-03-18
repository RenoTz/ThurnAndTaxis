package model.beans.bonus;

import lombok.Data;
import model.beans.secondaire.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Bonus implements Serializable {

    private static final long serialVersionUID = -7838640822217384440L;

    private ProvinceBonus provinceBonus;
    private List<ProvinceBonus> provinceBonuses;
    private List<LongRoadBonus> longRoadBonuses;
    private List<Tile> endGameBonuses;

    public Bonus() {
        this.provinceBonuses = new ArrayList<>();
        this.longRoadBonuses = new ArrayList<>();
        this.endGameBonuses = new ArrayList<>();
    }

}
