package uniqueCharacters;

public class DriverClass
{
    public static void main(String[] args)
    {
        UniqueCharacters uniqueCharacters = new UniqueCharacters();
        
        int numberOFUniqueCharacters = uniqueCharacters.findNumberOfUniqueCharacters("MOHAMMED");
        System.out.println(numberOFUniqueCharacters);
        
        numberOFUniqueCharacters = uniqueCharacters.findNumberOfUniqueCharacters("MOHAMMED");
        System.out.println(numberOFUniqueCharacters);
    }
}
