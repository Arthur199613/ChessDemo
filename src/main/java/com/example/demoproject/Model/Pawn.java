package com.example.demoproject.Model;

public class Pawn extends Piece{

    boolean isFirstMove = true;
    Piece blockingPiece = null;

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


    public String getPieceType(){
       return type.toString();
    }



    @Override
    public Boolean isValidMove(Chessboard chessboard, int toX, int toY, int fromX, int fromY) {
        if (chessboard.getSquares()[toX][toY] != null && chessboard.getSquares()[toX][toY].getColour() == this.getColour()) {
            return false;
        }

        if (this.isFirstMove) {
            if (this.getColour().equals(Colour.WHITE.toString()) && toX == fromX + 2) {
                if (chessboard.getSquares()[fromX + 1][fromY] == null) {
                    return true;
                } else {
                    blockingPiece = chessboard.getSquares()[fromX + 1][fromY].getPiece();
                }
            } else if (this.getColour().equals(Colour.BLACK.toString()) && toX == fromX - 2) {
                if (chessboard.getSquares()[fromX - 1][fromY] == null) {
                    return true;
                } else {
                    blockingPiece = chessboard.getSquares()[fromX - 1][fromY].getPiece();
                }
            }
        }

        if (this.getColour().equals(Colour.WHITE.toString()) && toY == fromY + 1 && toX == fromX){
            if (chessboard.getSquares()[toX][toY] == null){
                return true;
            } else {
                blockingPiece = chessboard.getSquares()[toX][toY].getPiece();
            }
        } else if (this.getColour().equals(Colour.BLACK.toString()) && toY == fromY - 1 && toX == fromX){
            if (chessboard.getSquares()[toX][toY] == null) {
                return true;
            } else {
                blockingPiece = chessboard.getSquares()[toX][toY].getPiece();
            }
        }

        return false;
    }
}
