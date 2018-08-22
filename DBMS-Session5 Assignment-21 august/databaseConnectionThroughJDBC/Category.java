package databaseConnectionThroughJDBC;

public class Category
{
    int id;
    String name;
    int subCategoryCount;
    
    public Category(int id, String name, int subCategoryCount)
    {
        this.id = id;
        this.name = name;
        this.subCategoryCount = subCategoryCount;
    }
    
    /**
     * Returns category ID 
     * @return category ID
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returns category Name 
     * @return category Name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns sub category count 
     * @return sub category count
     */
    public int getSubCategoryCount()
    {
        return subCategoryCount;
    }
}
