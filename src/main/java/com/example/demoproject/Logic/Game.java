package com.example.demoproject.Logic;


import com.example.demoproject.Model.*;

public class Game {
    Chessboard chessboard;

    public Game() {
        this.chessboard = new Chessboard();
        Square[][] squares = new Square[8][8];

        // Initialize squares with pieces or null for empty squares
        // This is a simplified example for illustration
        setSquareColourAndChessboard(squares);

        // Set initialized squares to the chessboard
        this.chessboard.setSquares(squares);
    }

    private void setSquareColourAndChessboard(Square[][] squares) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0 ; j < squares[0].length;j++){
                if(i%2 + j%2==0){
                    squares[i][j] = new Square(Colour.BLACK);
                }
                else
                    squares[i][j] = new Square(Colour.WHITE);
            }
        }
    }

    private void setPieces(Square[][] squares){
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if(i == 0){
                    squares[i][j].setPiece(new Piece(PieceType.ROOK,Colour.BLACK));
                }
            }
        }
    }


    public Chessboard getChessboard() {
        return this.chessboard;
    }
}
