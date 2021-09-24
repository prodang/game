package com.mycompany.game;

import com.mycompany.game.check.Checker;
import com.mycompany.game.check.CheckerLeft;
import com.mycompany.game.check.CheckerRight;
import com.mycompany.game.move.*;

public class Board {
    private Color[][] colors;

    public Board(){
        colors = new Color[Constants.DIMENSION][Constants.DIMENSION];
        for (int i=0;i<Constants.DIMENSION;i++) {
            for (int j = 0; j < Constants.DIMENSION; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    public Color[][] getBoard(){
        return this.colors;
    }

    public void showBoard(){
        Console.writeln(Constants.LINE);
        for (int i=0;i<Constants.DIMENSION;i++){
            Console.write(Constants.LIMIT+Constants.SPACE);
            for (int j=0;j<Constants.DIMENSION;j++){
                Console.write(colors[i][j].show()+Constants.SPACE);
            }
            Console.writeln(Constants.LIMIT);
        }
        Console.writeln(Constants.LINE);
    }

    public boolean isConnect4(Turn turn){
        boolean isWinner = isWinner(turn);
        if (isWinner){
            Console.writeln(Constants.CONGRATULATIONS+turn.getPlayerActivated().getColor()+Constants.POINT);
        }
        return isWinner;
    }

    private boolean isWinner(Turn turn){
        int i = 0;
        int sameTokens = 0;
        do{
            Movement movement = null;
            String move = Movements.get(i).toString();
            if(move.equals(Movements.DIAGONAL.toString())){
                movement = new Diagonal();
            }else if (move.equals(Movements.REVERSE_DIAGONAL.toString())){
                movement = new ReverseDiagonal();
            }else if (move.equals(Movements.ROW.toString())){
                movement = new Row();
            }else if (move.equals(Movements.COLUMN.toString())){
                movement = new Column();
            }
            sameTokens = this.getSameTokens(movement,turn);
            i++;
        }while((i<Movements.values().length) && (sameTokens!=Constants.WINNER));
        return sameTokens == Constants.WINNER;
    }

    private int getSameTokens(Movement movement, Turn turn){
        Checker checkerRight = new CheckerRight();
        Checker checkerLeft = new CheckerLeft();
        checkerRight.sumTokens(movement,turn,this);
        if(checkerRight.getTokens() != Constants.WINNER){
            checkerLeft.setTokens(checkerRight.getTokens());
            checkerLeft.sumTokens(movement,turn,this);
            return checkerLeft.getTokens();
        }else{
            return checkerRight.getTokens();
        }
    }

    public boolean isSite(){
        return true;
    }

    public Point putToken(Point newToken, Color color){
        Point target = newToken;
        while ((target.isInRangeColumn())&&(!isFree(target,color))){
            target = getTargetNewToken(target);
        }
        return target;
    }

    private boolean isFree(Point target, Color color){
        boolean isNull = this.colors[target.getRow()][target.getColumn()].isNull();
        if(isNull){
            this.colors[target.getRow()][target.getColumn()] = color;
        }
        return isNull;
    }

    private Point getTargetNewToken(Point origin){
        return new Point(origin.getRow()-1,origin.getColumn());
    }

}
