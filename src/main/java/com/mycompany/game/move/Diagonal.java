package com.mycompany.game.move;

import com.mycompany.game.Point;
import com.mycompany.game.check.Checker;

public class Diagonal extends Movement{
    @Override
    public Point getTargetRight(Checker checker, Point origin) {
        return checker.getRight(this, origin);
    }

    @Override
    public Point getTargetLeft(Checker checker, Point origin) {
        return checker.getLeft(this, origin);
    }

    @Override
    public boolean isInRange(Checker checker, Point target) {
        return checker.isInRange(this, target);
    }

    public Point getRight(Point origin){
        return new Point(origin.getRow()-1, origin.getColumn()+1);
    }

    public Point getLeft(Point origin){
        return new Point(origin.getRow()+1, origin.getColumn()-1);
    }

    public boolean isInRange(Point target){
        return target.isInRangeDiagonal();
    }

}
