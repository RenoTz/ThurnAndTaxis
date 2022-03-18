package model.enumerations;

public enum EnumOfficials {
    ADMINISTRATOR("Administrator"), CARTWRIGHT("Cartwright"), POSTAL_CARRIER("Postal carrier"), POSTMASTER("Postmaster");

    private String name;

    private EnumOfficials(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
