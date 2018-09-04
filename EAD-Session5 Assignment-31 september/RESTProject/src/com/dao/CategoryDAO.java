package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Category;

public class CategoryDAO implements BaseDAO<Category>
{
    private Connection connection;
    
    public CategoryDAO()
    {
        connection = JDBCConnectivity.getMysqlConnection("root", "mohammed", "advertisementDatabase");
    }
    
    /**
     * Adds category
     */
    public boolean add(Category category)
    {

        int categoryAdded = 0;
        String query = Queries.setCategory;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, category.getName());
            
            categoryAdded = preparedStatement.executeUpdate();
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
        
        if(categoryAdded > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns list of all categories
     */
    public List<Category> getAll()
    {

        List<Category> categoryList  = new ArrayList<Category>();
        String query = Queries.getAllCategories;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                int id = resultSet.getInt("categoryID");
                String name = resultSet.getString("categoryName");
                
                Category category = new Category(id, name);
                categoryList.add(category);
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
        return categoryList;
    }
    
    /**
     * Update category name
     */
    public boolean updateName(String oldCategoryName, String newCategoryName)
    {

        int categoryUpdated = 0;
        String query = Queries.updateCategoryName;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, newCategoryName);
            preparedStatement.setString(2, oldCategoryName);
            
            categoryUpdated = preparedStatement.executeUpdate();
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
        
        if(categoryUpdated > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Deletes category
     */
    public boolean delete(int id)
    {
        int categoryDeleted = 0;
        String query = Queries.deleteCategory;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setInt(1, id);
            
            categoryDeleted = preparedStatement.executeUpdate();
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
        
        if(categoryDeleted > 0)
        {
            return true;
        }
        return false;
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
