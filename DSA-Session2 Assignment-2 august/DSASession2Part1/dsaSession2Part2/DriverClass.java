package dsaSession2Part2;

import java.util.Arrays;

public class DriverClass
{
    public static void main(String args[]) throws NestedListException 
    {
        IntegerNestedList integerNestedList = new IntegerNestedList();
        
        //{1, {2, {3, 4}}, 5}
        integerNestedList.add(Arrays.asList(1, Arrays.asList(2, Arrays.asList(3, 4), 5)));
        integerNestedList.add(89);//{1, {2, {3, 4}}, 5, 89}
        
        int sum = integerNestedList.sum(integerNestedList.getList());
        System.out.println(sum);
        
        boolean isPresent = integerNestedList.isPresent(integerNestedList.getList(), 3);
        System.out.println(isPresent);
        
        int largestValue = integerNestedList.getLargestValue(integerNestedList.getList());
        System.out.println(largestValue);
        
        
        JSONNestedList jsonNestedList = new JSONNestedList("data.json");
        
        int jsonSum = jsonNestedList.sum(jsonNestedList.getList());
        System.out.println(jsonSum);
        
        boolean jsonSearch = jsonNestedList.isPresent(jsonNestedList.getList(), 3);
        System.out.println(jsonSearch);
        
        int jsonLargestValue = jsonNestedList.getLargestValue(jsonNestedList.getList());
        System.out.println(jsonLargestValue);
    }
}
