package com.example.demoproject.Controllers;

import com.example.demoproject.DTO.MoveRequest;
import com.example.demoproject.Logic.Game;
import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Service.GameService;
import com.example.demoproject.Util.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/legalMoves/{x}/{y}")
    public ResponseEntity<List<Move>> getLegalMoves(@PathVariable int x, @PathVariable int y){
        Position from = new Position(x,y);
        List<Move> legalMoves = gameService.getLegalMoves(from);

        return ResponseEntity.ok(legalMoves);
    }

    @RequestMapping("/game")
    public String showGame(Model model) {
        // Get the game data (board state, etc.) and add it to the model
        Game game =gameService.initializeGame(); // Retrieve game data (from service, etc.)
                model.addAttribute("game", game.getChessboard());
        return "game"; // Return the name of the Thymeleaf template (game1.html)
    }

    //ToDo Validate Move Function
    @PostMapping("/makeMove/{fromX}/{fromY}/{toX}/{toY}")
    public ResponseEntity<Boolean> makeMove(@PathVariable int fromX, @PathVariable int fromY,@PathVariable
                                            int toX, @PathVariable int toY){

        boolean isValidMove = gameService.makeMove(fromX,fromY,toX,toY);
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

