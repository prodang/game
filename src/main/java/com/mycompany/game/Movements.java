package com.mycompany.game;

public enum Movements {
    DIAGONAL,
    REVERSE_DIAGONAL,
    ROW,
    COLUMN;

    public static Movements get(int ordinal){
        return Movements.values()[ordinal];
    }
}
