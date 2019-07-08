package session8;

public abstract class Animal
{
    int animalID;
    String animalName;
    String animalType;
    AnimalFamily animalSpecies;
    
    /**
     * Returns animal type
     * @return animal type
     */
    String getAnimalType()
    {
        return animalType;
    }
    
    /**
     * Returns animal name
     * @return animal name
     */
    String getAnimalName()
    {
        return animalName;
    }
    
    /**
     * Returns animal ID
     * @return animal ID
     */
    int getAnimalID()
    {
        return animalID;
    }
    
    /**
     * Returns animal species
     * @return animal species
     */
    AnimalFamily getAnimalSpecies()
    {
        return animalSpecies;
    }
    
    abstract String getInfo();
}
