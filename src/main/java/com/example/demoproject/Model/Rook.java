package com.example.demoproject.Model;

import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Util.Direction;
import com.example.demoproject.Util.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

   public Rook(Colour colour, PieceType type){
       this.colour = colour;
       this.type = type;
   }

   public static Direction[] dirs = {
           Direction.North,
           Direction.West,
           Direction.East,
           Direction.South
    };

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
        List<Move> moves = new ArrayList<>();

        Iterable<Position> positions = MovePositionsInDirs(from,chessboard,dirs);
        for(Position to : positions){
            moves.add(new NormalMove(from,to));
        }
        return moves;
    }

    @Override
    Piece copy() {
        Rook copy = new Rook(colour,type);
        copy.hasMoved = hasMoved;
        return copy;
    }
}
