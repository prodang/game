package com.mycompany.game.check;

import com.mycompany.game.*;
import com.mycompany.game.move.*;

public abstract class Checker implements SuperChecker{
    private int sameTokens;
    private Point origin;

    public Checker(Point origin){
        this.origin = origin;
        this.sameTokens = 1;
    }

    public int getTokens(){
        return this.sameTokens;
    }

    public void setTokens(int tokens){
        this.sameTokens = tokens;
    }

    private Point getOrigin(){
        return this.origin;
    }

    private void setOrigin(Point origin){
        this.origin = origin;
    }

    public void sumTokens(Movement movement, Color[][] board){
        Point target = this.getTarget(movement);
        int numTokens = this.getTokens();
        while(isInRange(movement,target)&&(!board[target.getRow()][target.getColumn()].isNull())&&(numTokens< Constants.WINNER)){
            if(board[this.getOrigin().getRow()][this.getOrigin().getColumn()].equals(board[target.getRow()][target.getColumn()])){
                numTokens++;
            }else{
                numTokens = this.getTokens();
            }
            this.setOrigin(target);
            target = this.getTarget(movement);
        }
        this.setTokens(numTokens);
    }

    public abstract Point getTarget(Movement movement);

    public boolean isInRange(Movement movement, Point target){
        return movement.isInRange(this,target);
    }

    public Point getRight(Diagonal diagonal){
        return diagonal.getRight(this.getOrigin());
    }
    public Point getRight(ReverseDiagonal reverseDiagonal){
        return reverseDiagonal.getRight(this.getOrigin());
    }
    public Point getRight(Row row){
        return row.getRight(this.getOrigin());
    }
    public Point getRight(Column column){
        return column.getRight(this.getOrigin());
    }

    public Point getLeft(Diagonal diagonal){
        return diagonal.getLeft(this.getOrigin());
    }
    public Point getLeft(ReverseDiagonal reverseDiagonal){
        return reverseDiagonal.getLeft(this.getOrigin());
    }
    public Point getLeft(Row row){
        return row.getLeft(this.getOrigin());
    }
    public Point getLeft(Column column){
        return column.getLeft(this.getOrigin());
    }

    public boolean isInRange(Diagonal diagonal, Point target){
        return diagonal.isInRange(target);
    }
    public boolean isInRange(ReverseDiagonal reverseDiagonal, Point target){
        return reverseDiagonal.isInRange(target);
    }
    public boolean isInRange(Row row, Point target){
        return row.isInRange(target);
    }
    public boolean isInRange(Column column, Point target){
        return column.isInRange(target);
    }

}
