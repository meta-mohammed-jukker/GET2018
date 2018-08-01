package session9;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest
{
    Point originRectangle = new Point(5, 9);
    Shape rectangle = new Rectangle(originRectangle, 3, 7);

    @Test
    public void testGetArea()
    {
        double expectedOutput = 21.0;
        double actualOutput = rectangle.getArea();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetPerimeter()
    {
        double expectedOutput = 20.0;
        double actualOutput = rectangle.getPerimeter();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetOrigin()
    {
        double[] expectedOutput = {5, 9};
        double[] actualOutput = 
            {rectangle.getOrigin().getXCoordinate(), rectangle.getOrigin().getYCoordinate()};
        
        assertArrayEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testIsPointEnclosedWithPointInShape()
    {
        Point point = new Point(6, 10);
        boolean expectedOutput = true;
        boolean actualOutput = rectangle.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsPointEnclosedWithPointNotInShape()
    {
        Point point = new Point(1000, 340);
        boolean expectedOutput = false;
        boolean actualOutput = rectangle.isPointEnclosed(point);
        
        assertEquals(expectedOutput, actualOutput);
    }
}
