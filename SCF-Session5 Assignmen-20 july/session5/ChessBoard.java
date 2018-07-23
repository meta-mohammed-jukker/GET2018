package session5;

public class ChessBoard
{    
    /**
     * Checks if queen can be placed on board[row][column]
     * @param board a 2D square matrix
     * @param row row index on which queen is to be placed 
     * @param column column index on which queen is to be placed
     * @param dimensionOfMatrix dimension of square matrix
     * @return true if queen can be placed at position [row][column] else false
     */
    public boolean isSafe(int[][] board, int row, int column, int dimensionOfMatrix)
    {
        int i, j;
        
        for (i = 0; i < row; i++)
        {
            if (board[i][column] == 1)
            {
                return false;
            }
        }
        
        for (i=row, j=column; i>=0 && j>=0; i--, j--)
        {
            if (board[i][j] == 1)
            {
                return false;
            }
        }
        
        for (i=row, j=column; i>=0 && j<dimensionOfMatrix; i--, j++)
        {
            if (board[i][j] == 1)
            {
                return false;
            }
        }
            
        return true;
    }
    
    /**
     * Modifies the board matrix such that N number of queens can places on a board of NxN 
     * such that no 2 queens can attack each other.
     * @param board a 2D square matrix
     * @param row row in which queen is to be placed
     * @param dimensionOfMatrix dimension of square matrix
     * @return modifies board matrix according to above mention condition else returns false
     */
    public boolean nQueen(int[][] board, int row, int dimensionOfMatrix)
    {
        if (row >= dimensionOfMatrix)
        {
            return true;
        }
        
        for (int i = 0; i < dimensionOfMatrix; i++)
        {
            if (isSafe(board, row, i, dimensionOfMatrix))
            {
                board[row][i] = 1;

                if (nQueen(board, row + 1, dimensionOfMatrix) == true)
                {
                    return true;
                }
                board[row][i] = 0;
            }
        }
        return false;
    }
    
    /**
     * Returns board matrix after all queens are placed
     * @param dimensionOfMatrix dimension of grade matrix
     * @return board matrix after all queens are placed
     */
    public int[][] displayNQueen(int dimensionOfMatrix) throws IllegalArgumentException
    {
        int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
        

        if (nQueen(board, 0, dimensionOfMatrix) == false)
        {
            throw new IllegalArgumentException("Solution does not exist");
        }
        return board;
    }
}