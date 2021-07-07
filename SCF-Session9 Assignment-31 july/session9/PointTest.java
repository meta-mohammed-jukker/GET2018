package session9;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest
{
    Point point = new Point(123, 456);
    
    @Test
    public void testGetXCoordinate()
    {
        double expectedOutput = 123.0;
        double actualOutput = point.getXCoordinate();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
    
    @Test
    public void testGetYCoordinate()
    {
        double expectedOutput = 456.0;
        double actualOutput = point.getYCoordinate();
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }
}
