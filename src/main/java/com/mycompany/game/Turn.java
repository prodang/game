package com.mycompany.game;

public class Turn {

    private static final int NUM_PLAYERS = 2;

    private Board board;
    private Player[] players = new Player[NUM_PLAYERS];
    private int isActivatedPlayer;

    public Turn(Board board){
        this.board = board;
        this.isActivatedPlayer = 0;
        for (int i=0; i<NUM_PLAYERS; i++){
            Console.write(Constants.PLAYER+(this.getIsActivatedPlayer()+1)+Constants.POINT+Constants.SPACE);
            this.players[i] = new Player(this.board);
            this.nextTurn();
        }
    }

    public int getIsActivatedPlayer(){
        return this.isActivatedPlayer;
    }

    public Player getPlayerActivated(){return this.players[this.getIsActivatedPlayer()];}

    public void play(){
        Console.write(Constants.PLAYER+(this.getIsActivatedPlayer()+1)+Constants.POINT+Constants.SPACE);
        this.players[isActivatedPlayer].play();
    }

    public void nextTurn(){
        this.isActivatedPlayer = (this.isActivatedPlayer + 1) % 2;
    }
}
