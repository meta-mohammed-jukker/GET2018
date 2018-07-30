package session8;

public enum AnimalFamily
{
    LION(1), CROCODILE(2), PEACOCK(3);
    
    private int animalNumber;
    
    /**
     * Sets animalNumber for each value
     * @param animalNumber
     */
    private AnimalFamily(int animalNumber)
    {
        this.animalNumber = animalNumber;
    }
    
    /**
     * Returns animalNumber
     * @return animalNumber
     */
    public int getAnimalNumber()
    {
        return animalNumber;
    }
}
