package session8;

import java.util.*;

public class ZooManagement
{
    Scanner scan = new Scanner(System.in);
    ListOfEntities listOfEntities = new ListOfEntities();
    
    /**
     * Makes a new cage
     * @param cageType type of the cage
     * @param animalSpecies animal species that can be added to the cage
     * @return Cage object
     */
    Cage makeCage(String cageType, AnimalFamily animalSpecies)
    {
        System.out.println("Enter number of animals that new cage can fit: ");
        int numberOfAnimal = scan.nextInt();
        Cage newCage = new Cage(numberOfAnimal, cageType, animalSpecies);
        listOfEntities.addCage(newCage);
        return newCage;
    }
    
    /**
     * Returns value in AnimalFamily corresponding to the number 
     * @param animalNumber number corresponding to the value in AnimalFamily
     * @return AnimalFamily value
     */
    AnimalFamily getAnimalSpecies(int animalNumber)
    {
        AnimalFamily[] animalFamily = AnimalFamily.values();
        for(AnimalFamily animalSpecies: animalFamily)
        {
            if(animalSpecies.getAnimalNumber() == animalNumber)
            {
                return animalSpecies;
            }
        }
        return null;
    }
    
    /**
     * Selects animal species that is to be added 
     * @param animalSpecies AnimalFamily value
     */
    void addAnimal(AnimalFamily animalSpecies)
    {
        switch(animalSpecies)
        {
        case LION:
            addLion();
            break;
        case CROCODILE:
            addCrocodile();
            break;
        case PEACOCK:
            addPeacock();
            break;
        }
        
    }
    
    
    /**
     * Adds lion to the zone
     */
    void addLion()
    {
        System.out.println("Enter animal ID: ");
        int animalID = scan.nextInt();
        System.out.println("Enter animal name: ");
        String animalName = scan.next();
        System.out.println("Is native from: ");
        String nativeFrom = scan.next();
        
        Animal animal = new Lion(animalID, animalName, nativeFrom);
        
        if(putAnimal(animal))
        {
            System.out.println("Animal added");
        }
        else
        {
            System.out.println("Animal not added");
        }
        
        
    }
    
    /**
     * Adds crocodile to the zone
     */
    void addCrocodile()
    {
        System.out.println("Enter animal ID: ");
        int animalID = scan.nextInt();
        System.out.println("Enter animal name: ");
        String animalName = scan.next();
        System.out.println("Enter crocodile type: ");
        String crocodileType = scan.next();
        
        Animal animal = new Crocodile(animalID, animalName, crocodileType);
        
        if(putAnimal(animal))
        {
            System.out.println("Animal added");
        }
        else
        {
            System.out.println("Animal not added");
        }
    }
    
    /**
     * Adds peacock to the zone
     */
    void addPeacock()
    {
        System.out.println("Enter animal ID: ");
        int animalID = scan.nextInt();
        System.out.println("Enter animal name: ");
        String animalName = scan.next();
        System.out.println("Enter wing span: ");
        int wingSpan = scan.nextInt();
        System.out.println("Enter tail feather fan size(diameter): ");
        int tailFeatherFanSize = scan.nextInt();
        
        Animal animal = new Peacock(animalID, animalName, wingSpan, tailFeatherFanSize);
        
        if(putAnimal(animal))
        {
            System.out.println("Animal added");
        }
        else
        {
            System.out.println("Animal not added");
        }
    }
    
    /**
     * Puts animal to a particular cage in the zone of type same as animal
     */
    boolean putAnimal(Animal animal)
    {  
        //Traverses each zone
        for(Zone zone: listOfEntities.getZoneList())
        {
            //checks if zoneType is same as animalType
            if(zone.getZoneType().equals(animal.getAnimalType()));
            {
                //checks if zone is empty
                if(zone.isZoneEmpty())
                {
                    //adds cage for that animal in the zone
                    Cage cage = makeCage(animal.getAnimalType(), animal.getAnimalSpecies());
                    cage.addAnimal(animal);
                    zone.addCage(cage);
                    listOfEntities.addAnimal(animal);
                    return true;
                }
                
                Cage currentCage = zone.getLastCageAdded();
                //checks if zone is full
                if(zone.isZoneFull(currentCage))
                {
                    //traverses to all the unfilled cages in the zone
                    for(Cage unfilledCage: zone.cageNotFilled())
                    {
                        currentCage = unfilledCage;
                        // checks if animals in the cage are of same species 
                        // as that of the animal that is to be added 
                        if(currentCage.getAnimalSpecies() == animal.getAnimalSpecies())
                        {
                            currentCage.addAnimal(animal);
                            listOfEntities.addAnimal(animal);
                            return true;
                        }
                    }
                }
                //checks if last added cage has space for animal of that species
                if(currentCage.isAddAnimalPossible() && 
                        currentCage.getAnimalSpecies() == animal.getAnimalSpecies())
                {
                    currentCage.addAnimal(animal);
                    listOfEntities.addAnimal(animal);
                    return true;
                }
                else
                {
                    // if none of above conditions apply, 
                    // then make new cage and add animal to that cage
                    Cage newCage = makeCage(animal.getAnimalType(), animal.getAnimalSpecies());
                    newCage.addAnimal(animal);
                    zone.addCage(newCage);
                    listOfEntities.addAnimal(animal);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Removes an animal 
     * @param animalID animal ID of the animal that is to be removed
     * @return true if animal removed, else false
     */
    boolean removeAnimal(int animalID)
    {
        //checks for the animal in each cage of each zone, until the animal is found
        // and the animal is removed
        for(Zone eachZone: listOfEntities.getZoneList())
        {
            for(Cage eachCage: eachZone.getCageList())
            {
                for(Animal eachAnimal: eachCage.getAnimalList())
                {
                    if(animalID == eachAnimal.getAnimalID())
                    {
                        eachCage.removeAnimal(eachAnimal);
                        listOfEntities.removeAnimal(eachAnimal);
                        eachAnimal = null;
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Adds zone to the zoo
     * @param numberOfCages number of cages that can be addded to the zone
     * @param zoneType type of the zone
     * @param hasPark true if zone has park, else false
     * @param hasCanteen true if zone has canteen, else false
     * @return
     */
    boolean addZone(int numberOfCages, String zoneType, boolean hasPark, boolean hasCanteen)
    {
        Zone newZone = new Zone(numberOfCages, zoneType, hasPark, hasCanteen);
        listOfEntities.addZone(newZone);
        return true;
    }
}
