package com.mycompany.game;

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
        String[] operations = initOperations();
        return getTotalTokens(operations,turn) == Constants.WINNER;
    }

    private int getTotalTokens(String[] operations,Turn turn){
        int tokens = 0;
        int i = 0;
        while ((i<operations.length)&&(tokens<Constants.WINNER)){
            if(i%4==0){
                tokens = 1;
            }
            tokens = getTokensOperations(tokens, operations[i+1], operations[i],turn);
            i= i+2;
        }
        return tokens;
    }

    private String[] initOperations(){
        return new String[]{ Constants.DIAGONAL_INVERSE, Constants.LEFT,
                Constants.DIAGONAL_INVERSE, Constants.RIGHT,
                Constants.DIAGONAL, Constants.RIGHT,
                Constants.DIAGONAL, Constants.LEFT,
                Constants.ROW, Constants.RIGHT,
                Constants.ROW, Constants.LEFT,
                Constants.COLUMN, ""};
    }

    private int getTokensOperations(int tokens, String siteToken, String typeTarget, Turn turn){
        Point origin = turn.getPlayerActivated().getPoint();
        Point target = getTarget(siteToken,typeTarget,origin);
        int numTokens = tokens;
        while(isContinue(target,typeTarget,numTokens)){
            if (isSame(origin,target)) {
                numTokens++;
            }else{
                numTokens = tokens;
            }
            origin = target;
            target = getTarget(siteToken,typeTarget,origin);
        }
        return numTokens;
    }

    private boolean isContinue(Point target, String typeTarget, int numTokens){
        return (isInRange(target,typeTarget))&&(!this.colors[target.getRow()][target.getColumn()].isNull())
                &&(numTokens<Constants.WINNER);
    }

    private boolean isSame(Point pointOrigin, Point pointTarget){
        Color origin = this.colors[pointOrigin.getRow()][pointOrigin.getColumn()];
        Color target = this.colors[pointTarget.getRow()][pointTarget.getColumn()];
        return origin.equals(target);
    }

    private boolean isInRange(Point target, String type){
        if((type.equals(Constants.DIAGONAL_INVERSE))||(type.equals(Constants.DIAGONAL))){
            return target.isInRangeDiagonal();
        }else if(type.equals(Constants.ROW)){
            return target.isInRangeLineal();
        }else{
            return target.isInRangeColumn();
        }
    }

    private Point getTarget(String siteToken, String typeTarget, Point origin){
        Point target = null;
        switch (typeTarget) {
            case Constants.DIAGONAL_INVERSE:
                target = getTargetDiagonalInverse(siteToken, origin);
                break;
            case Constants.DIAGONAL:
                target = getTargetDiagonal(siteToken, origin);
                break;
            case Constants.ROW:
                target = getTargetRow(siteToken, origin);
                break;
            case Constants.COLUMN:
                target = getTargetColumn(origin);
                break;
        }
        return target;
    }

    private Point getTargetDiagonalInverse(String siteToken, Point origin){
        if(siteToken.equals(Constants.LEFT)){
            return new Point(origin.getRow()-1, origin.getColumn()-1);
        }else{
            return new Point(origin.getRow()+1, origin.getColumn()+1);
        }
    }

    private Point getTargetDiagonal(String type, Point origin){
        if(type.equals(Constants.RIGHT)){
            return new Point(origin.getRow()-1, origin.getColumn()+1);
        }else{
            return new Point(origin.getRow()+1, origin.getColumn()-1);
        }
    }

    private Point getTargetRow(String type, Point origin){
        if(type.equals(Constants.RIGHT)){
            return new Point(origin.getRow(), origin.getColumn()+1);
        }else{
            return new Point(origin.getRow(), origin.getColumn()-1);
        }
    }

    private Point getTargetColumn(Point origin){
        return new Point(origin.getRow()+1, origin.getColumn());
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
