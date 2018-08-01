package session9;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest
{
    Point originSquare = new Point(5, 9);
    Shape square = new Square(originSquare, 3);

    @Test
    public void testGetArea()
    {
        double expectedOutput = 9.0;
        double actualOutput = square.getArea();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetPerimeter()
    {
        double expectedOutput = 12.0;
        double actualOutput = square.getPerimeter();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetOrigin()
    {
        double[] expectedOutput = {5, 9};
        double[] actualOutput = 
            {square.getOrigin().getXCoordinate(), square.getOrigin().getYCoordinate()};
        
        assertArrayEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testIsPointEnclosedWithPointInShape()
    {
        Point point = new Point(6, 10);
        boolean expectedOutput = true;
        boolean actualOutput = square.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsPointEnclosedWithPointNotInShape()
    {
        Point point = new Point(1000, 340);
        boolean expectedOutput = false;
        boolean actualOutput = square.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }
}
