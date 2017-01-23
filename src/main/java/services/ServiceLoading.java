package services;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.json.JSONException;
import org.json.JSONObject;

import coordinations.CoordinationGameParams;
import data.beans.principal.Game;
import data.beans.secondaire.CityCard;
import data.constantes.ConstantesGameParams;

public class ServiceLoading {
    
    private static final int NB_OCCURENCES_CITY_CARDS = 3;
    final CoordinationGameParams coordGameParams;

    public ServiceLoading() {
        this.coordGameParams = new CoordinationGameParams();
    }
    
    public Game chargerTousLesParametresDuJeuDepuisFichier(final JSONObject jsonGameElements) throws JSONException, IOException {
        
        final Game game = new Game();
        game.setGameParams(this.coordGameParams.recupererGameParamsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.GAME)));
        game.setListOfficials(this.coordGameParams.recupererListeOfficialsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.OFFICIALS)));
        game.setListHouses(this.coordGameParams.recupererListeHousesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.HOUSES)));
        game.setListCarriages(this.coordGameParams.recupererListeCarriagesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.CARRIAGES)));
        game.setListProvinces(this.coordGameParams.recupererListeProvincesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.PROVINCES)));
        game.setListAdjacences(this.coordGameParams.recupererListeAdjacencesJSON(jsonGameElements
                        .getJSONObject(ConstantesGameParams.DIRECT_ADJACENCES)));
        game.setBonus(this.coordGameParams.recupererTousLesBonus(jsonGameElements.getJSONObject(ConstantesGameParams.BONUS)));
        
        // éléments supplémentaires
        this.chargerLesElementsDuJeuSupplementaires(game);
        
        return game;
    }

    private void chargerLesElementsDuJeuSupplementaires(final Game game) {

        final List<CityCard> listeCityCards = this.coordGameParams.recupererListeCityCards(game.getListProvinces());

        if (CollectionUtils.isNotEmpty(listeCityCards)) {
            for (CityCard card : listeCityCards) {
                for (int i = 0; i < NB_OCCURENCES_CITY_CARDS; i++) {
                    final CityCard cityCard = new CityCard();
                    cityCard.setColorProvince(card.getColorProvince());
                    cityCard.setImage(card.getImage());
                    cityCard.setNameCity(card.getNameCity());
                    cityCard.setNameProvince(card.getNameProvince());
                    game.getListCityCards().add(cityCard);
                }
            }
        }

    }
    
}
