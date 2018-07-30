package session8;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZooManagementTest
{
    ZooManagement zooManagement = new ZooManagement();
    Animal lion = new Lion(1, "Shera", "India");
    Animal peacock = new Peacock(2, "Pea", 12, 23);
    Animal crocodile = new Crocodile(3, "Croc", "Caiman");

    @Test
    public void testPutAniamlWithLion()
    {
        boolean expectedOutput = true;
        boolean actualOutput = zooManagement.putAnimal(lion);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testPutAniamlWithPeacock()
    {
        boolean expectedOutput = true;
        boolean actualOutput = zooManagement.putAnimal(peacock);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testPutAniamlWithCrocodile()
    {
        boolean expectedOutput = true;
        boolean actualOutput = zooManagement.putAnimal(crocodile);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testRemoveAniamlWithLion()
    {
        zooManagement.putAnimal(lion);
        boolean expectedOutput = true;
        boolean actualOutput = zooManagement.removeAnimal(1);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testRemoveAniamlWithAnimalIDNotPresent()
    {
        boolean expectedOutput = false;
        boolean actualOutput = zooManagement.removeAnimal(4);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testAddZone()
    {
        boolean expectedOutput = true;
        boolean actualOutput = zooManagement.addZone(3, "BIRD", true, false);
        assertEquals(expectedOutput, actualOutput);
    }
}
