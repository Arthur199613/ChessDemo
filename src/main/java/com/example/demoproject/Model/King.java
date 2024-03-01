package com.example.demoproject.Model;

import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Util.Direction;
import com.example.demoproject.Util.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Colour colour,PieceType type){
        this.colour = colour;
        this.type = type;
    }

    private static final Direction[] dirs = new Direction[]{
            Direction.North,
            Direction.East,
            Direction.West,
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

    private Iterable<Position> movePositions(Position from, Chessboard chessboard){
        List<Position> positions = new ArrayList<>();

        for (Direction dir: dirs
             ) {
            Position to = Position.add(from,dir);

            if(!chessboard.isInside(to)){
                continue;
            }

            if(chessboard.isEmpty(to) || !chessboard.getPieceAtPosition(to).colour.equals(this.colour)){
                positions.add(to);
            }
        }
        return positions;
    }
    @Override
    public Iterable<Move> getMoves(Position from, Chessboard chessboard) {
        List<Move> moves =new ArrayList<>();
        for (Position to: movePositions(from,chessboard)
             ) {
            moves.add(new NormalMove(from,to));
        }
        return moves;
    }
}
