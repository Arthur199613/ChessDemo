package com.example.demoproject.Service;

import com.example.demoproject.DTO.MoveRequest;
import com.example.demoproject.Logic.Game;
import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Piece;
import com.example.demoproject.Model.Player;
import com.example.demoproject.Util.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    Game game;
    public Game initializeGame() {
        // Initialize the board, set up pieces, etc.
        // (similar to the previous initialization logic)
        return game = new Game();

    }

    public List<Move> getLegalMoves(Position from) {
        Piece piece = game.getChessboard().getPieceAtPosition(from);
        return piece != null ? toList(piece.getMoves(from, game.getChessboard())) : Collections.emptyList();
    }

    private List<Move> toList(Iterable<Move> iterable) {
        List<Move> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public boolean makeMove(int fromX, int fromY,int toX, int toY){
        return game.makeMove(fromX,fromY,toX,toY);
    }

    public Player getCurrentTurn(){
        return game.getPlayer();
    }

    public void switchPlayer(){
         game.switchPlayer();
    }
}
