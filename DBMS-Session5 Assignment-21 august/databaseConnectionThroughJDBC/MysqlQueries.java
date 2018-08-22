package databaseConnectionThroughJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class MysqlQueries
{
    JDBCConnectivity jdbcConnect = new JDBCConnectivity();
    
    /**
     * Returns all orders of a user which are in particular state
     * @param userID userID of user
     * @param state order state
     * @return orderID, orderPlacingDate, orderTotal
     */
    public List<Orders> getAllOrdersByState(int userID, String state)
    {
        List<Orders> orderList = new ArrayList<Orders>();
        
        Connection connection = jdbcConnect.getMysqlConnection("root", "mohammed", "storeFront");
        
        String query = "SELECT o.orderID, o.orderPlacingDate, Sum(p.price * opr.numberOfProduct) as total " + 
                        "FROM orders AS o " + 
                        "LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID " + 
                        "LEFT JOIN product AS p ON opr.productID = p.productID " + 
                        "WHERE o.userID = ? AND o.overallStatus = ? " + 
                        "GROUP BY o.orderID " + 
                        "ORDER BY o.orderPlacingDate DESC ";
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, state);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                int orderID = resultSet.getInt("orderID");
                Date orderPlacingDate = resultSet.getDate("orderPlacingDate");
                float total = resultSet.getFloat("total");
                
                Orders order = new Orders(orderID, orderPlacingDate, total);
                orderList.add(order);
            }
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return orderList;
    }
    
    /**
     * Adds multiple images
     * @param imageList list of image objects
     */
    public int addImages(List<ProductImage> imageList)
    {
        Connection connection = jdbcConnect.getMysqlConnection("root", "mohammed", "storeFront");
        int imagesAdded = 0;
        String query = "INSERT INTO productImage(productID, imageLocation, alternateName) " + 
                       "VALUES(?, ?, ?)";
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {            
            for(ProductImage image: imageList)
            {
                preparedStatement.setInt(1, image.getProductID());
                preparedStatement.setString(2, image.getImageLocation());
                preparedStatement.setString(3, image.getAlternateName());
                preparedStatement.addBatch();
            }
            imagesAdded = preparedStatement.executeBatch().length;
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return imagesAdded;
    }
    
    /**
     * Adds multiple images to a particular products
     * @param imageList list of image objects
     */
    public int addImages(List<ProductImage> imageList, int productID)
    {
        Connection connection = jdbcConnect.getMysqlConnection("root", "mohammed", "storeFront");
        int imagesAdded = 0;
        String query = "INSERT INTO productImage(productID, imageLocation, alternateName) " + 
                       "VALUES(?, ?, ?)";
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {            
            for(ProductImage image: imageList)
            {
                preparedStatement.setInt(1, productID);
                preparedStatement.setString(2, image.getImageLocation());
                preparedStatement.setString(3, image.getAlternateName());
                preparedStatement.addBatch();
            }
            imagesAdded = preparedStatement.executeBatch().length;
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return imagesAdded;
    }
    
    /**
     * Updates product status to deleted 
     * for all those products which were not ordered by any Shopper in last 1 year. 
     * @return number of products updated
     */
    public int updateStatusOfProduct()
    {
        int numberOfProductsDeleted = 0;
        
        Connection connection = jdbcConnect.getMysqlConnection("root", "mohammed", "storeFront");
        
        String query = "UPDATE product " + 
                               "SET productState = 'deleted' " + 
                               "where productID not in " + 
                               "( " + 
                                  "SELECT productID " + 
                                  "FROM orderProductRelationship AS opr " + 
                                  "LEFT JOIN orders AS o ON opr.orderID = o.orderID " + 
                                  "WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 1 year) " + 
                               ");";
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            numberOfProductsDeleted = preparedStatement.executeUpdate();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return numberOfProductsDeleted;
    }
    
    /**
     * Returns all categories which have no parent category
     * along with number of children categories it have.
     * @return list of top categories along with count of its sub categories
     */
    public List<Category> getTopCategoryWithChildrenCount()
    {
        Connection connection = jdbcConnect.getMysqlConnection("root", "mohammed", "storeFront");
        
        List<Category> categoryList =new ArrayList<Category>();
        
        String query = "SELECT categoryID, categoryName " + 
                       "FROM category " + 
                       "WHERE parentCategoryID IS NULL " + 
                       "ORDER BY categoryName";
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            ResultSet topCategories = preparedStatement.executeQuery();
            while(topCategories.next())
            {
                int topCategoryID = topCategories.getInt("categoryID");
                String topCategoryName = topCategories.getString("categoryName");
                int subCategoriesCount = countSubCategories(topCategoryID);
                
                Category category = new Category(topCategoryID, topCategoryName, subCategoriesCount);
                categoryList.add(category);
            }
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return categoryList;
    }
    
    /**
     * Recursively counts sub categories of parent category
     * @param categoryID
     * @return
     */
    public int countSubCategories(int categoryID)
    {
        int count = 0;
        Connection connection = jdbcConnect.getMysqlConnection("root", "mohammed", "storeFront");
        try
        {
            String subCategories = "SELECT categoryID " + 
                                   "FROM category " + 
                                   "WHERE parentCategoryID = ?";

            PreparedStatement subCategoriesStatement = 
                    connection.prepareStatement(subCategories);

            subCategoriesStatement.setInt(1, categoryID);
            ResultSet subCategoriesSet = subCategoriesStatement.executeQuery();
            
            while(subCategoriesSet.next())
            {
                int subCategoryID = subCategoriesSet.getInt("categoryID");
                
                count = count + 1 + countSubCategories(subCategoryID);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
    }
}
