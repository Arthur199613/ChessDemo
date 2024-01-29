package com.example.demoproject.Controllers;

import com.example.demoproject.DTO.MoveRequest;
import com.example.demoproject.Logic.Game;
import com.example.demoproject.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping("/game")
    public String showGame(Model model) {
        // Get the game data (board state, etc.) and add it to the model
        Game game =gameService.initializeGame(); // Retrieve game data (from service, etc.)
                model.addAttribute("game", game.getChessboard());
        return "game"; // Return the name of the Thymeleaf template (game1.html)
    }

    //ToDo Validate Move Function
    @PostMapping("/makeMove")
    public ResponseEntity<Boolean> makeMove(@RequestBody MoveRequest moveRequest){
        boolean isValidMove = gameService.gameServicevalidateMove(moveRequest);
        if (isValidMove) {
            // Update the game state if the move is valid
            // You can also return additional information if needed
            return ResponseEntity.ok(true);
        } else {
            // Return a response indicating the move is invalid
            return ResponseEntity.ok(false);
        }

    }

    // Other controller methods
}

