package session8;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrocodileTest
{

    @Test
    public void testGetInfo()
    {
        Animal animal = new Crocodile(1, "Croc", "Caiman");
        String expectedOutput = "Animal ID: " + 1 +
                "\nAnimal Name: " + "Croc" +
                "\nAnimal Type: " + "REPTILE" +
                "\nIs animal poisonous: " + false +
                "\nCrocodile Type: " + "Caiman" +
                "\nAnimal species: " + AnimalFamily.CROCODILE; 
        
        String actualOutput = animal.getInfo();
        assertEquals(expectedOutput, actualOutput);
    }

}
