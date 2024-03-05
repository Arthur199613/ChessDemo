package com.example.demoproject.Model.Move;

import com.example.demoproject.Model.Chessboard;
import com.example.demoproject.Model.Player;
import com.example.demoproject.Util.Position;

public abstract class Move {


    public abstract MoveType type();

    public abstract Position fromPos();
    public abstract Position toPos();

    public abstract void execute(Chessboard chessboard);

    public boolean isLegal(Chessboard chessboard){
        Player player;
        //TODO This is a quick fix, will change some other time
        if(chessboard.getPieceAtPosition(fromPos()).getColour().equals("WHITE")){
            player = Player.White;
        }
        else
            player = Player.Black;

        Chessboard chessboardCopy = chessboard.copy();
        execute(chessboardCopy);
        return !chessboardCopy.isInCheck(player);
    }

}
