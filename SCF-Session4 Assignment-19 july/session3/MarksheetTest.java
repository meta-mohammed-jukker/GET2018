package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarksheetTest
{
    Marksheet marksheet = new Marksheet();
    
    //Tests calculateAverageGrade()
    @Test
    public void testcalculateAverageGrade()
    {
        float[] grades = {(float)12.5, (float)23.54, 40, (float)97.89};
        assertEquals(43.4825, marksheet.calculateAverageGrade(grades), 0.01);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testcalculateAverageGradeWithEmptyArray()
    {
        float[] grades = {};
        marksheet.calculateAverageGrade(grades);
    }
    
    
    //Tests findMaximumGrade()
    @Test
    public void testFindMaximumGrade()
    {
        float[] grades = {(float)12.5, (float)23.54, 40, (float)97.89};
        assertEquals(97.89, marksheet.findMaximumGrade(grades), 0.01);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testFindMaximumGradeWithEmptyArray()
    {
        float[] grades = {};
        marksheet.findMaximumGrade(grades);
    }
    
    
    //Tests findMaximumGrade()
    @Test
    public void testFindMinimumGrade()
    {
        float[] grades = {(float)12.5, (float)23.54, 40, (float)97.89};
        assertEquals(12.5, marksheet.findMinimumGrade(grades), 0.01);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testFindMinimumGradeWithEmptyArray()
    {
        float[] grades = {};
        marksheet.findMinimumGrade(grades);
    }
    
  //Tests findPercentagePassed()
    @Test
    public void testFindPercentagePassed()
    {
        float[] grades = {(float)12.5, (float)23.54, 40, (float)97.89};
        assertEquals(50.0, marksheet.findPercentagePassed(grades), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testFindPercentagePassedWithEmptyArray()
    {
        float[] grades = {};
        marksheet.findPercentagePassed(grades);
    }
}
