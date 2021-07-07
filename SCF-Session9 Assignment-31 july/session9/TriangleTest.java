package session9;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest
{
    Point originTriangle = new Point(5, 9);
    Shape triangle = new Triangle(originTriangle, 4, 6, 5, 5);

    @Test
    public void testGetArea()
    {
        double expectedOutput = 12.0;
        double actualOutput = triangle.getArea();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetPerimeter()
    {
        double expectedOutput = 16.0;
        double actualOutput = triangle.getPerimeter();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetOrigin()
    {
        double[] expectedOutput = {5, 9};
        double[] actualOutput = 
            {triangle.getOrigin().getXCoordinate(), triangle.getOrigin().getYCoordinate()};
        
        assertArrayEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testIsPointEnclosedWithPointInShape()
    {
        Point point = new Point(6, 10);
        boolean expectedOutput = true;
        boolean actualOutput = triangle.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsPointEnclosedWithPointNotInShape()
    {
        Point point = new Point(1000, 340);
        boolean expectedOutput = false;
        boolean actualOutput = triangle.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }
}
