package session9;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShapeUtilTest
{
    ShapeUtil shapeUtil = new ShapeUtil();
    @Test
    public void test()
    {
        Point point1 = new Point(12, 6);
        Point point2 = new Point(0, 0);
        
        double expectedOutput = 13.41;
        double actualOutput = shapeUtil.getDistance(point1, point2);
        
        assertEquals(expectedOutput, actualOutput, 0.01);
    }

}
