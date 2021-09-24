package com.mycompany.game.check;

import com.mycompany.game.move.Movement;
import com.mycompany.game.Point;

public class CheckerLeft extends Checker{
    public CheckerLeft() {
        super();
    }

    @Override
    public Point getTarget(Movement movement, Point origin) {
        return movement.getTargetLeft(this, origin);
    }
}
