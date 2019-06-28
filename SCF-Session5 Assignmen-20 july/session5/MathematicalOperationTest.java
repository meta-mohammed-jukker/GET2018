package session5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class MathematicalOperationTest
{
    int expectedHCF;
    int expectedLCM;
    int firstNumber;
    int secondNumber;
    
    @Parameters
    public static Collection data()
    {
        return Arrays.asList( new Object[ ][ ]
                {{1, 414, 23, 18},
                 {20, 200, 100, 40},
                 {2, 2, 2, 2},
                 {4, 8, -4, 8},
                 {5, 15, 15, -5},
                 {4, 0, 4, 0}});
    }
    
    public MathematicalOperationTest
    (int expectedHCF, int  expectedLCM, int  firstNumber, int  secondNumber)
    {
        this.expectedHCF = expectedHCF;
        this.expectedLCM = expectedLCM;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    
    @Test
    public void testComputeHCF()
    {
        assertEquals(expectedHCF,
                new MathematicalOperation().computeHCF(firstNumber, secondNumber));
    }
    
    @Test
    public void testComputeLCM()
    {
        assertEquals(expectedLCM,
                new MathematicalOperation().computeLCM(firstNumber, secondNumber));
    }

}
