package services;

import data.beans.secondaire.Player;

public interface ServiceActionOfficials {

    void addActionAdministrator();
    
    void removeActionAdministrator();

    void addActionCartwright();
    
    void removeActionCartwright();

    void addActionPostalCarrier();
    
    void removeActionPostalCarrier();
    
    void addActionPostmaster();

    void removeActionPostmaster();

    Player getPlayerEnCours();

    void setPlayerEnCours(Player playerEnCours);

}
