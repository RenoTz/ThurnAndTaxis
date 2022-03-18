package model.beans.principal;

import lombok.Data;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllButtons {

    private List<JButton> listOfficialsButtons;
    private JButton btnDeckCard;
    private JButton btnRules;
    private JButton btnDiscardRoad;
    private JButton btnBuildRoad;
    private JButton btnRightRoad;
    private JButton btnLeftRoad;

    public AllButtons() {
        this.listOfficialsButtons = new ArrayList<>();
    }
    
}
