package session7;

import static org.junit.Assert.*;

import javax.accessibility.AccessibleStateSet;

import org.junit.Test;

public class MatrixTest
{
    //Test cases for getTranspose()
    @Test
    public void testGetTranspose()
    {
        int[][] inputMatrix = {{1, 0, 0},
                               {2, 0, 0}};
        Matrix matrix = new Matrix(inputMatrix);
        
        int[][] expectedOutputMatrix = {{1, 0, 0},
                                        {2, 0, 1}};
        
        int[][] actualOutput = matrix.getTranpose();
        assertArrayEquals(expectedOutputMatrix, actualOutput);
        
    }
    
    @Test(expected = AssertionError.class)
    public void testGetTransposeWithEmptyMatrix()
    {
        int[][] inputMatrix = {{}};
        Matrix matrix = new Matrix(inputMatrix);
        
        int[][] expectedOutputMatrix = {{1, 0, 0},
                                        {2, 0, 1}};
        
        int[][] actualOutput = matrix.getTranpose();
        assertArrayEquals(expectedOutputMatrix, actualOutput);
        
    }
    
    
    //Test cases for addMatrix()
    @Test
    public void testAddMatrix()
    {
        int[][] inputMatrix1 = {{1, 0, 0},
                               {2, 0, 0}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{1, 4, 0},
                                {2, 0, 6}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        int[][] expectedOutputMatrix = {{2, 0, 0},
                                        {4, 0, 1},
                                        {4, 1, 0},
                                        {6, 1, 2}};
        int[][] actualOutput = matrix1.addMatrix(matrix2);
        assertArrayEquals(expectedOutputMatrix, actualOutput);
        
    }
    
    @Test(expected = AssertionError.class)
    public void testAddMatrixWithDifferentDimensions()
    {
        int[][] inputMatrix1 = {{1, 0, 0},
                               {2, 0, 0}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{1, 4, 0}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        matrix1.addMatrix(matrix2);
    }
    
    @Test(expected = AssertionError.class)
    public void testAddMatrixWithEmptyFirstMatrix()
    {
        int[][] inputMatrix1 = {{}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{1, 4, 0}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        matrix1.addMatrix(matrix2);
    }
    
    @Test(expected = AssertionError.class)
    public void testAddMatrixWithEmptySecondArray()
    {
        int[][] inputMatrix1 = {{1, 0, 0},
                               {2, 0, 0}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        matrix1.addMatrix(matrix2);
    }
    
    //Test cases for isSymmetric()
    @Test
    public void testIsSymmetricWithSymmetricMatrix()
    {
        int[][] inputMatrix = {{1, 0, 0},
                                {0, 0, 3},
                                {0, 3, 0}};
        Matrix matrix = new Matrix(inputMatrix);
        
        boolean expectedOutput = true;
        boolean actualOutput = matrix.isSymmetric();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSymmetricWithNonSymmetricMatrix1()
    {
        int[][] inputMatrix = {{1, 0, 0},
                                {0, 0, 3},
                                {0, 5, 0}};
        Matrix matrix = new Matrix(inputMatrix);
        
        boolean expectedOutput = false;
        boolean actualOutput = matrix.isSymmetric();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSymmetricWithNonSymmetricMatrix2()
    {
        int[][] inputMatrix = {{1, 0, 0},
                                {0, 0, 3},
                                {0, 0, 0}};
        Matrix matrix = new Matrix(inputMatrix);
        
        boolean expectedOutput = false;
        boolean actualOutput = matrix.isSymmetric();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = AssertionError.class)
    public void testIsSymmetricWithDifferentDimensions()
    {
        int[][] inputMatrix = {{1, 0, 0},
                               {2, 0, 0}};
        Matrix matrix = new Matrix(inputMatrix);
        
        matrix.isSymmetric();
    }
    
    //Test cases for multiplyMatrix()
    @Test
    public void testmultiplyMatrix()
    {
        int[][] inputMatrix1 = {{1, 2, 1},
                               {3, 0, 1}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{3, 1},
                                {1, 0},
                                {3 ,0}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        int[][] expectedOutputMatrix = {{8, 0, 0},
                                        {1, 0, 1},
                                        {12, 1, 0},
                                        {3, 1, 1}};
        int[][] actualOutput = matrix1.multiplyMatrix(matrix2);
        assertArrayEquals(expectedOutputMatrix, actualOutput); 
    }
    
    @Test(expected = AssertionError.class)
    public void testMultiplyMatrixWithMatrix1ColumnsNotEqualToMatrix2Rows()
    {
        int[][] inputMatrix1 = {{1, 0, 0},
                               {2, 0, 0}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{1, 4, 0}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        matrix1.multiplyMatrix(matrix2);
    }
    
    @Test(expected = AssertionError.class)
    public void testMultiplyMatrixWithEmptyFirstMatrix()
    {
        int[][] inputMatrix1 = {{}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{1, 4, 0}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        matrix1.multiplyMatrix(matrix2);
    }
    
    @Test(expected = AssertionError.class)
    public void testMultiplyMatrixWithEmptySecondArray()
    {
        int[][] inputMatrix1 = {{1, 0, 0},
                               {2, 0, 0}};
        Matrix matrix1 = new Matrix(inputMatrix1);
        
        int[][] inputMatrix2 = {{}};
        Matrix matrix2 = new Matrix(inputMatrix2);
        
        matrix1.multiplyMatrix(matrix2);
    }

}
