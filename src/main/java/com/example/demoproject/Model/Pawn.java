package com.example.demoproject.Model;

import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Util.Direction;
import com.example.demoproject.Util.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece{

    boolean isFirstMove = true;
    Piece blockingPiece = null;

    private static Direction forward;

   public Pawn(Colour colour, PieceType type){
        this.colour = colour;
        this.type = type;

        if (this.colour == Colour.WHITE){
            forward = Direction.North;
        }
        else if (this.colour == Colour.BLACK){
            forward = Direction.South;
        }
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
        if (chessboard.getSquares()[toX][toY] != null && chessboard.getSquares()[toX][toY].getColour().equals(this.getColour()) ) {
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

    private boolean canCaptureAt(Position pos, Chessboard chessboard){

       if(!chessboard.isInside(pos) || chessboard.isEmpty(pos) ){
           return false;
       }
       return chessboard.getSquares()[pos.getX()][pos.getY()].colour != this.colour;
    }

    private static boolean canMoveTo(Position pos, Chessboard chessboard){
       return chessboard.isInside(pos) && chessboard.getSquares()[pos.getX()][pos.getY()] == null;
    }

    private Iterable<Move> forwardMoves(Position from, Chessboard chessboard) {
        Position oneMovePos = Position.add(from, forward);
        Position twoMovePos = Position.add(oneMovePos, forward);

        //Check the colour of the pawn...
        List<Move> moves = new ArrayList<>();
        if (canMoveTo(oneMovePos, chessboard) && !hasMoved) {
            moves.add(new NormalMove(from, twoMovePos));
        }
        moves.add(new NormalMove(from, oneMovePos));
        return moves;
    }

    private Iterable<Move> diagonalMoves(Position from,Chessboard chessboard){
        Direction[] dirs = {Direction.West,Direction.East};
        List<Move> moveList = new ArrayList<>();
        for (Direction dir : dirs
             ) {
            Position to = Position.add(Position.add(from,forward),dir);

            if (canMoveTo(to,chessboard)){
                moveList.add(new NormalMove(from,to));
            }
        }
        return moveList;
    }

    //TODO keep an eye for this.
    @Override
    public Iterable<Move> getMoves(Position from, Chessboard chessboard) {
        List<Move> moves = new ArrayList<>();
        //Check colour here...
        if(chessboard.getPieceAtPosition(from).colour.equals(Colour.BLACK)){
            forward = Direction.South;
        }
        else
            forward =Direction.North;

        // Assuming forwardMoves and diagonalMoves return List<Move>
        moves.addAll((Collection<? extends Move>) forwardMoves(from, chessboard));
        moves.addAll((Collection<? extends Move>) diagonalMoves(from, chessboard));

        return moves;
    }
}
