package com.mycompany.game.check;

import com.mycompany.game.Point;
import com.mycompany.game.move.Column;
import com.mycompany.game.move.Diagonal;
import com.mycompany.game.move.ReverseDiagonal;
import com.mycompany.game.move.Row;

public interface SuperChecker {

    public Point getRight(Diagonal diagonal);
    public Point getRight(ReverseDiagonal reverseDiagonal);
    public Point getRight(Row row);
    public Point getRight(Column column);

    public Point getLeft(Diagonal diagonal);
    public Point getLeft(ReverseDiagonal reverseDiagonal);
    public Point getLeft(Row row);
    public Point getLeft(Column column);

    public boolean isInRange(Diagonal diagonal, Point target);
    public boolean isInRange(ReverseDiagonal reverseDiagonal, Point target);
    public boolean isInRange(Row row, Point target);
    public boolean isInRange(Column column, Point target);
}
