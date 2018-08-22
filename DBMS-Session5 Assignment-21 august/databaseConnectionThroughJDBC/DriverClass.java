package databaseConnectionThroughJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DriverClass
{
    public static void main(String[] args)
    {
        /*
        JDBCConnectivity jc = new JDBCConnectivity();
        Connection conn = jc.getMysqlConnection("root", "mohammed", "storeFront");
        
        String strSelect = "select userID from user";
        try
        {
            PreparedStatement stmt = conn.prepareStatement(strSelect);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString("userID"));
            }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        System.out.println();
        */
        
        MysqlQueries msq = new MysqlQueries();
        
        for(Orders o: msq.getAllOrdersByState(2, "shipped"))
        {
            System.out.println(o.getID() + " " + o.getOrderPlacingDate() + " " + o.getTotal());
        }
        
        System.out.println();
        
        ProductImage i = new ProductImage("www.abc.com", "jdbc test image 1");
        ProductImage j = new ProductImage("www.def.com", "jdbc test image 2");
        ProductImage k = new ProductImage("www.ghi.com", "jdbc test image 3");
        List<ProductImage> imageList = new ArrayList<ProductImage>();
        imageList.add(i);
        imageList.add(j);
        imageList.add(k);
        
        System.out.println(msq.addImages(imageList, 2));
        
        System.out.println(msq.updateStatusOfProduct());
        
        System.out.println();
        
        for(Category c: msq.getTopCategoryWithChildrenCount())
        {
            System.out.println(c.getName() + " " + c.getSubCategoryCount());
        }
    }
}
