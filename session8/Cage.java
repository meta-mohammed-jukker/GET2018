package session8;

import java.util.*;
public class Cage
{
    String cageType;
    int numberOfAnimal;
    int numberOfAnimalPresent;
    List<Animal> animalList;
    
    Cage(int numberOfAnimal, String cageType)
    {
        this.numberOfAnimal = numberOfAnimal;
        this.numberOfAnimalPresent = 0;
        this.cageType = cageType;
        animalList = new ArrayList<Animal>(numberOfAnimal);
    }
    
    String getCageType()
    {
        return cageType;
    }
    
    List<Animal> getAnimalList()
    {
        return animalList;
    }
    
    boolean isAddAnimalPossible()
    {
        if(numberOfAnimal == numberOfAnimalPresent)
        {
            return false;
        }
        return true;
    }
    
    void addAnimal(Animal animal)
    {
         
        this.animalList.add(animal);
        numberOfAnimalPresent++;
    }
    
    void removeAnimal(Animal animal)
    {
        this.animalList.remove(animal);
        numberOfAnimalPresent--;
    }
    
    String getCageInfo()
    {
        return "Cage type: " + cageType +
               "Total number of animals cage can hold: " + numberOfAnimal +
               "Number of animals currently in the cage: " + numberOfAnimalPresent +
               "Animals in the cage: " + getAllAnimalNamesInCage();
    }
    
    String getAllAnimalNamesInCage()
    {
        String allAnimalNames = "";
        for(Animal animal: animalList)
        {
            allAnimalNames = allAnimalNames + animal.getAnimalName() + "   ";
        }
        return allAnimalNames;
    }
}
