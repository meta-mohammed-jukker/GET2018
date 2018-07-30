package session8;

public class Crocodile extends Reptile
{
    //http://factsanddetails.com/asian/cat68/sub434/item2435.html
    String crocodileType;
    
    Crocodile(int animalID, String animalName, String crocodileType)
    {
        this.animalID = animalID;
        this.animalName = animalName;
        this.isPoisonous = false; 
        this.crocodileType = crocodileType;
        this.animalType = "REPTILE";
        this.animalSpecies = AnimalFamily.CROCODILE;
    }
    
    String getInfo()
    {
        return "Animal ID: " + animalID +
               "\nAnimal Name: " + animalName +
               "Animal Type: " + animalType +
               "Is animal poisonous: " + isPoisonous +
               "Crocodile Type: " + crocodileType +
               "Animal species: " + animalSpecies;
    }
}
