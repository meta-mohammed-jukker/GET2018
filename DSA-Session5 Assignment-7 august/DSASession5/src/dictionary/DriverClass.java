package dictionary;

public class DriverClass
{
    @SuppressWarnings("rawtypes")
    public static void main(String[] args)
    {
        System.out.println("***Binary Search Tree Dictionary***");
        BinarySearchTreeDictionary<Character> bstd = new BinarySearchTreeDictionary<Character>();
        
        System.out.println("add");
        bstd.add("d", 'a');
        bstd.add("b", 's');
        bstd.add("a", 'h');
        bstd.add("c", 'd');
        bstd.add("e", 'q');
        
        System.out.println("delete");
        bstd.delete("c");
        bstd.delete("c");
        
        System.out.println("sort");
        for(Item item: bstd.sort())
        {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
        
        System.out.println("sort between");
        for(Item item: bstd.sortBetween("b", "f"))
        {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
        
        System.out.println("get value of b");
        System.out.println(bstd.get("b"));
        
        System.out.println("get value of c");
        try
        {
        System.out.println(bstd.get("c"));
        }
        catch(AssertionError ae)
        {
            System.out.println(ae.getMessage());
        }
        
        System.out.println("***JSON Binary Search Tree Dictionary***");
        JSONBSTDictionary jbstd = new JSONBSTDictionary("DictionaryData.json");
        
        System.out.println("add");
        jbstd.add();
        
        System.out.println("delete");
        jbstd.delete();
        
        System.out.println("sort");
        for(Item item: jbstd.sort())
        {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
        
        System.out.println("sort between");
        for(Item item: jbstd.sortBetween())
        {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
        
        System.out.println("get value");
        for(String value: jbstd.get())
        {
            System.out.println(value);
        }
    }
}
