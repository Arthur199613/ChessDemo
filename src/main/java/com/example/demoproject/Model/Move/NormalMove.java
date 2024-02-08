package com.example.demoproject.Model.Move;

import com.example.demoproject.Model.Chessboard;
import com.example.demoproject.Model.Piece;
import com.example.demoproject.Util.Position;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class NormalMove extends Move{


    private Position fromPos;
    private Position toPos;
    public NormalMove(Position from, Position to){
        this.fromPos = from;
        this.toPos = to;
    }
    @Override
    public MoveType type(){
        return MoveType.Normal;
    }

    @JsonIgnore
    @Override
    public void execute(Chessboard chessboard) {
        Piece piece = chessboard.getSquares()[fromPos.getX()][fromPos.getY()];
        chessboard.getSquares()[toPos.getX()][toPos.getY()] = piece;
        chessboard.getSquares()[fromPos.getX()][fromPos.getY()] = null;
        System.out.println("Move has been executed");
        //Additional piece.HasMoved property set to true.
    }

    public Position getFromPos() {
        return fromPos;
    }

    public Position getToPos() {
        return toPos;
    }
}
