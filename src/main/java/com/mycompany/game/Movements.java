package com.mycompany.game;

import com.mycompany.game.move.*;

import java.util.function.Supplier;

public enum Movements {
    DIAGONAL(Diagonal::new),
    REVERSE_DIAGONAL(ReverseDiagonal::new),
    ROW(Row::new),
    COLUMN(Column::new);

    private final Supplier<Movement> movementCreator;

    Movements (Supplier<Movement> movementCreator){ this.movementCreator = movementCreator;}

    public Movement createMovement(){ return this.movementCreator.get(); }

    public static Movements get(int ordinal){
        return Movements.values()[ordinal];
    }
}
