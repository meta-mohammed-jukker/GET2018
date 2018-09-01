package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.UserPOJO;

public class UserDAO
{

    private Connection connection;
    
    public UserDAO()
    {
        connection = JDBCConnectivity.getMysqlConnection("root", "mohammed", "userDatabase");
    }
    
    /**
     * Adds user data
     * @param user
     * @return
     */
    public boolean addDataToUser(UserPOJO user)
    {
        int userAdded = 0;
        String query = Queries.insertValuesIntoUser;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            Date utilDateOfBirth = user.getDateOfBirth();
            java.sql.Date sqlDateOfBirth = new java.sql.Date(utilDateOfBirth.getTime());
            preparedStatement.setDate(4, sqlDateOfBirth);
            preparedStatement.setString(5, user.getContactNumber());
            preparedStatement.setString(6, user.getOrganization());
            preparedStatement.setString(7, user.getImageURL());
            preparedStatement.setString(8, user.getEmail());
            
            userAdded = preparedStatement.executeUpdate();
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
        
        if(userAdded > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Adds data to userPasswordMapping
     * @param user
     * @return
     */
    public boolean addDataToUserPasswordMapping(UserPOJO user)
    {
        int userAdded = 0;
        String query = Queries.insertValuesIntoUserPasswordMapping;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            
            userAdded = preparedStatement.executeUpdate();
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
        
        if(userAdded > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns user details
     * @param email
     * @return
     */
    public UserPOJO getUserDetails(String email)
    {
        UserPOJO user = null;
        String query = Queries.getUserDetails;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                int userID = resultSet.getInt("userID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String contactNumber = resultSet.getString("contactNumber");
                String organization = resultSet.getString("organization");
                String imageURL = resultSet.getString("userImageURL");
                String password = resultSet.getString("password");
                
                user = new UserPOJO(userID, firstName, lastName, age, dateOfBirth, 
                        contactNumber, organization, imageURL, email, password);
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
        return user;
    }
    
    /**
     * Updates user Details
     * @param user
     * @return
     */
    public boolean updateUserDetails(UserPOJO user)
    {

        int userUpdated = 0;
        String query = Queries.updateUser;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            Date utilDateOfBirth = user.getDateOfBirth();
            java.sql.Date sqlDateOfBirth = new java.sql.Date(utilDateOfBirth.getTime());
            preparedStatement.setDate(4, sqlDateOfBirth);
            preparedStatement.setString(5, user.getContactNumber());
            preparedStatement.setString(6, user.getOrganization());
            preparedStatement.setString(7, user.getEmail());
            
            userUpdated = preparedStatement.executeUpdate();
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
        
        if(userUpdated > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns list of all users belonging to a particular organization 
     * @param organization
     * @return
     */
    public List<UserPOJO> getFriendList(String organization)
    {
        List<UserPOJO> friendList  = new ArrayList<UserPOJO>();
        String query = Queries.getFriendList;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, organization);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                
                UserPOJO user = new UserPOJO();
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                
                friendList.add(user);
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
        return friendList;
    }
    
    /**
     * Change image path
     * @param user
     * @return
     */
    public boolean changeImageURL(UserPOJO user)
    {

        int userUpdated = 0;
        String query = Queries.changeImageUrl;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, user.getImageURL());
            preparedStatement.setString(2, user.getEmail());
            
            userUpdated = preparedStatement.executeUpdate();
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
        
        if(userUpdated > 0)
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
