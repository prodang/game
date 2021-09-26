package com.mycompany.game.check;

import com.mycompany.game.move.Movement;
import com.mycompany.game.Point;

public class CheckerRight extends Checker{
    public CheckerRight(Point origin) {
        super(origin);
    }

    @Override
    public Point getTarget(Movement movement) {
        return movement.getTargetRight(this);
    }
}
