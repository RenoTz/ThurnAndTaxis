package services.impl;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import com.google.common.collect.Maps;

import data.beans.secondaire.CityCard;
import services.ServiceCards;

@RunWith(MockitoJUnitRunner.class)
public class ServiceCardsImplTest {
    
    private static final Map<Integer, String> mapCities = Maps.newHashMap();
    private static final Map<Integer, String> mapProvinces = Maps.newHashMap();
    
    // -------------------------------
    // Classe à tester (@InjectMocks)
    // -------------------------------

    @InjectMocks
    private ServiceCards serviceATester;

    // -------------------------
    // METHODES de test (@Test)
    // -------------------------
    
    @Before
    public void avantLesTests() {
        mapCities.put(0, "city_1");
        mapCities.put(1, "city_2");
        mapCities.put(2, "city_3");
        mapCities.put(3, "city_4");
        mapCities.put(4, "city_5");
        mapCities.put(5, "city_6");
        mapProvinces.put(0, "province_1");
        mapProvinces.put(1, "province_2");
        mapProvinces.put(2, "province_3");
        mapProvinces.put(3, "province_4");
        mapProvinces.put(4, "province_5");
        mapProvinces.put(5, "province_6");
    }

    @Test
    public void testAddSixCardsVisible() {

        // Arrange
        final List<CityCard> listCardsVisible = this.creerListeCardsVisible();
        final List<CityCard> listCardsRemaining = this.creerListeCardsRemaining();
        final JLabel lblCardRemaining = new JLabel();

        // Act
        this.serviceATester.addSixCardsVisible(listCardsVisible, listCardsRemaining, lblCardRemaining);

        // Assert
        this.verifierMappingListCardsVisible(listCardsVisible);
        assertThat(listCardsRemaining.size() == 0);
        assertThat(CollectionUtils.isEmpty(listCardsRemaining));
        assertEquals(lblCardRemaining.getText(), "0");

    }

    // -------------------------------
    // METHODES SPECIFIQUES : PRIVEES
    // -------------------------------
    
    private void verifierMappingListCardsVisible(List<CityCard> listCardsVisible) {
        Collections.reverse(listCardsVisible);
        int indexMap = 0;
        for (CityCard cardVisible : listCardsVisible) {
            assertEquals(cardVisible.getNameCity(), mapCities.get(indexMap));
            indexMap++;
        }

    }

    // ----------------------------
    // METHODES CONSTRUCTION BEANS
    // ----------------------------
    
    private List<CityCard> creerListeCardsRemaining() {
        
        List<CityCard> cardsRemaining = Lists.newArrayList();

        for (int i = 0; i < 6; i++) {
            CityCard card = new CityCard(new JButton());
            card.setColorProvince(Color.BLACK);
            card.setImage(new ImageIcon("image"));
            if (mapProvinces.containsKey(i)) {
                card.setNameProvince(mapProvinces.get(i));
            }
            if (mapCities.containsKey(i)) {
                card.setNameCity(mapCities.get(i));
                card.setImage(new ImageIcon("image_" + mapCities.get(i)));
            }
            cardsRemaining.add(card);
        }
        return cardsRemaining;
    }

    private List<CityCard> creerListeCardsVisible() {

        List<CityCard> cardsVisible = Lists.newArrayList();

        for (int i = 0; i < 6; i++) {
            CityCard card = new CityCard(new JButton());
            cardsVisible.add(card);
        }
        return cardsVisible;
    }
}
