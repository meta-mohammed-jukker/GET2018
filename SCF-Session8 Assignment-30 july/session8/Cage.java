package session8;

import java.util.*;
public class Cage
{
    String cageType;
    int numberOfAnimal;
    int numberOfAnimalPresent;
    List<Animal> animalList;
    AnimalFamily animalSpecies;
    
    /**
     * Initializes Cage
     * @param numberOfAnimal maximum number of animals possible in the cage
     * @param cageType type of cage
     * @param animalSpecies animal species that can be added to the cage
     */
    Cage(int numberOfAnimal, String cageType, AnimalFamily animalSpecies)
    {
        this.numberOfAnimal = numberOfAnimal;
        this.numberOfAnimalPresent = 0;
        this.cageType = cageType;
        animalList = new ArrayList<Animal>(numberOfAnimal);
        this.animalSpecies = animalSpecies;
    }
    
    /**
     * Returns type of cage
     * @return type of cage
     */
    String getCageType()
    {
        return cageType;
    }
    
    /**
     * Returns list of animals
     * @return list of animals
     */
    List<Animal> getAnimalList()
    {
        return animalList;
    }
    
    /**
     * Returns list of animals
     * @return list of animals
     */
    boolean isAddAnimalPossible()
    {
        if(numberOfAnimal == numberOfAnimalPresent)
        {
            return false;
        }
        return true;
    }
    
    /**
     * Adds animal to the cage
     * @param animal Animal object
     */
    void addAnimal(Animal animal)
    {
         
        this.animalList.add(animal);
        numberOfAnimalPresent++;
    }
    
    /**
     * Removes animal
     * @param animal Animal object
     */
    void removeAnimal(Animal animal)
    {
        this.animalList.remove(animal);
        numberOfAnimalPresent--;
    }
    
    /**
     * Returns animal species that can be added to the cage
     * @return animal species
     */
    AnimalFamily getAnimalSpecies()
    {
        return animalSpecies;
    }
}
