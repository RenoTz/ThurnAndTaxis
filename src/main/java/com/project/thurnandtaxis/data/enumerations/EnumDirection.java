package com.project.thurnandtaxis.data.enumerations;

public enum EnumDirection {
    LEFT(0), RIGHT(1), LEFT_OR_RIGHT(2), NEANT(9);

    private int option;

    private EnumDirection(final int option) {
        this.setOption(option);
    }
    
    public static EnumDirection getEnumDirectionByOption(final int option) {
        
        EnumDirection enumDirection = null;

        for (final EnumDirection enumValue : values()) {
            if (enumValue.getOption() == option) {
                enumDirection = enumValue;
                break;
            }
        }

        return enumDirection;
    }

    public int getOption() {
        return this.option;
    }

    public void setOption(int option) {
        this.option = option;
    }
    
}
