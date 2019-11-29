package data.beans.secondaire;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class House implements Serializable
{

    private static final long serialVersionUID = 8025398406238419321L;

    private String name;

    private ImageIcon image;

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public ImageIcon getImage()
    {
        return this.image;
    }

    public void setImage(final ImageIcon image)
    {
        this.image = image;
    }
}
