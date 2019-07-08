package session8;

public class DriverClass
{
    public static void main(String[] args)
    {
        ZooManagement z = new ZooManagement();
        z.addAnimal(AnimalFamily.LION);
        System.out.println("wwwwwwww");
        z.removeAnimal();
        z.addAnimal(AnimalFamily.CROCODILE);
        System.out.println("wwwwwwwwwwwwlion");
        z.addAnimal(AnimalFamily.PEACOCK);
        z.removeAnimal();
    }
}
