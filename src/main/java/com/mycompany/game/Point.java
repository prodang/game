package com.mycompany.game;

public class Point {

    private int row;
    private int column;

    public Point(){this(0,0);}
    public Point(int column){
        this(Constants.DIMENSION-1,column);
    }
    public Point (int row, int column){
        this.row = row;
        this.column = column;
    }

    public boolean isInRangeLineal(){ return (this.column>=0)&&(this.column<Constants.DIMENSION); }

    public boolean isInRangeColumn(){
        return (this.row>=0)&&(this.row<Constants.DIMENSION);
    }

    public boolean isInRangeDiagonal(){
        return this.isInRangeLineal()&&this.isInRangeColumn();
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
