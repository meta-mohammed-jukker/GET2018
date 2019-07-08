package session8;

import java.util.ArrayList;
import java.util.List;

public class ListOfEntities
{
    List<Zone> zoneList;
    List<Cage> cageList;
    List<Animal> animalList;
    
    /**
     * Initializes ListOfEntities
     * And initially set zones 
     */
    ListOfEntities()
    {
        zoneList = new ArrayList<Zone>();
        cageList = new ArrayList<Cage>();
        animalList = new ArrayList<Animal>();
        Zone mammal1 = new Zone(5, "MAMMAL", true, false);
        zoneList.add(mammal1);
        Zone mammal2 = new Zone(3, "MAMMAL", false, true);
        zoneList.add(mammal2);
        Zone reptile1 = new Zone(1, "REPTILE", true, true);
        zoneList.add(reptile1);
        Zone reptile2 = new Zone(6, "REPTILE", false, false);
        zoneList.add(reptile2);
        Zone bird1 = new Zone(12, "BIRD", true, false);
        zoneList.add(bird1);
        Zone bird2 = new Zone(10, "BIRD", true, false);
        zoneList.add(bird2);
    }
    
    /**
     * Returns list of zones
     * @return list of zones
     */
    List<Zone> getZoneList()
    {
        return zoneList;
    }
    
    /**
     * Adds cage to list of cage
     * @param newCage Cage object
     */
    void addCage(Cage newCage)
    {
        cageList.add(newCage);
    }
    
    /**
     * Adds animal to list of Animals
     * @param newAnimal Animal object
     */
    void addAnimal(Animal newAnimal)
    {
        animalList.add(newAnimal);
    }
    
    /**
     * Removes animal from list of Animals
     * @param animal Animal object
     */
    void removeAnimal(Animal animal)
    {
        animalList.remove(animal);
    }
    
    /**
     * Adds zones to list of zones
     * @param newZone Zone object
     */
    void addZone(Zone newZone)
    {
        zoneList.add(newZone);
    }
    
}
