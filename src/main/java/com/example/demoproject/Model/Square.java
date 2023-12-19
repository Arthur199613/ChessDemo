package com.example.demoproject.Model;

public class Square {

    Piece piece;
    Colour colour;


    public Square(Colour colour){
        this.colour = colour;
    }
    public void setSquares(Piece piece) {
        this.piece = piece;
    }

    public void setColour(Colour colour){
        this.colour = colour;
    }

    public Piece getPiece() {
        return piece;
    }

    public Colour squareGetColour(){
        return this.colour;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


}
