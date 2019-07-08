package session8;

import java.util.*;

public class DriverClass
{
    /**
     * Main method
     */
    public static void main(String[] args)
    {
        ZooManagement zooManagement = new ZooManagement();
        Scanner scan = new Scanner(System.in);
        
        
        while(true)
        {
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Add Zone");
            System.out.println("4. Exit");
            int choice = scan.nextInt();
            switch(choice)
            {
            case 1:
                System.out.println("Which animal do you want to add: \n"
                        + "1. Lion\n" 
                        + "2. Crocodile\n"
                        + "3. Peacock");
                int animalSpeciesNumber = scan.nextInt();
                AnimalFamily animalSpecies = zooManagement.getAnimalSpecies(animalSpeciesNumber);
                zooManagement.addAnimal(animalSpecies);
                break;
            case 2:
                System.out.println("2. Enter animal ID");
                int animalID = scan.nextInt();
                if(zooManagement.removeAnimal(animalID))
                {
                    System.out.println("Animal removed");
                }
                else
                {
                    System.out.println("Animal not removed");
                }
                break;
            case 3:
                System.out.println("Enter number of cages to be in zone: ");
                int numberOfCages = scan.nextInt();
                System.out.println("Enter zone type: ");
                String zoneType = scan.next();
                System.out.println("Does zone has park(y/n): ");
                String parkChoice = scan.next();
                boolean hasPark;
                if("y".equals(parkChoice))
                {
                    hasPark = true;
                }
                else
                {
                    hasPark = false;
                }
                System.out.println("Does zone has canteen(y/n): ");
                String canteenChoice = scan.next();
                boolean hasCanteen;
                if("y".equals(canteenChoice))
                {
                    hasCanteen = true;
                }
                else
                {
                    hasCanteen = false;
                }
                if(zooManagement.addZone(numberOfCages, zoneType, hasPark, hasCanteen))
                {
                    System.out.println("Zone added");
                }
                else
                {
                    System.out.println("Zone not added");
                }
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice");
                break;
            }
        }
        
    }
}
