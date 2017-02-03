package services;

import data.beans.secondaire.Player;
import data.enumerations.EnumOfficials;

public interface ServiceActionOfficials {

    void addActionButtonAdministrator(final EnumOfficials enumOfficial);

    void addActionButtonCartwright(final EnumOfficials enumOfficial);

    void addActionButtonPostalCarrier(final EnumOfficials enumOfficial);
    
    void addActionButtonPostmaster(final EnumOfficials enumOfficial);

    Player getPlayerEnCours();

    void setPlayerEnCours(Player playerEnCours);

}
