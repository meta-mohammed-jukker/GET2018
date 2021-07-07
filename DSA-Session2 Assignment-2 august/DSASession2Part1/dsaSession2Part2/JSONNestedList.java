package dsaSession2Part2;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONNestedList
{
    private List<Object> nestedList;
    
    /**
     * Initializes JSONNestedList with input .json file
     * @param fileName
     */
    public JSONNestedList(String fileName)
    {
        nestedList = new ArrayList<Object>();
        File file = null;
        try 
        {
            String location = 
                    "C:\\Users\\Mohammed\\eclipse-workspace\\DSASession2\\src\\dsaSession2Part2";
            file = new File(location, "/" + fileName);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
            JSONArray jsonArray = (JSONArray) jsonObject.get("nestedListData");
            nestedList = convertToList(jsonArray);
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println("File address is : " + file);
        }
    }
    
    /**
     * Converts JSON array to list
     * @param array JSON array
     * @return nested list
     * @throws NestedListException
     */
    private List<Object> convertToList(JSONArray array) throws NestedListException 
    {
        if (array.size() == 0) 
        {
            throw new NestedListException("JSONArray Not Exist");
        }

        List<Object> nestedList = new ArrayList<Object>();
        for (int i = 0, j = array.size(); i < j; i++) 
        {
            if (array.get(i) instanceof Number) 
            {
                nestedList.add(Integer.parseInt(array.get(i) + ""));
            //If object is instance of JSONArray again parse it for Number
            } 
            else if (array.get(i) instanceof JSONArray) 
            {
                nestedList.add(convertToList((JSONArray) array.get(i)));
            }
            else 
            {
                throw new NestedListException("Wrong object Type");
            }
        }
        return nestedList;
    }

    /**
     * Sum of all elements in nested list
     * @param object nested list
     * @return sum
     * @throws NestedListException
     */
    public int sum(Object object) throws NestedListException
    {
        int sum = 0;
        if(object instanceof Integer) 
        {
            sum = (Integer) object;
        }
        else if(object instanceof List) 
        {
            for(Object iterator: (List)object) 
            {
                sum += sum(iterator);
            }
        } 
        else
        {
            throw new NestedListException("Wrong object Type");
        }
        return sum;
    }

    /**
     * Returns largest value presents in nested list
     * @param object nested list
     * @return largest value
     * @throws NestedListException
     */
    public int getLargestValue(Object object) throws NestedListException
    {
        int largestValue = 0;
        boolean isFirstValue = true;
        if(object instanceof Integer) 
        {
            largestValue = (Integer) object;
        }
        else if(object instanceof List) 
        {
            for(Object iterator: (List)object) 
            {
                if(isFirstValue) 
                {
                    largestValue = getLargestValue(iterator);
                    isFirstValue = false;
                }
                largestValue = Math.max(largestValue, getLargestValue(iterator));
            }
        } 
        else 
        {
            throw new NestedListException("Wrong object Type");
        }
        return largestValue;
    }

    /**
     * Checks if value is present in nested list or not
     * @param object nested list 
     * @param value value to be searched
     * @return true if value found else false
     * @throws NestedListException
     */
    public boolean isPresent(Object object, int value) throws NestedListException
    {
        boolean search = false;
        if(object instanceof Integer) 
        {
            if((Integer) object == value)
            search = true;
        }
        else if(object instanceof List) 
        {
            for(Object iterator: (List)object) 
            {
                if(!search && isPresent(iterator, value)) 
                {
                    search = true;
                }
            }
        } 
        else
        {
            throw new NestedListException("Wrong object Type");
        }
        return search;
    }
    
    /**
     * Returns nested list
     * @return
     */
    public List<Object> getList() 
    {
        return nestedList;
    }
}
