package com.mycompany.game.move;

import com.mycompany.game.Point;
import com.mycompany.game.check.Checker;

public abstract class Movement {

    public abstract Point getTargetRight(Checker checker, Point origin);

    public abstract Point getTargetLeft(Checker checker, Point origin);

    public abstract boolean isInRange(Checker checker, Point target);
}
