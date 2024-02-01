package com.example.demoproject.Util;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }


    public static Position add(Position pos, Direction dir){
        return new Position(pos.x + dir.rowDelta, pos.y + dir.columnDelta);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
