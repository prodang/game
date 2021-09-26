package com.mycompany.game.move;

import com.mycompany.game.Point;
import com.mycompany.game.check.Checker;
import com.mycompany.game.check.SuperChecker;

public class Row extends Movement{
    @Override
    public Point getTargetRight(SuperChecker superchecker) {
        return superchecker.getRight(this);
    }

    @Override
    public Point getTargetLeft(SuperChecker superchecker) {
        return superchecker.getLeft(this);
    }

    @Override
    public boolean isInRange(SuperChecker superchecker, Point target) {
        return superchecker.isInRange(this, target);
    }

    public Point getRight(Point origin){
        return new Point(origin.getRow(), origin.getColumn()+1);
    }

    public Point getLeft(Point origin){
        return new Point(origin.getRow(), origin.getColumn()-1);
    }

    public boolean isInRange(Point target){
        return target.isInRangeLineal();
    }
}
