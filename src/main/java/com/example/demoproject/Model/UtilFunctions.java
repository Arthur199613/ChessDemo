package com.example.demoproject.Model;

public class UtilFunctions {
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
}
