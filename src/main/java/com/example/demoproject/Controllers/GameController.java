package com.example.demoproject.Controllers;

import com.example.demoproject.Logic.Game;
import com.example.demoproject.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // Other controller methods
}

