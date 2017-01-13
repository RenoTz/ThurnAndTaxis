package com.project.thurnandtaxis.services;

import com.project.thurnandtaxis.data.enumerations.EnumOfficials;

public interface ServiceActionOfficials {
    
    void addActionButtonAdministrator(final EnumOfficials enumOfficial);
    
    void addActionButtonCartwright(final EnumOfficials enumOfficial);
    
    void addActionButtonPostalCarrier(final EnumOfficials enumOfficial);

    void addActionButtonPostmaster(final EnumOfficials enumOfficial);
}
