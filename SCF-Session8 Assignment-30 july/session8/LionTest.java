package session8;

import static org.junit.Assert.*;

import org.junit.Test;

public class LionTest
{

    @Test
    public void testGetInfo()
    {
        Animal animal = new Lion(1, "Shera", "India");
        String expectedOutput = "Animal ID: " + 1 +
                "\nAnimal Name: " + "Shera" +
                "\nAnimal Type: " + "MAMMAL" +
                "\nDoes animal has furs: " + true +
                "\nNative from: " + "India" +
                "\nAnimal species: " + AnimalFamily.LION; 
        
        String actualOutput = animal.getInfo();
        assertEquals(expectedOutput, actualOutput);
    }

}
