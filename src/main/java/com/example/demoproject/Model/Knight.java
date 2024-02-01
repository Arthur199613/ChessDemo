package com.example.demoproject.Model;

public class Knight extends Piece{

    public Knight(Colour colour, PieceType type){
        this.colour = colour;
        this.type = type;
    }

    @Override
    public String getPieceType() {
        return this.type.toString();
    }
    @Override
    public Boolean isValidMove(Chessboard chessboard, int toX, int toY, int fromX, int fromY) {
        return null;
    }
}
