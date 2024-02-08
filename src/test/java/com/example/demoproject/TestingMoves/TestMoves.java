package com.example.demoproject.TestingMoves;

import com.example.demoproject.Model.Bishop;
import com.example.demoproject.Model.Chessboard;
import com.example.demoproject.Model.Colour;
import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Model.PieceType;
import com.example.demoproject.Util.Position;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class TestMoves {
    @Test
    public void movesAvailableToBlackBishopFromStart() {
        // Create a mock Chessboard and a mock Piece implementation for testing
        Chessboard chessboard = new Chessboard(/* initialize parameters */);
        Bishop piece = new Bishop(Colour.BLACK, PieceType.BISHOP);

        // Set up the chessboard and piece positions for testing
        // ...

        Position a = new Position(0,2);
        // Call GetMoves and check the result
        Iterable<Move> moves = piece.getMoves(a, chessboard);
        for (Move move:moves){
            System.out.println(move);
        }
        List<Move> moveList = (List<Move>) moves;
        AssertionErrors.assertEquals("Moves should be 0",moveList.isEmpty(),true);

        // Perform assertions based on your expectations

        // Add more assertions as needed
    }

}
