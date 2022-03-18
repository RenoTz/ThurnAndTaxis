package model.beans.secondaire;

import lombok.Data;

import javax.swing.*;

import java.io.Serializable;

@Data
public class Tile implements Serializable
{

    private static final long serialVersionUID = -2768634188781896810L;

    private ImageIcon image;
    private Long nbVictoryPoints;
    private Long roadLength;

}
