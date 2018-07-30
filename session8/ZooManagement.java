package session8;

import java.util.*;

public class ZooManagement
{
    Scanner scan = new Scanner(System.in);
    ListOfEntities listOfEntities = new ListOfEntities();
    
    Cage makeCage(String cageType)
    {
        System.out.println("Enter number of animals that new cage can fit: ");
        int numberOfAnimal = scan.nextInt();
        Cage newCage = new Cage(numberOfAnimal, "MAMMAL");
        listOfEntities.addCage(newCage);
        return newCage;
    }
    
    void addAnimal(AnimalFamily animalSpecies)
    {
        //System.out.println("Enter the animal: ");
        //String animalSpecies = scan.next();
        switch(animalSpecies)
        {
        case LION:
        //case "lion":
            addLion();
            break;
        case CROCODILE:
        //case "crocodile":
            addCrocodile();
            break;
        case PEACOCK:
        //case "peacock":
            addPeacock();
            break;
        }
        
    }
    
    void putAnimal(Animal animal)
    {
        System.out.println("1");
        
        boolean isAnimalAdded = false;
        for(Zone zone: listOfEntities.getZoneList())
        {
            System.out.println("2");
            if(zone.getZoneType().equals("MAMMAL"));
            {
                System.out.println("3");
                if(zone.isZoneEmpty())
                {
                    System.out.println("4");
                    Cage cage = makeCage("MAMMAL");
                    cage.addAnimal(animal);
                    zone.addCage(cage);
                    System.out.println(animal.getAnimalName() + " added to zoo. ");
                    listOfEntities.addAnimal(animal);
                    isAnimalAdded = true;
                    return;
                }
                System.out.println("5");
                Cage currentCage = zone.getLastCageAdded();
                if(zone.isZoneFull(currentCage))
                {
                    System.out.println("23");
                    if(zone.cageNotFilled() == null)
                    {
                        break;
                    }
                    currentCage = zone.cageNotFilled();
                    currentCage.addAnimal(animal);
                    System.out.println(animal.getAnimalName() + " added to zoo. ");
                    listOfEntities.addAnimal(animal);
                    isAnimalAdded = true;
                    return;
                }
                System.out.println("6");
                if(currentCage.isAddAnimalPossible())
                {
                    System.out.println("7");
                    currentCage.addAnimal(animal);
                    System.out.println(animal.getAnimalName() + " added to zoo. ");
                    listOfEntities.addAnimal(animal);
                    isAnimalAdded = true;
                    return;
                }
                else
                {
                    System.out.println("8");
                    Cage newCage = makeCage("MAMMAL");
                    newCage.addAnimal(animal);
                    zone.addCage(newCage);
                    System.out.println(animal.getAnimalName() + " added to zoo. ");
                    listOfEntities.addAnimal(animal);
                    isAnimalAdded = true;
                    return;
                }
            }
        }
        
        if(!isAnimalAdded)
        {
            System.out.println(animal.getAnimalName() + " not added to zoo. ");
        }
    }
    
    void addLion()
    {
        System.out.println("Enter animal ID: ");
        int animalID = scan.nextInt();
        System.out.println("Enter animal name: ");
        String animalName = scan.next();
        System.out.println("Is native from: ");
        String nativeFrom = scan.next();
        
        Animal animal = new Lion(animalID, animalName, nativeFrom);
        
        putAnimal(animal);
        
    }
    
    
    void addCrocodile()
    {
        System.out.println("Enter animal ID: ");
        int animalID = scan.nextInt();
        System.out.println("Enter animal name: ");
        String animalName = scan.next();
        System.out.println("Enter crocodile type: ");
        String crocodileType = scan.next();
        
        Animal animal = new Crocodile(animalID, animalName, crocodileType);
        
        putAnimal(animal);
    }
    
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
        
        putAnimal(animal);
    }
    
    
    void removeAnimal()
    {
        System.out.println("Enter the animal ID: ");
        int animalID = scan.nextInt();
        
        boolean isAnimalRemoved = false;
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
                        System.out.println(eachAnimal.getAnimalName() + " removed from zoo. ");
                        eachAnimal = null;
                        isAnimalRemoved = true;
                        return;
                    }
                }
            }
        }
        
        if(!isAnimalRemoved)
        {
            System.out.println("No animal with ID = " + animalID + " present in zoo. ");
        }
        
    }
    
    void addZone(int numberOfCages, String zoneType, boolean hasPark, boolean hasCanteen)
    {
        Zone newZone = new Zone(numberOfCages, zoneType, hasPark, hasCanteen);
        listOfEntities.addZone(newZone);
    }
}
