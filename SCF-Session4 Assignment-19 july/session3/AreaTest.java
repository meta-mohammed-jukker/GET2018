package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AreaTest
{
    Area area = new Area();
    
    //Tests areaTriangle()
    @Test
    public void testAreaTriangleWithPositiveArguments()
    {
        double expectedWidth = 12.00;
        double expectedHeight = 34.56;
        double expectedArea = 207.36;
        assertEquals(expectedArea, area.areaTriangle(expectedWidth, expectedHeight), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaTriangleWithZero()
    {
        double expectedWidth = 0;
        double expectedHeight = 34.56;
        area.areaTriangle(expectedWidth, expectedHeight);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaTriangleWithNegetiveArguments()
    {
        double expectedWidth = 12.00;
        double expectedHeight = -34.56;
        area.areaTriangle(expectedWidth, expectedHeight);
    }
    
    //Tests areaRectangle()
    @Test
    public void testAreaRectangleWithPositiveArguments()
    {
        double expectedWidth = 12.00;
        double expectedHeight = 34.56;
        double expectedArea = 414.72;
        assertEquals(expectedArea, area.areaRectangle(expectedWidth, expectedHeight), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaRectangleWithZero()
    {
        double expectedWidth = 0;
        double expectedHeight = 34.56;
        area.areaRectangle(expectedWidth, expectedHeight);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaRectangleWithNegetiveArguments()
    {
        double expectedWidth = 12.00;
        double expectedHeight = -34.56;
        area.areaRectangle(expectedWidth, expectedHeight);
    }
    
    //Tests areaSquare()
    @Test
    public void testAreaSquareWithPositiveArguments()
    {
        double expectedSide = 34.56;
        double expectedArea = 1194.3936;
        assertEquals(expectedArea, area.areaSquare(expectedSide), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaSquareWithZero()
    {
        double expectedSide = 0;
        area.areaSquare(expectedSide);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaSquareWithNegetiveArguments()
    {
        double expectedSide = -34.56;
        area.areaSquare(expectedSide);
    }
    
    //Tests areaCircle()
    @Test
    public void testAreaCircleWithPositiveArguments()
    {
        double expectedRadius = 3.6;
        double expectedArea = 40.6944;
        assertEquals(expectedArea, area.areaCircle(expectedRadius), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaCircleWithZero()
    {
        double expectedRadius = 0;
        area.areaCircle(expectedRadius);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaCircleWithNegetiveArguments()
    {
        double expectedRadius = -34.56;
        area.areaCircle(expectedRadius);
    }

}
