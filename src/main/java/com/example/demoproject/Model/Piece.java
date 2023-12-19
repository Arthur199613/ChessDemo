package com.example.demoproject.Model;

public class Piece {
    PieceType pieceType;
    Colour colour;

    public Piece(PieceType pieceType, Colour colour) {
        this.pieceType = pieceType;
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "This piece is a " +
                pieceType + " of " +colour;
    }
}
