package com.example.demoproject.Model;

import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Util.Direction;
import com.example.demoproject.Util.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

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
        List<Move> moveList = new ArrayList<>();

        for (Position pos : filteredMoves(from, chessboard)) {
            moveList.add(new NormalMove(from, pos)); // Assuming Move constructor takes two positions
        }
        return moveList;
    }

    private Iterable<Position> getPossibleToPositions(Position from){
        List<Position> positions = new ArrayList<>();
        for (Direction vDir: new Direction[]{Direction.North,Direction.South}
             ) {
            for (Direction hDir: new Direction[]{Direction.West,Direction.East}
                 ) {
                Direction scaleUp = Direction.scale(2,vDir);
                Direction scaleHor = Direction.scale(2,hDir);
                positions.add(Position.add(Position.add(from,scaleUp),hDir));
                positions.add(Position.add(Position.add(from,scaleHor),vDir));
            }
        }
        return positions;
    }

    private Iterable<Position> filteredMoves(Position from, Chessboard chessboard){
        List<Position> positions = new ArrayList<>();

        for (Position pos: getPossibleToPositions(from)) {
            if(chessboard.isInside(pos) && (chessboard.isEmpty(pos) ||
            chessboard.getPieceAtPosition(pos).colour != this.colour)){
                positions.add(pos);
            }
        }
        return positions;
    }

    @Override
    Piece copy() {
        Knight copy = new Knight(colour,type);
        copy.hasMoved = hasMoved;
        return copy;
    }
}
