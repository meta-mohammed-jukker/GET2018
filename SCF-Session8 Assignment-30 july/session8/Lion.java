package session8;

public class Lion extends Mammal
{
    String nativeFrom;
    
    /**
     * Initializes Animal class with Lion
     * @param animalID animal ID
     * @param animalName animal name
     * @param nativeFrom native region of animal
     */
    Lion(int animalID, String animalName, String nativeFrom)
    {
        this.animalID = animalID;
        this.animalName = animalName;
        this.hasFurs = true;
        this.nativeFrom = nativeFrom;
        this.animalType = "MAMMAL";
        this.animalSpecies = AnimalFamily.LION;
    }
    
    /**
     * Returns animal information
     */
    String getInfo()
    {
        return "Animal ID: " + animalID +
               "\nAnimal Name: " + animalName +
               "\nAnimal Type: " + animalType +
               "\nDoes animal has furs: " + hasFurs +
               "\nNative from: " + nativeFrom +
               "\nAnimal species: " + animalSpecies;
    }
}
