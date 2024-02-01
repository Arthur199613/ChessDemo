package com.example.demoproject.TestUtil;

import com.example.demoproject.Util.Direction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

@SpringBootTest
public class TestingDir {

    @Test
    public void TestingAddingOfDirections(){
        Direction direction = new Direction(3,4);
        Direction direction1 = new Direction(3,4);

        Direction n = Direction.add(direction,direction1);

        AssertionErrors.assertEquals("Should be the same",6,n.rowDelta);
        AssertionErrors.assertEquals("should be the same",8,n.columnDelta);
    }

    @Test
    public void DirectionSouthEastIsCorrect(){
        AssertionErrors.assertEquals(String.valueOf(Direction.NorthEast.columnDelta),1,Direction.NorthEast.columnDelta);
    }


}
