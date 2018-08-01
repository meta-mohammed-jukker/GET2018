package session9;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircleTest
{
    Point center = new Point(5, 9);
    Shape circle = new Circle(center, 3);

    @Test
    public void testGetArea()
    {
        double expectedOutput = 28.25;
        double actualOutput = circle.getArea();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetPerimeter()
    {
        double expectedOutput = 18.84;
        double actualOutput = circle.getPerimeter();

        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetOrigin()
    {
        double[] expectedOutput = {3.54, 6.37};
        double[] actualOutput = 
            {circle.getOrigin().getXCoordinate(), circle.getOrigin().getYCoordinate()};
        
        assertArrayEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testIsPointEnclosedWithPointInShape()
    {
        Point point = new Point(6, 10);
        boolean expectedOutput = true;
        boolean actualOutput = circle.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsPointEnclosedWithPointNotInShape()
    {
        Point point = new Point(11, 10);
        boolean expectedOutput = false;
        boolean actualOutput = circle.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }

}
