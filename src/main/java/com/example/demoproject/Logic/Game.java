package com.example.demoproject.Logic;


import com.example.demoproject.Model.*;

public class Game {
    Chessboard chessboard;

    public Game() {
        //initialises pieces also
        chessboard = new Chessboard();
    }

    private void setSquareColourAndChessboard(Piece[][] squares) {

    }




    public Chessboard getChessboard() {
        return this.chessboard;
    }
}
