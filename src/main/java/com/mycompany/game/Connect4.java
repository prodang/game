package com.mycompany.game;

public class Connect4 {
    Board board;
    Turn turn;

    public Connect4(){
        Console.writeln(Constants.TITLE);
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play(){
        this.board.showBoard();
        do{
            this.turn.play();
            this.board.showBoard();
        }while(!this.isConnect4());
    }

    private boolean isConnect4(){
        boolean isWinner = this.board.isConnect4(this.turn);
        if(!isWinner){
            this.turn.nextTurn();
        }
        return isWinner;
    }

    public static void main(String[] args){new Connect4().play();}
}
