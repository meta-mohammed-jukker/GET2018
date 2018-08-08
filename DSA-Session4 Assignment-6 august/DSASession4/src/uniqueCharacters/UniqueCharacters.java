package uniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCharacters
{
    private Map<String, Integer> previouslyEncounteredString;
    
    /**
     * Initializes UniqueCharacters class
     */
    public UniqueCharacters()
    {
        this.previouslyEncounteredString = new HashMap<String, Integer>();
    }
    
    /**
     * Finds count of unique characters in the string
     * @param inputString string
     * @return number of unique characters in the string
     */
    public int findNumberOfUniqueCharacters(String inputString)
    {
        Set<Character> characters = new HashSet<Character>();
        Set<Character> duplicateCharacters = new HashSet<Character>();
        if(previouslyEncounteredString.containsKey(inputString))
        {
            //System.out.println("From map");
            return previouslyEncounteredString.get(inputString);
        }
        else
        {
            for(int i=0; i<inputString.length(); i++)
            {
                if(duplicateCharacters.contains(inputString.charAt(i)))
                {
                    continue;
                }
                if(characters.contains(inputString.charAt(i)))
                {
                    characters.remove(inputString.charAt(i));
                    duplicateCharacters.add(inputString.charAt(i));
                }
                else
                {
                    characters.add(inputString.charAt(i));
                }
            }
            previouslyEncounteredString.put(inputString, characters.size());
        }
        return characters.size();
    }
}
