package utils;

import java.util.List;

import data.beans.secondaire.Player;

public class PlayerUtils {

    public static boolean aucunVainqueur(List<Player> listPlayers) {

        for (Player player : listPlayers) {
            if (player.isWon()) {
                return false;
            }
        }
        return true;
    }
    
    public static Player getWinner(List<Player> listPlayers) {
        
        for (Player player : listPlayers) {
            if (player.isWon()) {
                return player;
            }
        }
        return null;
    }

}
