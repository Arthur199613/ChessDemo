package com.example.demoproject.Model;

import org.springframework.context.annotation.Bean;

public abstract class Piece {

    Colour colour;
    String svgPath;
    PieceType type;


    public String getColour() {
        return colour.toString();
    }

    public Piece getPiece(){
        return this;
    }

    public abstract Boolean isValidMove(Chessboard chessboard, int toX, int toY, int fromX, int fromY);
}

