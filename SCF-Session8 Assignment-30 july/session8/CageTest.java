package session8;

import static org.junit.Assert.*;

import org.junit.Test;

public class CageTest
{
    
    Cage cage = new Cage(5, "MAMMAL", AnimalFamily.LION);

    @Test
    public void testGetCageType()
    {
        String expectedOutput = "MAMMAL";
        String actualOutput = cage.getCageType();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsAddAnimalPossible()
    {
        boolean expectedOutput = true;
        boolean actualOutput = cage.isAddAnimalPossible();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetAnimalSpecies()
    {
        AnimalFamily expectedOutput = AnimalFamily.LION;
        AnimalFamily actualOutput = cage.getAnimalSpecies();
        assertEquals(expectedOutput, actualOutput);
    }

}
