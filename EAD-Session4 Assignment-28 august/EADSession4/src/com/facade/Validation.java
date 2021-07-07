package com.facade;

import com.dao.UserDAO;
import com.model.UserPOJO;

public class Validation
{
    /**
     * Checks if email is present in database
     * @param email
     * @return
     */
    public boolean isEmailAlreadyPresent(String email)
    {
        UserDAO userOperation = new UserDAO();
        
        UserPOJO user = userOperation.getUserDetails(email);
        
        if(user == null)
        {
            return false;
        }
        return true;
    }
    
    /**
     * Compares passwords for a particular email 
     * @param email
     * @param password
     * @return
     */
    public boolean isPasswordMatched(String email, String password)
    {
        UserDAO userOperation = new UserDAO();
        
        UserPOJO user = userOperation.getUserDetails(email);
        
        if(user.getPassword().equals(password))
        {
            return true;
        }
        return false;
        
    }
}
