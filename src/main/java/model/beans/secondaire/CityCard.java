package model.beans.secondaire;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

import java.awt.*;
import java.io.Serializable;

@Data
public class CityCard implements Serializable
{

    private static final long serialVersionUID = -2328709260769484443L;

    private String nameCity;
    private String nameProvince;
    private Color colorProvince;
    private ImageIcon image;
    private JButton cityButton;
    private JLabel cityLabel;

    public CityCard() {}

    public CityCard(final JButton btnCard)
    {
        this.setCityButton(btnCard);
    }

    public CityCard(final JLabel lblCard)
    {
        this.setCityLabel(lblCard);
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

}
