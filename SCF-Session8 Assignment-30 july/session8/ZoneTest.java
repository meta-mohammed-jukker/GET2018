package session8;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZoneTest
{
    Zone zone = new Zone(1, "BIRD", true, false);
    Cage cage = new Cage(5, "BIRD", AnimalFamily.PEACOCK);

    @Test
    public void testGetZoneType()
    {
       String expectedOutput = "BIRD"; 
       String actualOutput = zone.getZoneType();
       assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsZoneEmpty()
    {
       boolean expectedOutput = true; 
       boolean actualOutput = zone.isZoneEmpty();
       assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsZoneFull()
    {
       boolean expectedOutput = false; 
       boolean actualOutput = zone.isZoneFull(cage);
       assertEquals(expectedOutput, actualOutput);
    }

}
