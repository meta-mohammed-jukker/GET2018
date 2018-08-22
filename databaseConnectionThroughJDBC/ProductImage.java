package databaseConnectionThroughJDBC;

public class ProductImage
{
    private int id;
    private int productID;
    private String imageLocation;
    private String alternateName;
    
    public ProductImage(int id, int productID, String imageLocation, String alternateName)
    {
        this.id = id;
        this.productID = productID;
        this.imageLocation = imageLocation;
        this.alternateName = alternateName;
    }
    
    public ProductImage(int productID, String imageLocation, String alternateName)
    {
        this.productID = productID;
        this.imageLocation = imageLocation;
        this.alternateName = alternateName;
    }
    
    public ProductImage(String imageLocation, String alternateName)
    {
        this.imageLocation = imageLocation;
        this.alternateName = alternateName;
    }
    
    /**
     * Returns image ID 
     * @return image ID
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returns product ID 
     * @return product ID
     */
    public int getProductID()
    {
        return productID;
    }
    
    /**
     * Returns image location 
     * @return image location
     */
    public String getImageLocation()
    {
        return imageLocation;
    }
    
    /**
     * Returns image alternate name 
     * @return image alternate name
     */
    public String getAlternateName()
    {
        return alternateName;
    }
}
