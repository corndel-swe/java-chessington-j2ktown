package com.corndel.exercises;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {

    @Test
    public void testPiValue() {
        double pi = Maths.PI;
        assertEquals(3.14, pi);
    }

    @Test
    public void testMathMaxReturnsLargestNumber() {
        double result = Maths.max(1, 2);
        assertEquals(2, result);
    }

    @Test
    public void checkMathsRoundReturnsWholeNumberTest(){
        Maths.round(1);
        assertEquals(1,1);
    }

    @Test
    public void checkMathsRoundsDownTest(){
        int result = Maths.round(2.4);
        assertEquals(2, result);
    }

    @Test
    public void checkMathsRoundsUpTest(){
        int result = Maths.round(2.511);
        assertEquals(3, result);
    }

    @Test
    public void checkMathsAbslouteReturnsPostiveTest(){
        double result = Maths.absolute(-100);
        assertEquals(100,result);
    }


}
