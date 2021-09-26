package com.mycompany.game;

public class Player {
    Color color;
    Board board;
    Point lastToken;

    public Player(Board board){
        this.board = board;
        String newColor = Console.getInstance().read();
        this.color = Color.get(getOrdinal(newColor));
    }

    public Point getPoint(){
        return this.lastToken;
    }

    public void play(){
        Point newToken = new Point(Console.getInstance().readInt());
        this.lastToken = this.board.putToken(newToken,this.color);
    }

    private int getOrdinal(String newColor){
        if(newColor.equals(Color.R.toString())){
            return 0;
        }else {
            return 1;
        }
    }

    public Color getColor(){
        return this.color;
    }
}

