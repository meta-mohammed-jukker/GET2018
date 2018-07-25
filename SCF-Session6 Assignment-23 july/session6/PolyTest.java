package session6;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest
{
    //Tests cases for evaluate()
    @Test
    public void testEvaluate()
    {
        int[] inputArray = {1, 0, 4};
        Poly poly = new Poly(inputArray);
        float expectedOutput = 17;
        assertEquals(expectedOutput, poly.evaluate(2), 0);
    }
    
    @Test
    public void testEvaluateWithEmptyArray()
    {
        int[] inputArray = {};
        Poly poly = new Poly(inputArray);
        float expectedOutput = 0;
        assertEquals(expectedOutput, poly.evaluate(2), 0);
    }
    
    @Test
    public void testEvaluateWithValueEqualsZero()
    {
        int[] inputArray = {1, 2, 3};
        Poly poly = new Poly(inputArray);
        float expectedOutput = 1;
        assertEquals(expectedOutput, poly.evaluate(0), 0);
    }
    
  //Tests cases for degree()
    @Test
    public void testDegree()
    {
        int[] inputArray = {1, 0, 4};
        Poly poly = new Poly(inputArray);
        int expectedOutput = 2;
        assertEquals(expectedOutput, poly.degree());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDegreeWithEmptyArray()
    {
        int[] inputArray = {};
        Poly poly = new Poly(inputArray);
        poly.degree();
    }
    
  //Tests cases for addPoly()
    @Test
    public void testAddPoly()
    {
        int[] inputArray1 = {1, 0, 4};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {3, 4, 0, 0, 5};
        Poly poly2 = new Poly(inputArray2);
        
        int[][] expectedOutput = {{4, 0},
                                  {4, 1}, 
                                  {4, 2}, 
                                  {5, 4}};
        
        Poly poly;
        poly = poly1.addPoly(poly2);
        int[][] actualOutput = poly.getPolynomialArray();
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddPolyWithFirstArrayAsEmpty()
    {
        int[] inputArray1 = {};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {3, 4, 0, 0, 5};
        Poly poly2 = new Poly(inputArray2);
        
        poly1.addPoly(poly2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddPolyWithSecondArrayAsEmpty()
    {
        int[] inputArray1 = {3, 4, 0, 0, 5};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {};
        Poly poly2 = new Poly(inputArray2);
        
        poly1.addPoly(poly2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddPolyWithBothArraysAsEmpty()
    {
        int[] inputArray1 = {};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {};
        Poly poly2 = new Poly(inputArray2);
        
        poly1.addPoly(poly2);
    }
    
  //Tests cases for multiplyPoly()
    @Test
    public void testMultiplyPoly()
    {
        int[] inputArray1 = {1, 0, 4};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {3, 4, 0, 0, 5};
        Poly poly2 = new Poly(inputArray2);
        
        int[][] expectedOutput = {{3, 0},
                                  {4, 1}, 
                                  {12, 2},
                                  {16, 3},
                                  {5, 4},
                                  {20, 6}};
        
        Poly poly;
        poly = poly1.multiplyPoly(poly2);
        int[][] actualOutput = poly.getPolynomialArray();
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMultiplyPolyWithFirstArrayAsEmpty()
    {
        int[] inputArray1 = {};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {3, 4, 0, 0, 5};
        Poly poly2 = new Poly(inputArray2);
        
        poly1.multiplyPoly(poly2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMultiplyPolyWithSecondArrayAsEmpty()
    {
        int[] inputArray1 = {3, 4, 0, 0, 5};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {};
        Poly poly2 = new Poly(inputArray2);
        
        poly1.multiplyPoly(poly2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMultiplyPolyWithBothArraysAsEmpty()
    {
        int[] inputArray1 = {};
        Poly poly1 = new Poly(inputArray1);
        
        int[] inputArray2 = {};
        Poly poly2 = new Poly(inputArray2);
        
        poly1.multiplyPoly(poly2);
    }
}
