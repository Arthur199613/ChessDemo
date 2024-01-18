package com.example.demoproject.Model;

public class Pawn extends Piece{

   public Pawn(Colour colour, PieceType type){
        this.colour = colour;
        this.type = type;
        System.out.println(this);
    }

    @Override
    public String toString(){
        String className = this.getClass().getSimpleName();

        return "This is a " +
                colour + " "+ className;
    }

    public String getColour(){
       return colour.toString();
    }

    public String getPieceType(){
       return type.toString();
    }
}
