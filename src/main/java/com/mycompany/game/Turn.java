package com.mycompany.game;

public class Turn {

    private static final int NUM_PLAYERS = 2;

    private Board board;
    private Player[] players = new Player[NUM_PLAYERS];
    private int isActivatedPlayer;

    public Turn(Board board){
        this.board = board;
        init();
    }

    private void init(){
        this.isActivatedPlayer = 0;
        for (int i=0; i<NUM_PLAYERS; i++){
            showPlayer();
            this.players[i] = new Player(this.board);
            this.nextTurn();
        }
    }

    public int getIsActivatedPlayer(){
        return this.isActivatedPlayer;
    }

    public Player getPlayer(){return this.players[getIsActivatedPlayer()];}

    public void play(){
        showPlayer();
        this.players[isActivatedPlayer].play();
    }

    private void showPlayer(){
        Console.write(Constants.PLAYER+(this.getIsActivatedPlayer()+1)+Constants.POINT+Constants.SPACE);
    }

    public void nextTurn(){
        this.isActivatedPlayer = (this.isActivatedPlayer + 1) % 2;
    }
}
