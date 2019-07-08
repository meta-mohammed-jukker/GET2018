package session8;

public class Crocodile extends Reptile
{
    String crocodileType;
    
    /**
     * Initializes Animal class with Crocodile
     * @param animalID animal ID
     * @param animalName animal name
     * @param crocodileType type of crocodile (Crocodiles/Alligators/Caiman/Gharials)
     */
    Crocodile(int animalID, String animalName, String crocodileType)
    {
        this.animalID = animalID;
        this.animalName = animalName;
        this.isPoisonous = false; 
        this.crocodileType = crocodileType;
        this.animalType = "REPTILE";
        this.animalSpecies = AnimalFamily.CROCODILE;
    }
    
    /**
     * Returns animal information
     */
    String getInfo()
    {
        return "Animal ID: " + animalID +
               "\nAnimal Name: " + animalName +
               "\nAnimal Type: " + animalType +
               "\nIs animal poisonous: " + isPoisonous +
               "\nCrocodile Type: " + crocodileType +
               "\nAnimal species: " + animalSpecies;
    }
}
