package com.example.demoproject.Model;

public class Chessboard {
    Square[][] squares;

    public void setSquares(Square[][] squares) {
        this.squares =squares;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public Square[] flattenArray(Square[][] squares) {
        int rows = squares.length;
        int cols = squares[0].length;
        Square[] flattenedArray = new Square[rows * cols];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flattenedArray[index++] = squares[i][j];
            }
        }
        return flattenedArray;
    }

    //64 positions... e.g. 0-7, 8-15 etc
    //Start from top left

}
