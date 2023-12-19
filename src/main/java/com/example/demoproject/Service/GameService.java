package com.example.demoproject.Service;

import com.example.demoproject.Logic.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    public Game initializeGame() {
        // Initialize the board, set up pieces, etc.
        // (similar to the previous initialization logic)
        return new Game();
    }
}
