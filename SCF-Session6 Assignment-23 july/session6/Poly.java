package session6;

public final class Poly
{
    private int[][] polynomialArray;
    
    /** Converts 1D Array to 2D Array of coefficient and exponent
     * @param inputArray 1D Array with coefficient stored at index equal to exponent
     * @return 2D Array with coefficient, exponent without any coefficient value as zero
     */
    private int[][] convertArray(int[] inputArray)
    {
        int polynomialSize = 0;
        for(int value: inputArray)
        {
            if(value != 0)
            {
                polynomialSize += 1;
            }
        }
        int[][] polyArray = new int[polynomialSize][2];
        int polynomialArrayCounter = 0;
        for(int i=0; i<inputArray.length; i++)
        {
            if(inputArray[i] != 0)
            {
                polyArray[polynomialArrayCounter][0] = inputArray[i];
                polyArray[polynomialArrayCounter][1] = i;
                polynomialArrayCounter++;
            }
        }
        return polyArray;
    }
    
    /**
     * Initializes polynomialArray
     * @param inputArray
     */
    Poly(int[] inputArray)
    {
        this.polynomialArray = convertArray(inputArray); 
    }
    
    /**
     * Returns 2D Polynomial array with coefficients and exponents
     * @return 2D Polynomial array
     */
    int[][] getPolynomialArray()
    {
        return this.polynomialArray;
    }
    
    /**
     * Evaluates the polynomial expression with input values
     * @param variable value that is to be inserted into the polynomial expression
     * @return value of polynomial expression
     */
    float evaluate(int variable)
    {
        float polynomialValue = 0;
        for(int i=0; i<this.polynomialArray.length; i++)
        {
            polynomialValue += this.polynomialArray[i][0] * 
                    Math.pow(variable, this.polynomialArray[i][1]);
        }
        return polynomialValue;
    }
    
    /**
     * Returns highest value of exponent in the expression
     * @return highest exponent value
     */
    int degree() throws IndexOutOfBoundsException
    {
        if(this.polynomialArray.length == 0)
        {
            throw new IndexOutOfBoundsException();
        }
        return this.polynomialArray[this.polynomialArray.length - 1][1];
    }
    
    /**
     * Adds 2 polynomial expressions
     * @param poly Poly object for second polynomial expression
     * @return sum of 2 polynomial expressions
     */
    Poly addPoly(Poly poly)
    {
        int[] temporaryOutputArray;
        if(degree() >= poly.degree() )
        {
            temporaryOutputArray = new int[degree() + 1];
        }
        else
        {
            temporaryOutputArray = new int[poly.degree() + 1];
        }
        for(int i=0; i<this.polynomialArray.length; i++)
        {
            temporaryOutputArray[this.polynomialArray[i][1]] = this.polynomialArray[i][0];
        }
        
        for(int i=0; i<poly.polynomialArray.length; i++)
        {
            temporaryOutputArray[poly.polynomialArray[i][1]] += poly.polynomialArray[i][0];
        }
        return new Poly(temporaryOutputArray);
    }
    
    /**
     * Multiplies 2 polynomial expressions
     * @param poly Poly object for second polynomial expression
     * @return product of 2 polynomial expressions
     */
    Poly multiplyPoly(Poly poly)
    {
        int[]  temporaryOutputArray = new int[degree() + poly.degree() + 1];
        for(int i=0; i<this.polynomialArray.length; i++)
        {
            for(int j=0; j<poly.polynomialArray.length; j++)
            {
                temporaryOutputArray[this.polynomialArray[i][1] + poly.polynomialArray[j][1]] += 
                        this.polynomialArray[i][0] * poly.polynomialArray[j][0];
            }
        }
        return  new Poly(temporaryOutputArray);
    }
}
