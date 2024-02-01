package com.example.demoproject.Model.Move;

import com.example.demoproject.Model.Chessboard;
import com.example.demoproject.Util.Position;

public abstract class Move {


    public abstract MoveType type();
    public abstract void execute(Chessboard chessboard);

}
