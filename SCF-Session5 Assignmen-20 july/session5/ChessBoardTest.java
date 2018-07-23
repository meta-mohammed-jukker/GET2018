package session5;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessBoardTest
{
    ChessBoard chessBoard = new ChessBoard();

    @Test (expected = IllegalArgumentException.class)
    public void testDisplayNQueenWith3Queens()
    {
        int expectedDimensionOfBoard = 3;
        chessBoard.displayNQueen(expectedDimensionOfBoard);
    }
    
    @Test
    public void testDisplayNQueenWith4Queens()
    {
        int expectedDimensionOfBoard = 4;
        int[][] expectedOutputBoard = {{0, 1, 0, 0},
                         {0, 0, 0, 1},
                         {1, 0, 0, 0},
                         {0, 0, 1, 0}};
        assertArrayEquals(expectedOutputBoard, chessBoard.displayNQueen(expectedDimensionOfBoard));
    }

}
