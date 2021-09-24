package com.mycompany.game.check;

import com.mycompany.game.Point;
import com.mycompany.game.move.Column;
import com.mycompany.game.move.Diagonal;
import com.mycompany.game.move.ReverseDiagonal;
import com.mycompany.game.move.Row;

public interface SuperChecker {

    public Point getRight(Diagonal diagonal, Point origin);
    public Point getRight(ReverseDiagonal reverseDiagonal, Point origin);
    public Point getRight(Row row, Point origin);
    public Point getRight(Column column, Point origin);

    public Point getLeft(Diagonal diagonal, Point origin);
    public Point getLeft(ReverseDiagonal reverseDiagonal, Point origin);
    public Point getLeft(Row row, Point origin);
    public Point getLeft(Column column, Point origin);

    public boolean isInRange(Diagonal diagonal, Point target);
    public boolean isInRange(ReverseDiagonal reverseDiagonal, Point target);
    public boolean isInRange(Row row, Point target);
    public boolean isInRange(Column column, Point target);
}
