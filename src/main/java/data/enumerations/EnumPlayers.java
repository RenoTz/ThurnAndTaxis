package data.enumerations;

public enum EnumPlayers {
    
    INDICE_PLAYER_1(0), INDICE_PLAYER_2(1), INDICE_PLAYER_3(2), INDICE_PLAYER_4(3);

    private int indice;

    private EnumPlayers(final int indice) {
        this.setIndice(indice);
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
