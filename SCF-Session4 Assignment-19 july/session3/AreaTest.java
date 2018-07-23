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
        assertEquals(207.36, area.areaTriangle(12.00, 34.56), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaTriangleWithZero()
    {
        area.areaTriangle(0, 34.56);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaTriangleWithNegetiveArguments()
    {
        area.areaTriangle(12.00, -34.56);
    }
    
    //Tests areaRectangle()
    @Test
    public void testAreaRectangleWithPositiveArguments()
    {
        assertEquals(414.72, area.areaRectangle(12.00, 34.56), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaRectangleWithZero()
    {
        area.areaRectangle(0, 34.56);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaRectangleWithNegetiveArguments()
    {
        area.areaRectangle(12.00, -34.56);
    }
    
    //Tests areaSquare()
    @Test
    public void testAreaSquareWithPositiveArguments()
    {
        assertEquals(1194.3936, area.areaSquare(34.56), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaSquareWithZero()
    {
        area.areaSquare(0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaSquareWithNegetiveArguments()
    {
        area.areaSquare(-34.56);
    }
    
    //Tests areaCircle()
    @Test
    public void testAreaCircleWithPositiveArguments()
    {
        assertEquals(40.6944, area.areaCircle(3.6), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaCircleWithZero()
    {
        area.areaCircle(0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testAreaCircleWithNegetiveArguments()
    {
        area.areaCircle(-34.56);
    }

}
