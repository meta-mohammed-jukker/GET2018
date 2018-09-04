package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Advertisement;

public class AdvertisementDAO implements BaseDAO<Advertisement>
{
    private Connection connection;
    
    public AdvertisementDAO()
    {
        connection = JDBCConnectivity.getMysqlConnection("root", "mohammed", "advertisementDatabase");
    }
    
    /**
     * Adds advertisement
     */
    public boolean add(Advertisement advertisement)
    {

        int advertisementAdded = 0;
        String query = Queries.setAdvertisement;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, advertisement.getTitle());
            preparedStatement.setString(2, advertisement.getDescription());
            preparedStatement.setInt(3, advertisement.getCategoryID());
            
            advertisementAdded = preparedStatement.executeUpdate();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        
        if(advertisementAdded > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns list of all advertisements
     */
    public List<Advertisement> getAll()
    {

        List<Advertisement> advertisementList  = new ArrayList<Advertisement>();
        String query = Queries.getAllAdvertisement;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                int id = resultSet.getInt("advertisementID");
                String title = resultSet.getString("advertisementTitle");
                String description = resultSet.getString("advertisementDescription");
                int categoryID = resultSet.getInt("categoryID");
                
                Advertisement advertisement = new Advertisement(id, title, description, categoryID);
                advertisementList.add(advertisement);
            }
            resultSet.close();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        return advertisementList;
    }
    
    /**
     * Updates advertisement name
     */
    public boolean updateName(String oldAdvertisementTitle, String newAdvertisementTitle)
    {

        int advertisementUpdated = 0;
        String query = Queries.updateAdvertisementName;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, newAdvertisementTitle);
            preparedStatement.setString(2, oldAdvertisementTitle);
            
            advertisementUpdated = preparedStatement.executeUpdate();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        
        if(advertisementUpdated > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Deletes advertisement
     */
    public boolean delete(int id)
    {
        int advertisementDeleted = 0;
        String query = Queries.deleteAdvertisement;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setInt(1, id);
            
            advertisementDeleted = preparedStatement.executeUpdate();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        
        if(advertisementDeleted > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns all advertisements of a particular category
     * @param categoryID
     * @return
     */
    public List<Advertisement> getAllAdvertisementsByCategoryID(int categoryID)
    {

        List<Advertisement> advertisementList  = new ArrayList<Advertisement>();
        String query = Queries.getAdvertisementsByCategoryID;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setInt(1, categoryID);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                int id = resultSet.getInt("advertisementID");
                String title = resultSet.getString("advertisementTitle");
                String description = resultSet.getString("advertisementDescription");
                
                Advertisement advertisement = new Advertisement(id, title, description, categoryID);
                advertisementList.add(advertisement);
            }
            resultSet.close();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        return advertisementList;
    }
    
    /**
     * Closes connection
     */
    public void dispose()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
    }
}
