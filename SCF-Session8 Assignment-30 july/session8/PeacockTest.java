package session8;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeacockTest
{
    @Test
    public void testGetInfo()
    {
        Animal animal = new Peacock(1, "Pea", 12, 23);
        String expectedOutput = "Animal ID: " + 1 +
                "\nAnimal Name: " + "Pea" +
                "\nAnimal Type: " + "BIRD" +
                "\nWing Span: " + 12 +
                "\nCan Fly: " + false +
                "\nTail feather fan size(diameter): " + 23 +
                "\nAnimal species: " + AnimalFamily.PEACOCK;
        
        String actualOutput = animal.getInfo();
        assertEquals(expectedOutput, actualOutput);
    }
}
