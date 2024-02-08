package com.example.demoproject.Model;

import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Util.Position;

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

    @Override
    public Iterable<Move> getMoves(Position from, Chessboard chessboard) {
        return null;
    }
}
