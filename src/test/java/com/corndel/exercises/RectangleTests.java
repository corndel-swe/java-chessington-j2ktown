package com.corndel.exercises;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import kotlin.reflect.jvm.internal.impl.util.Check;
import okhttp3.Call;
import org.junit.jupiter.api.Test;

public class RectangleTests {

//    Write a test that checks that the area method of Rectangle returns the correct value:
//
//    Arrange: You should create a new Rectangle with a known width and height.
//
//            Act: Call the area method on the Rectangle.
//
//            Assert: Check that the result is the expected area.
//
//    Similarly, write a test that checks that the perimeter method of Rectangle returns the correct value.
//
//    Run your test with ./mvnw clean test -Dtest=RectangleTests.java in your terminal.

    @Test
    public void checkAreaOfRectangleTest(){
        Rectangle rectangle = new Rectangle(5,5);
        double result = rectangle.getArea();
        assertEquals(25.0,result);
    }

    @Test
    public void checkPerimeterOfRectangleTest(){
        double width = 5;
        double height = 5;
        Rectangle rectangle = new Rectangle(width, height);
        double result = rectangle.getPerimeter();
        double expected = 2 * (height + width);
        assertEquals(expected,result);
    }
}
