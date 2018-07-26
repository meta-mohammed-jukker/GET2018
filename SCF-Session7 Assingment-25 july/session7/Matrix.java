package session7;

public final class Matrix
{
    private int[][] matrix;
    private int rows;
    private int columns;
    
    /**
     * Converts Matrix in presentable format into stored format(value, row, column)
     * @param inputMatrix matrix in presentable format
     * @return matrix in stored format
     * @throws AssertionError
     */
    int[][] convertMatrix(int[][] inputMatrix) throws AssertionError
    {
        //Complexity: O(n^2)
        if(inputMatrix.length == 0)
        {
            throw new AssertionError("Empty Matrix");
        }
        int[][] nonZeroMatrix;
        int nonZeroValuesCounter = 0;
        for(int i=0; i<inputMatrix.length; i++)
        {
            for(int j=0; j<inputMatrix[i].length; j++)
            {
                if(inputMatrix[i][j] != 0)
                {
                    nonZeroValuesCounter++;
                }
            }
        }
        nonZeroMatrix = new int[nonZeroValuesCounter][3];
        nonZeroValuesCounter = 0;
        for(int i=0; i<inputMatrix.length; i++)
        {
            for(int j=0; j<inputMatrix[i].length; j++)
            {
                if(inputMatrix[i][j] != 0)
                {
                    nonZeroMatrix[nonZeroValuesCounter][0] = inputMatrix[i][j];
                    nonZeroMatrix[nonZeroValuesCounter][1] = i;
                    nonZeroMatrix[nonZeroValuesCounter][2] = j;
                    nonZeroValuesCounter++;
                }
            }
        }
        return nonZeroMatrix;
    }
    
    /**
     * Checks if value array is present in inputMatrix
     * @param inputMatrix 2D Matrix
     * @param value Array of integers
     * @return true if value is present else false
     */
    boolean isPresent(int[][] inputMatrix, int[] value)
    {
        //Complexity: O(n)
        for(int i=0; i<inputMatrix.length; i++)
        {
            if(inputMatrix[i][0] == value[0] 
                    && inputMatrix[i][1] == value[1] 
                            && inputMatrix[i][2] == value[2])
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Initializes matrix, rows and columns
     * @param inputMatrix matrix in presentable format
     */
    Matrix(int[][] inputMatrix)
    {
        rows = inputMatrix.length;
        columns = inputMatrix[0].length;
        this.matrix = convertMatrix(inputMatrix);
    }
    
    /**
     * Returns transpose of matrix
     * @return transposed matrix
     */
    int[][] getTranpose()
    {
        //Complexity: O(n)
        int[][] transposeMatrix = new int[this.matrix.length][3];
        //swaps entry field for each row to its corresponding column
        for(int i=0; i<this.matrix.length; i++)
        {
            transposeMatrix[i][0] = this.matrix[i][0];
            transposeMatrix[i][1] = this.matrix[i][2];
            transposeMatrix[i][2] = this.matrix[i][1];
        }
        return transposeMatrix;
    }
    
    /**
     * Adds 2 matrices
     * @param matrix second matrix
     * @return sum of 2 matrices
     * @throws AssertionError
     */
    int[][] addMatrix(Matrix matrix) throws AssertionError
    {
        //Complexity: O(n^2)
        if(this.rows != matrix.rows || this.columns != matrix.columns)
        {
            throw new AssertionError("Matrix Dimensions don't match");
        }
        
        int[][] sumMatrix = new int[rows][columns];
        
        // adds all elements of first matrix into sum matrix
        for(int i=0; i<this.matrix.length; i++)
        {
            sumMatrix[this.matrix[i][1]][this.matrix[i][2]] = this.matrix[i][0];
        }
        
        //adds all elements of second matrix into sum matrix
        for(int i=0; i<matrix.matrix.length; i++)
        {
            sumMatrix[matrix.matrix[i][1]][matrix.matrix[i][2]] += matrix.matrix[i][0];
        }
        return convertMatrix(sumMatrix);
    }
    
    /**
     * Checks if matrix is symmetric or not
     * @return true if matrix is symmetric else false
     * @throws AssertionError
     */
    boolean isSymmetric() throws AssertionError
    {
        //Complexity: O(n^2)
        if(rows != columns)
        {
            throw new AssertionError("Matrix should be square matrix");
        }
        int[][] transposedMatrix = getTranpose();
        for(int i=0; i<matrix.length; i++)
        {
            if(! isPresent(transposedMatrix, matrix[i]))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Multiplies 2 matrices
     * @param matrix second matrix object
     * @return product of 2 matrices
     * @throws AssertionError
     */
    int[][] multiplyMatrix(Matrix matrix) throws AssertionError
    {
        //Complexity: O(n^2)
        //checks if columns of matrix 1 is equal to rows of matrix 2
        if(this.columns != matrix.rows)
        {
            throw new AssertionError("Matrix multiplication not possible");
        }
        
        int[][] productMatrix = new int[this.rows][matrix.columns];
        
        for(int i=0; i<this.matrix.length; i++)
        {
            for(int j=0; j<matrix.matrix.length; j++)
            {
                //for column number of matrix 1 equal to row number of matrix 2
                if(this.matrix[i][2] == matrix.matrix[j][1])
                {
                    //productMatrix[matrix1.rowNumber][matrix2.columnNumber] += matrix1.value * matrix2.value
                    productMatrix[this.matrix[i][1]][matrix.matrix[j][2]] +=  
                            this.matrix[i][0] * matrix.matrix[j][0];
                }
            }
        }
        return convertMatrix(productMatrix);
    }
}
