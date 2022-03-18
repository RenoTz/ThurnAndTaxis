package controler;

import mapper.GameParamsMapper;
import model.beans.principal.Game;
import model.beans.secondaire.CityCard;
import model.constantes.ConstantesGameParams;

import org.apache.commons.collections.CollectionUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class Setup {
    
    private static final int NB_OCCURENCES_CITY_CARDS = 3;
    private final GameParamsMapper coordGameParams;

    public Setup() {
        this.coordGameParams = new GameParamsMapper();
    }
    
    public Game loadParamsFromFile(final JSONObject jsonGameElements) throws JSONException, IOException {
        
        final Game game = new Game();
        game.setGameParams(this.coordGameParams.recupererGameParamsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.GAME)));
        game.setOfficials(this.coordGameParams.getOfficialsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.OFFICIALS)));
        game.setHouses(this.coordGameParams.recupererListeHousesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.HOUSES)));
        game.setCarriages(this.coordGameParams.getCarriagesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.CARRIAGES)));
        game.setProvinces(this.coordGameParams.recupererListeProvincesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.PROVINCES)));
        game.setAdjacences(this.coordGameParams.recupererListeAdjacencesJSON(jsonGameElements
                        .getJSONObject(ConstantesGameParams.DIRECT_ADJACENCES)));
        game.setBonus(this.coordGameParams.recupererTousLesBonus(jsonGameElements.getJSONObject(ConstantesGameParams.BONUS)));
        
        // éléments supplémentaires
        this.chargerLesElementsDuJeuSupplementaires(game);
        
        return game;
    }

    private void chargerLesElementsDuJeuSupplementaires(final Game game) {

        final List<CityCard> listeCityCards = this.coordGameParams.getCityCards(game.getProvinces());

        if (CollectionUtils.isNotEmpty(listeCityCards)) {
            for (CityCard card : listeCityCards) {
                for (int i = 0; i < NB_OCCURENCES_CITY_CARDS; i++) {
                    final CityCard cityCard = new CityCard();
                    cityCard.setColorProvince(card.getColorProvince());
                    cityCard.setImage(card.getImage());
                    cityCard.setNameCity(card.getNameCity());
                    cityCard.setNameProvince(card.getNameProvince());
                    game.getCityCards().add(cityCard);
                }
            }
        }

    }
    
}
