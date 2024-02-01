package com.example.demoproject.TestingChessboard;

import com.example.demoproject.Model.Chessboard;
import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Model.Piece;
import com.example.demoproject.Util.Direction;
import com.example.demoproject.Util.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.util.List;

@SpringBootTest
public class TestingMoving {
   @Test
    public void testGettingMovesOfApieceInADirection(){
       Chessboard chessboard = new Chessboard();
       chessboard.toString();
       Position from = new Position(1,2);
       Position to = new Position(5,2);
       //Manually get position of a piece.
      Piece pawn12 = chessboard.getSquares()[1][2];
      List<Position> a= (List<Position>) pawn12.MovePositionsInDir(from,chessboard, Direction.South);
      AssertionErrors.assertEquals("Moved down successfully",a.get(0).getX(),2);

   }
}
