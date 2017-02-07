package services;


public interface ServiceActionOfficials {
    
    // ----------------- ACTIVATION ---------------------
    
    void addActionAdministrator();

    void addActionCartwright();

    void addActionPostalCarrier();

    void addActionPostmaster();
    
    // ---------------- DESACTIVATION -------------------

    void removeActionAdministrator();
    
    void removeActionCartwright();
    
    void removeActionPostalCarrier();
    
    void removeActionPostmaster();

}
