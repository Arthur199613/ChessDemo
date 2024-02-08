package com.example.demoproject.Logic;


import com.example.demoproject.DTO.MoveRequest;
import com.example.demoproject.Model.*;

public class Game {
    Chessboard chessboard;

    public Game() {
        //initialises pieces also
        chessboard = new Chessboard();
    }
    private void setSquareColourAndChessboard(Piece[][] squares) {
    }
    public boolean makeMove(int fromX, int fromY,int toX,int toY){
        return chessboard.makeMove(fromX,fromY,toX,toY);
    }

    public Chessboard getChessboard() {
        return this.chessboard;
    }
}
