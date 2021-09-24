package com.mycompany.game.check;

import com.mycompany.game.*;
import com.mycompany.game.move.*;

public abstract class Checker implements SuperChecker{
    private int sameTokens;

    public Checker(){
        this.sameTokens = 1;
    }

    public int getTokens(){
        return this.sameTokens;
    }

    public void setTokens(int tokens){
        this.sameTokens = tokens;
    }

    private boolean isContinue(Movement movement, Point target, int numTokens, Color[][] board){
        return isInRange(movement,target)
                &&(!board[target.getRow()][target.getColumn()].isNull())
                &&(numTokens< Constants.WINNER);
    }
    private boolean isSame(Point pointOrigin, Point pointTarget, Color[][] board){
        Color origin = board[pointOrigin.getRow()][pointOrigin.getColumn()];
        Color target = board[pointTarget.getRow()][pointTarget.getColumn()];
        return origin.equals(target);
    }

    public void sumTokens(Movement movement, Point pointPlayer, Color[][] board){
        Point origin = pointPlayer;
        Point target = this.getTarget(movement, origin);
        int numTokens = this.getTokens();
        while(this.isContinue(movement,target,numTokens,board)){
            if(this.isSame(origin,target,board)){
                numTokens++;
            }else{
                numTokens = this.getTokens();
            }
            origin = target;
            target = this.getTarget(movement, origin);
        }
        this.setTokens(numTokens);
    }

    public abstract Point getTarget(Movement movement, Point origin);

    public boolean isInRange(Movement movement, Point target){
        return movement.isInRange(this,target);
    }

    public boolean isInRange(Diagonal diagonal, Point target){
        return diagonal.isInRange(target);
    }

    public Point getRight(Diagonal diagonal, Point origin){
        return diagonal.getRight(origin);
    }

    public Point getLeft(Diagonal diagonal, Point origin){
        return diagonal.getLeft(origin);
    }

    public Point getRight(ReverseDiagonal reverseDiagonal, Point origin){
        return reverseDiagonal.getRight(origin);
    }

    public Point getLeft(ReverseDiagonal reverseDiagonal, Point origin){
        return reverseDiagonal.getLeft(origin);
    }

    public boolean isInRange(ReverseDiagonal reverseDiagonal, Point target){
        return reverseDiagonal.isInRange(target);
    }

    public Point getRight(Row row, Point origin){
        return row.getRight(origin);
    }

    public Point getLeft(Row row, Point origin){
        return row.getLeft(origin);
    }

    public boolean isInRange(Row row, Point target){
        return row.isInRange(target);
    }

    public Point getRight(Column column, Point origin){
        return column.getRight(origin);
    }

    public Point getLeft(Column column, Point origin){
        return column.getLeft(origin);
    }

    public boolean isInRange(Column column, Point target){
        return column.isInRange(target);
    }

}
