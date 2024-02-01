package com.example.demoproject.Util;

public class Direction {

    public static Direction North = new Direction(-1,0);
    public static Direction South = new Direction(1,0);
    public static Direction East = new Direction(0,1);
    public static Direction West = new Direction(0,-1);
    public static Direction NorthEast = Direction.add(North, East);
    public static Direction NorthWest = Direction.add(North,West);
    public static Direction SouthEast = Direction.add(South,East);
    public static Direction SouthWest = Direction.add(South,West);

    public int rowDelta;
    public int columnDelta;

    public Direction(int rowDelta, int columnDelta){
        this.rowDelta = rowDelta;
        this.columnDelta = columnDelta;
    }

    public static Direction add(Direction dir1, Direction dir2){
        return new Direction(dir1.rowDelta + dir2.rowDelta, dir1.columnDelta + dir2.columnDelta);
    }

    public static Direction scale(int scalar, Direction dir){
        return new Direction(scalar * dir.rowDelta, scalar * dir.columnDelta);
    }
}
