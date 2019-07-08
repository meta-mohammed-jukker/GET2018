package session8;

public class Peacock extends Bird
{
    int tailFeatherFanSize;
    
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
    
    String getInfo()
    {
        return "Animal ID: " + animalID +
               "\nAnimal Name: " + animalName +
               "Animal Type: " + animalType +
               "Wing Span: " + wingSpan +
               "Can Fly: " + canFly +
               "Tail feather fan size(diameter): " + tailFeatherFanSize +
               "Animal species: " + animalSpecies;
    }
}
