package com.mycompany.game;

import com.mycompany.game.check.Checker;
import com.mycompany.game.check.CheckerLeft;
import com.mycompany.game.check.CheckerRight;
import com.mycompany.game.move.*;

public class Board {
    private Color[][] colors;

    public Board(){
        this.colors = new Color[Constants.DIMENSION][Constants.DIMENSION];
        for (int i=0;i<Constants.DIMENSION;i++) {
            for (int j = 0; j < Constants.DIMENSION; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    public void showBoard(){
        Console.getInstance().writeln(Constants.LINE);
        for (int i=0;i<Constants.DIMENSION;i++){
            Console.getInstance().write(Constants.LIMIT+Constants.SPACE);
            for (int j=0;j<Constants.DIMENSION;j++){
                Console.getInstance().write(this.colors[i][j].show()+Constants.SPACE);
            }
            Console.getInstance().writeln(Constants.LIMIT);
        }
        Console.getInstance().writeln(Constants.LINE);
    }

    public boolean isConnect4(Turn turn){
        boolean isWinner = this.isWinner(turn);
        if (isWinner){
            Console.getInstance().writeln(Constants.CONGRATULATIONS+turn.getPlayerActivated().getColor()+Constants.POINT);
        }
        return isWinner;
    }

    private boolean isWinner(Turn turn){
        int i = 0;
        int sameTokens;
        do{
            Movement movement = Movements.get(i).createMovement();
            sameTokens = this.getSameTokens(movement,turn);
            i++;
        }while((i<Movements.values().length) && (sameTokens!=Constants.WINNER));
        return sameTokens == Constants.WINNER;
    }

    private int getSameTokens(Movement movement, Turn turn){
        Checker checkerRight = new CheckerRight(turn.getPlayerActivated().getPoint());
        Checker checkerLeft = new CheckerLeft(turn.getPlayerActivated().getPoint());
        checkerRight.sumTokens(movement,this.colors);
        if(checkerRight.getTokens() != Constants.WINNER){
            checkerLeft.setTokens(checkerRight.getTokens());
            checkerLeft.sumTokens(movement,this.colors);
            return checkerLeft.getTokens();
        }else{
            return checkerRight.getTokens();
        }
    }

    public Point putToken(Point newToken, Color color){
        Point target = newToken;
        while ((target.isInRangeColumn())&&(!this.isFree(target,color))){
            target = new Point(target.getRow()-1,target.getColumn());
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

}
