package session5;

public class MathematicalOperation
{
    /**
     * Calculates the HCF between 2 positive integer numbers
     * @param firstNumber first number
     * @param secondNumber second number
     * @return HCF of 2 numbers
     */
    public int computeHCF(int firstNumber, int secondNumber)
    {
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        if(firstNumber==0)
        {
            return secondNumber;
        }
        else
        {
            return computeHCF(secondNumber%firstNumber,firstNumber);
        }
    }
    
    /**
     * Calculates the Lowest Common Multiple of 2 positive integer numbers
     * @param firstNumber first Number
     * @param secondNumber second Number
     * @return LCM of 2 numbers
     */
    public int computeLCM(int firstNumber, int secondNumber)
    {
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        return (firstNumber*secondNumber)/computeHCF(firstNumber, secondNumber);
    }
}
