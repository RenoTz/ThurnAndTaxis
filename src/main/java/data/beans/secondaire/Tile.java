package data.beans.secondaire;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Tile implements Serializable
{

    private static final long serialVersionUID = -2768634188781896810L;

    private ImageIcon image;

    private Long nbVictoryPoints;

    private Long routeLength;

    public ImageIcon getImage()
    {
        return this.image;
    }

    public void setImage(final ImageIcon image)
    {
        this.image = image;
    }

    public Long getNbVictoryPoints()
    {
        return this.nbVictoryPoints;
    }

    public void setNbVictoryPoints(final Long nbVictoryPoints)
    {
        this.nbVictoryPoints = nbVictoryPoints;
    }

    public Long getRouteLength()
    {
        return this.routeLength;
    }

    public void setRouteLength(final Long routeLength)
    {
        this.routeLength = routeLength;
    }

}
