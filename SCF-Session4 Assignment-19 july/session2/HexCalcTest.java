package session2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HexCalcTest
{
    String number1;
    String number2;
    String addResult;
    String subtractResult;
    String multiplyResult;
    String divideResult;
    
    HexCalc hexCalc = new HexCalc();
    
    @Parameters
    public static Collection data()
    {
        return Arrays.asList( new Object[ ][ ]
                {{"a", "5", "F", "5", "32", "2"},
                 {"Cd", "c", "D9", "C1", "99C", "11"},
                 {"f000", "00F", "F00F", "EFF1", "E1000", "1000"}});
    }
    
    public HexCalcTest
    (String number1, String number2, 
     String addResult, String subtractResult, String multiplyResult, String divideResult)
    {
        this.number1 = number1;
        this.number2 = number2;
        this.addResult = addResult;
        this.subtractResult = subtractResult;
        this.multiplyResult = multiplyResult;
        this.divideResult = divideResult;
    }

    
    @Test
    public void testAdd()
    {
        assertEquals(addResult, hexCalc.add(number1,number2));
    }
    
    
    @Test
    public void testSubtract()
    {
        assertEquals(subtractResult, hexCalc.subtract(number1,number2));
    }
    
    
    @Test
    public void testMultiply()
    {
        assertEquals(multiplyResult, hexCalc.multiply(number1,number2));
    }
    
    
    @Test
    public void testDivide()
    {
        assertEquals(divideResult, hexCalc.divide(number1,number2));
    }
    
    
    @Test
    public void testEqualToWithPositiveTestCase()
    {
        assertEquals(true, hexCalc.equalTo("000a", "A"));
    }
    
    @Test
    public void testEqualToWithNegetiveTestCase()
    {
        assertEquals(false, hexCalc.equalTo("0DA1", "ACD"));
    }
    
    
    @Test
    public void testGreaterThanWithPositiveTestCase()
    {
        assertEquals(true, hexCalc.greaterThan("F", "A"));
    }
    
    @Test
    public void testGreaterThanWithEqualArguments()
    {
        assertEquals(false, hexCalc.greaterThan("1", "1"));
    }
    
    @Test
    public void testGreaterThanWithNumber1LessThanNumber2()
    {
        assertEquals(false, hexCalc.greaterThan("1", "2"));
    }
    
    
    @Test
    public void testLessThanWithPositiveTestCase()
    {
        assertEquals(true, hexCalc.lessThan("1", "2"));
    }
    
    @Test
    public void testLessThanWithEqualArguments()
    {
        assertEquals(false, hexCalc.lessThan("1", "1"));
    }
    
    @Test
    public void testLessThanWithNumber1GreaterThanNumber2()
    {
        assertEquals(false, hexCalc.lessThan("F", "A"));
    }
    
    
    @Test
    public void testHexStringToDecimal()
    {
        assertEquals(241, hexCalc.hexStringToDecimal("00F1"), 0);
    }
    
    
    @Test
    public void testDecimalToHexString()
    {
        assertEquals("F1", hexCalc.decimalToHexString((long)241));
    }
}
