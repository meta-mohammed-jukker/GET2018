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
        float[] expectedInputGrades = {(float)12.5, (float)23.54, 40, (float)97.89};
        float expectedOutput = (float)43.4825;
        assertEquals(expectedOutput, marksheet.calculateAverageGrade(expectedInputGrades), 0.01);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testcalculateAverageGradeWithEmptyArray()
    {
        float[] expectedInputGrades = {};
        marksheet.calculateAverageGrade(expectedInputGrades);
    }
    
    
    //Tests findMaximumGrade()
    @Test
    public void testFindMaximumGrade()
    {
        float[] expectedInputGrades = {(float)12.5, (float)23.54, 40, (float)97.89};
        float expectedOutput = (float)97.89;
        assertEquals(expectedOutput, marksheet.findMaximumGrade(expectedInputGrades), 0.01);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testFindMaximumGradeWithEmptyArray()
    {
        float[] expectedInputGrades = {};
        marksheet.findMaximumGrade(expectedInputGrades);
    }
    
    
    //Tests findMaximumGrade()
    @Test
    public void testFindMinimumGrade()
    {
        float[] expectedInputGrades = {(float)12.5, (float)23.54, 40, (float)97.89};
        float expectedOutput = (float)12.5;
        assertEquals(expectedOutput, marksheet.findMinimumGrade(expectedInputGrades), 0.01);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testFindMinimumGradeWithEmptyArray()
    {
        float[] expectedInputGrades = {};
        marksheet.findMinimumGrade(expectedInputGrades);
    }
    
  //Tests findPercentagePassed()
    @Test
    public void testFindPercentagePassed()
    {
        float[] expectedInputGrades = {(float)12.5, (float)23.54, 40, (float)97.89};
        float expectedOutput = (float)50.0;
        assertEquals(expectedOutput, marksheet.findPercentagePassed(expectedInputGrades), 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testFindPercentagePassedWithEmptyArray()
    {
        float[] expectedInputGrades = {};
        marksheet.findPercentagePassed(expectedInputGrades);
    }
}
