package com.mycompany.game;

public class Player {
    Color color;
    Board board;
    Point lastToken;

    public Player(Board board){
        this.board = board;
        Console.write(Constants.GET_COLOR);
        String newColor = Console.read().nextLine();
        assert isColorCorrect();
        this.color = Color.get(getOrdinal(newColor));
    }

    public Point getPoint(){
        return this.lastToken;
    }

    public void play(){
        Console.write(Constants.GET_COLUMN);
        Point newToken = new Point(Console.readInt());
        assert newToken.isValid();
        assert this.board.isSite();
        this.lastToken = this.board.putToken(newToken,this.color);
    }

    private boolean isColorCorrect(){
        return true;
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

