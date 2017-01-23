package data.beans.principal;

import data.beans.secondaire.Player;

public class AllPlayers {

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    public Player getPlayer1() {
        return this.player1;
    }
    
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    
    public Player getPlayer2() {
        return this.player2;
    }
    
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
    
    public Player getPlayer3() {
        return this.player3;
    }
    
    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }
    
    public Player getPlayer4() {
        return this.player4;
    }
    
    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }
    
    public static boolean aucunVainqueur(AllPlayers allPlayers) {
        // return !(allPlayers.getPlayer1().isWon() && allPlayers.getPlayer2().isWon() && allPlayers.getPlayer3().isWon() && allPlayers
        // .getPlayer4().isWon());
        return !allPlayers.getPlayer1().isWon();
    }

    public Player getWinner() {

        if (this.getPlayer1().isWon()) {
            return this.getPlayer1();
        } else if (this.getPlayer2().isWon()) {
            return this.getPlayer2();
        } else if (this.getPlayer3().isWon()) {
            return this.getPlayer3();
        } else if (this.getPlayer4().isWon()) {
            return this.getPlayer4();
        }
        return null;
    }
}
