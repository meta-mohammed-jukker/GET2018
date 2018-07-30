package session8;

public abstract class Animal
{
    int animalID;
    String animalName;
    String animalType;
    AnimalFamily animalSpecies;
    
    String getAnimalType()
    {
        return animalType;
    }
    
    String getAnimalName()
    {
        return animalName;
    }
    
    int getAnimalID()
    {
        return animalID;
    }
}
