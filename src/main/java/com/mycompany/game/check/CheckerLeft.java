package com.mycompany.game.check;

import com.mycompany.game.move.Movement;
import com.mycompany.game.Point;

public class CheckerLeft extends Checker{
    public CheckerLeft(Point origin) {
        super(origin);
    }

    @Override
    public Point getTarget(Movement movement) {
        return movement.getTargetLeft(this);
    }
}
