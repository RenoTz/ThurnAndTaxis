package utils;

import model.beans.secondaire.Player;

import java.util.List;

public class PlayerUtils {

    private static Player playerEnCours;
    
    public static Player getPlayerEnCours() {
        return playerEnCours;
    }
    
    public static void setPlayerEnCours(Player player) {
        playerEnCours = player;
    }

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
