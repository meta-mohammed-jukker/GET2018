package session8;

public class Peacock extends Bird
{
    int tailFeatherFanSize;
    /**
     * Initializes Animal class with Peacock
     * @param animalID animal ID
     * @param animalName animal name
     * @param wingSpan wing span
     * @param tailFeatherFanSize size(diameter) of fan created by peacocks tail feathers 
     */
    Peacock(int animalID, String animalName, int wingSpan, int tailFeatherFanSize)
    {
        this.animalID = animalID;
        this.animalName = animalName;
        this.wingSpan = wingSpan;
        this.canFly = false;
        this.tailFeatherFanSize = tailFeatherFanSize;
        this.animalType = "BIRD";
        this.animalSpecies = AnimalFamily.PEACOCK;
    }
    
    /**
     * Returns animal information
     */
    String getInfo()
    {
        return "Animal ID: " + animalID +
               "\nAnimal Name: " + animalName +
               "\nAnimal Type: " + animalType +
               "\nWing Span: " + wingSpan +
               "\nCan Fly: " + canFly +
               "\nTail feather fan size(diameter): " + tailFeatherFanSize +
               "\nAnimal species: " + animalSpecies;
    }
}
