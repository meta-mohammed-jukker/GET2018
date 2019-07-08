package session8;

public class Lion extends Mammal
{
    String nativeFrom;
    
    Lion(int animalID, String animalName, String nativeFrom)
    {
        this.animalID = animalID;
        this.animalName = animalName;
        this.hasFurs = true;
        this.nativeFrom = nativeFrom;
        this.animalType = "MAMMAL";
        this.animalSpecies = AnimalFamily.LION;
    }
    
    String getInfo()
    {
        return "Animal ID: " + animalID +
               "\nAnimal Name: " + animalName +
               "Animal Type: " + animalType +
               "Does animal has furs: " + hasFurs +
               "Native from: " + nativeFrom +
               "Animal species: " + animalSpecies;
    }
}
