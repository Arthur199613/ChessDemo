package com.example.demoproject.Model;

import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Util.Direction;
import com.example.demoproject.Util.Position;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

   public abstract String getPieceType();

    public abstract Boolean isValidMove(Chessboard chessboard, int toX, int toY, int fromX, int fromY);

    //public abstract Iterable<Move> GetMoves(Position from, Position to);

    //GetAllThePossibleMovePositions, this should include the piece in the way
    public Iterable<Position> MovePositionsInDir(Position from, Chessboard chessboard, Direction dir) {
        List<Position> positionList = new ArrayList<>();

        for (Position pos = Position.add(from, dir); chessboard.isInside(pos); pos = Position.add(pos, dir)) {
            if (chessboard.squares[pos.getX()][pos.getY()] == null) {
                positionList.add(pos);
            } else {
                Piece pieceAtPosition = chessboard.squares[pos.getX()][pos.getY()];
                if (!pieceAtPosition.getColour().equals(this.colour.toString())) {
                    positionList.add(pos);
                }
                break;
            }
        }
        return positionList;
    }

    public Iterable<Position> MovePositionsInDirs(Position from, Chessboard chessboard, Direction[] dirs) {
        List<Position> listOfAllPositions = new ArrayList<>();
        for (Direction dir : dirs) {
            // Convert Iterable to Collection
            Collection<Position> positionsInDir = (Collection<Position>) MovePositionsInDir(from, chessboard, dir);
            listOfAllPositions.addAll(positionsInDir);
        }
        return listOfAllPositions;
    }
}

