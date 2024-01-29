package com.example.demoproject.Service;

import com.example.demoproject.DTO.MoveRequest;
import com.example.demoproject.Logic.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    Game game;
    public Game initializeGame() {
        // Initialize the board, set up pieces, etc.
        // (similar to the previous initialization logic)
        return game = new Game();

    }

    public boolean gameServicevalidateMove(MoveRequest moveRequest){
        return game.validateMove(moveRequest);

    }
}
