package model.beans.bonus;

import lombok.Data;
import model.beans.secondaire.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProvinceBonus implements Serializable {

    private static final long serialVersionUID = -2088592408856189092L;

    private List<String> names;
    private List<Tile> tiles;

    public ProvinceBonus() {
        this.names = new ArrayList<>();
        this.tiles = new ArrayList<>();
    }

}
