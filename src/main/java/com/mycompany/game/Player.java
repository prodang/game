package com.mycompany.game;

public class Player {
    Color color;
    Board board;
    Point newToken;

    public Player(Board board){
        this.board = board;
        initColor();
    }

    public Point getPoint(){
        return this.newToken;
    }

    public void play(){
        Point newToken = getNewToken();
        assert this.board.isSite();
        this.newToken = this.board.putToken(newToken,this.color);
    }

    private Point getNewToken(){
        Console.write(Constants.GET_COLUMN);
        Point newToken = new Point(Console.readInt());
        assert newToken.isValid();
        return newToken;
    }

    private void initColor(){
        Console.write(Constants.GET_COLOR);
        String newColor = Console.read().nextLine();
        assert isColorCorrect();
        relationWithColor(newColor);
    }

    private boolean isColorCorrect(){
        return true;
    }

    private void relationWithColor(String newColor){
        if(newColor.equals(Color.R.toString())){
            this.color = Color.R;
        }else {
            this.color = Color.B;
        }
    }

    public Color getColor(){
        return this.color;
    }
}

