package databaseConnectionThroughJDBC;

import java.util.Date;

public class Orders
{
    int id;
    Date orderPlacingDate;
    float total;
    
    public Orders(int id, Date orderPlacingDate, float total)
    {
        this.id = id; 
        this.orderPlacingDate = orderPlacingDate;
        this.total = total;
    }
    
    /**
     * Returns order ID 
     * @return order ID
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returns order placing date
     * @return order placing date
     */
    public Date getOrderPlacingDate()
    {
        return orderPlacingDate;
    }
    
    /**
     * Returns order total
     * @return order total
     */
    public float getTotal()
    {
        return total;
    }
}
