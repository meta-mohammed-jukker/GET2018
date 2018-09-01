package com.facade;

import com.dao.UserDAO;
import com.model.UserPOJO;

public class UserFacade
{
    /**
     * Registers user
     * @param user
     * @return
     */
    public boolean registerUser(UserPOJO user)
    {
        Validation validate = new Validation();
        
        if(validate.isEmailAlreadyPresent(user.getEmail()))
        {
            return false;
        }
        
        user.setImageURL("images/userIcon.png");
        
        UserDAO userRegister = new UserDAO();
        if(!(userRegister.addDataToUser(user)))
        {
            userRegister.dispose();
            return false;
        }
        if(!(userRegister.addDataToUserPasswordMapping(user)))
        {
            userRegister.dispose();
            return false;
        }
        userRegister.dispose();
        return true;
        
    }
    
    /**
     * Return user details
     * @param email
     * @return
     */
    public UserPOJO getDetails(String email)
    {
        UserDAO userOperation = new UserDAO();
        
        return userOperation.getUserDetails(email);
    }
}
