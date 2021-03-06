package data.beans.secondaire;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.apache.commons.lang3.StringUtils;

public class CityCard implements Serializable
{

    private static final long serialVersionUID = -2328709260769484443L;

    private String nameCity;

    private String nameProvince;

    private Color colorProvince;

    private ImageIcon image;

    private JButton cityButton;

    private JLabel cityLabel;

    public CityCard()
    {
    }

    public CityCard(final JButton btnCard)
    {
        this.setCityButton(btnCard);
    }

    public CityCard(final JLabel lblCard)
    {
        this.setCityLabel(lblCard);
    }

    public String getNameCity()
    {
        return this.nameCity;
    }

    public void setNameCity(final String nameCity)
    {
        this.nameCity = nameCity;
    }

    public String getNameProvince()
    {
        return this.nameProvince;
    }

    public void setNameProvince(final String nameProvince)
    {
        this.nameProvince = nameProvince;
    }

    public Color getColorProvince()
    {
        return this.colorProvince;
    }

    public void setColorProvince(final Color colorProvince)
    {
        this.colorProvince = colorProvince;
    }

    public ImageIcon getImage()
    {
        return this.image;
    }

    public void setImage(final ImageIcon image)
    {
        this.image = image;
    }

    public JButton getCityButton()
    {
        return this.cityButton;
    }

    public void setCityButton(final JButton cityButton)
    {
        this.cityButton = cityButton;
    }

    public JLabel getCityLabel()
    {
        return this.cityLabel;
    }

    public void setCityLabel(final JLabel cityLabel)
    {
        this.cityLabel = cityLabel;
    }

    @Override
    public CityCard clone()
    {
        final CityCard card = new CityCard();
        card.setColorProvince(this.getColorProvince());
        card.setImage(this.getImage());
        card.setNameCity(this.getNameCity());
        card.setNameProvince(this.getNameProvince());
        return card;
    }

    public void clear()
    {
        this.getCityButton().setToolTipText(StringUtils.EMPTY);
        this.getCityButton().setIcon(null);
        this.setColorProvince(null);
        this.setImage(null);
        this.setNameCity(StringUtils.EMPTY);
        this.setNameProvince(StringUtils.EMPTY);
    }

    public void cloneWithButton(final CityCard cardToClone)
    {
        this.setColorProvince(cardToClone.getColorProvince());
        this.setImage(cardToClone.getImage());
        this.setNameCity(cardToClone.getNameCity());
        this.setNameProvince(cardToClone.getNameProvince());
        this.getCityButton().setToolTipText(cardToClone.getNameCity());
        this.getCityButton().setIcon(cardToClone.getImage());
    }

    public void cloneWithLabel(final CityCard cardToClone)
    {
        this.setColorProvince(cardToClone.getColorProvince());
        this.setImage(cardToClone.getImage());
        this.setNameCity(cardToClone.getNameCity());
        this.setNameProvince(cardToClone.getNameProvince());
        this.getCityLabel().setToolTipText(cardToClone.getNameCity());
        this.getCityLabel().setIcon(cardToClone.getImage());
    }

}
