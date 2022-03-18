package model.beans.secondaire;

import lombok.Data;

import javax.swing.*;

import java.io.Serializable;

@Data
public class House implements Serializable {

    private static final long serialVersionUID = 8025398406238419321L;

    private String name;
    private ImageIcon image;

}
