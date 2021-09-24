package com.mycompany.game.move;

import com.mycompany.game.Point;
import com.mycompany.game.check.Checker;
import com.mycompany.game.check.SuperChecker;

public class Column extends Movement{
    @Override
    public Point getTargetRight(SuperChecker superchecker, Point origin) {
        return superchecker.getRight(this, origin);
    }

    @Override
    public Point getTargetLeft(SuperChecker superchecker, Point origin) {
        return superchecker.getLeft(this, origin);
    }

    @Override
    public boolean isInRange(SuperChecker superchecker, Point target) {
        return superchecker.isInRange(this, target);
    }

    public Point getRight(Point origin){
        return new Point(origin.getRow()+1, origin.getColumn());
    }

    public Point getLeft(Point origin){
        return new Point(origin.getRow()-1, origin.getColumn());
    }

    public boolean isInRange(Point target){
        return target.isInRangeColumn();
    }
}
