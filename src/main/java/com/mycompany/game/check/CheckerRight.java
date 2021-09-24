package com.mycompany.game.check;

import com.mycompany.game.move.Movement;
import com.mycompany.game.Point;

public class CheckerRight extends Checker{
    @Override
    public Point getTarget(Movement movement, Point origin) {
        return movement.getTargetRight(this, origin);
    }
}
