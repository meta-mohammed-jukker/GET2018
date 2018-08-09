package dictionary;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONBSTDictionary
{
    JSONObject jsonObject;
    BinarySearchTreeDictionary<String> binarySearchTreeDictionary;
    
    /**
     * Initializes JSONBSTDictionary and sets jsonObject
     * @param fileName name of .json file where data is kept
     */
    public JSONBSTDictionary(String fileName)
    {
        binarySearchTreeDictionary = new BinarySearchTreeDictionary<String>();
        File file = null;
        try 
        {
            String location = "C:/Users/Mohammed/workspace/DSASession5/src/dictionary";
            file = new File(location, "/" + fileName);

            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(new FileReader(file));
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    /**
     * Adds data from .json file
     */
    public void add()
    {
        JSONArray inputArray = (JSONArray) jsonObject.get("addData");
        
        for(int i=0; i<inputArray.size(); i++)
        {
            JSONArray entry = (JSONArray) inputArray.get(i);
            String key = (String) entry.get(0);
            String value = (String) entry.get(1);
            binarySearchTreeDictionary.add(key, value);
        }
    }

    /**
     * Deletes key, value from binary search tree
     */
    public void delete()
    {
        JSONArray inputArray = (JSONArray) jsonObject.get("deleteData");
        
        for(int i=0; i<inputArray.size(); i++)
        {
            String key = (String) inputArray.get(i);
            binarySearchTreeDictionary.delete(key);
        }
    }

    /**
     * Returns value corresponding to the key
     * @return values
     */
    public List<String> get()
    {
        List<String> valueList = new ArrayList<String>();
        JSONArray inputArray = (JSONArray) jsonObject.get("getValue");
        
        for(int i=0; i<inputArray.size(); i++)
        {
            String key = (String) inputArray.get(i);
            System.out.println(key);
            valueList.add(binarySearchTreeDictionary.get(key));
        }
        return valueList;
    }

    /**
     * Sorts items according to key
     * @return list of items
     */
    public List<Item> sort()
    {
        return binarySearchTreeDictionary.sort();
    }

    /**
     * Returns list of sorted item, whose key lies between key1 and key2
     * @return
     */
    public List<Item> sortBetween()
    {
        JSONArray inputArray = (JSONArray) jsonObject.get("sortBetween");
        String key1 = (String) inputArray.get(0);
        String key2 = (String) inputArray.get(1);
        return binarySearchTreeDictionary.sortBetween(key1, key2);
    }
}
