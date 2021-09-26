package com.mycompany.game.move;

import com.mycompany.game.Point;
import com.mycompany.game.check.Checker;
import com.mycompany.game.check.SuperChecker;

public abstract class Movement {

    public abstract Point getTargetRight(SuperChecker superChecker);

    public abstract Point getTargetLeft(SuperChecker superChecker);

    public abstract boolean isInRange(SuperChecker superChecker, Point target);
}
