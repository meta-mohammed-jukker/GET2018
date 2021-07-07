package com.facade;

import java.util.List;

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
    /**
     * Returns list of all users belonging to a particular organization
     * @param organization
     * @return
     */
    public List<UserPOJO> getFriendList(String organization)
    {
        UserDAO userOperation = new UserDAO();
        
        return userOperation.getFriendList(organization);
    }
    
    /**
     * Sets new image path
     * @param user
     * @return
     */
    public boolean changeImage(UserPOJO user)
    {
        user.setImageURL("images/" + user.getImageURL());
        UserDAO userOperation = new UserDAO();
        userOperation.changeImageURL(user);
        return true;
    }
}
