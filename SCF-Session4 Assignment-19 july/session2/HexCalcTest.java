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
        boolean expectedOutput = true;
        String expectedNumber1 = "000a";
        String expectedNumber2 = "A";
        assertEquals(expectedOutput, hexCalc.equalTo(expectedNumber1,expectedNumber2));
    }
    
    @Test
    public void testEqualToWithNegetiveTestCase()
    {
        boolean expectedOutput = false;
        String expectedNumber1 = "0DA1";
        String expectedNumber2 = "ACD";
        assertEquals(expectedOutput, hexCalc.equalTo(expectedNumber1,expectedNumber2));
    }
    
    
    @Test
    public void testGreaterThanWithPositiveTestCase()
    {
        boolean expectedOutput = true;
        String expectedNumber1 = "f";
        String expectedNumber2 = "A";
        assertEquals(expectedOutput, hexCalc.greaterThan(expectedNumber1,expectedNumber2));
    }
    
    @Test
    public void testGreaterThanWithEqualArguments()
    {
        boolean expectedOutput = false;
        String expectedNumber1 = "1";
        String expectedNumber2 = "1";
        assertEquals(expectedOutput, hexCalc.greaterThan(expectedNumber1,expectedNumber2));
    }
    
    @Test
    public void testGreaterThanWithNumber1LessThanNumber2()
    {
        boolean expectedOutput = false;
        String expectedNumber1 = "1";
        String expectedNumber2 = "2";
        assertEquals(expectedOutput, hexCalc.greaterThan(expectedNumber1,expectedNumber2));
    }
    
    
    @Test
    public void testLessThanWithPositiveTestCase()
    {
        boolean expectedOutput = true;
        String expectedNumber1 = "1";
        String expectedNumber2 = "2";
        assertEquals(expectedOutput, hexCalc.lessThan(expectedNumber1,expectedNumber2));
    }
    
    @Test
    public void testLessThanWithEqualArguments()
    {
        boolean expectedOutput = false;
        String expectedNumber1 = "1";
        String expectedNumber2 = "1";
        assertEquals(expectedOutput, hexCalc.lessThan(expectedNumber1,expectedNumber2));
    }
    
    @Test
    public void testLessThanWithNumber1GreaterThanNumber2()
    {
        boolean expectedOutput = false;
        String expectedNumber1 = "F";
        String expectedNumber2 = "A";
        assertEquals(expectedOutput, hexCalc.lessThan(expectedNumber1,expectedNumber2));
    }
    
    
    @Test
    public void testHexStringToDecimal()
    {
        String expectedHexadecimalString = "00F1";
        Long expectedOutput = new Long(241);
        assertEquals(expectedOutput, hexCalc.hexStringToDecimal(expectedHexadecimalString), 0);
    }
    
    
    @Test
    public void testDecimalToHexString()
    {
        Long expectedDecimalString = new Long(241);
        String expectedOutput = "F1";
        assertEquals(expectedOutput, hexCalc.decimalToHexString(expectedDecimalString));
    }
}
