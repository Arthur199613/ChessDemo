package com.example.demoproject.Logic;


import com.example.demoproject.DTO.MoveRequest;
import com.example.demoproject.Model.*;

public class Game {
    Chessboard chessboard;
    Player currentPlayer;

    public Game() {
        //initialises pieces also
        chessboard = new Chessboard();
        currentPlayer = Player.White;
    }
    private void setSquareColourAndChessboard(Piece[][] squares) {
    }
    public boolean makeMove(int fromX, int fromY,int toX,int toY){
        return chessboard.makeMove(fromX,fromY,toX,toY);
    }

    public Chessboard getChessboard() {
        return this.chessboard;
    }

    public Player getPlayer(){
        return currentPlayer;
    }

    public void switchPlayer(){
         currentPlayer = currentPlayer==Player.White ? Player.Black : Player.White;
    }
}
