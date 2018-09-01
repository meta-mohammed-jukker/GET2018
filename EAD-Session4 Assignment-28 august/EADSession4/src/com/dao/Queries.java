package com.dao;

public class Queries
{
    public static final String insertValuesIntoUser = "INSERT INTO " + 
                                 "user(firstName, lastName, age, dateOfBirth, contactNumber, " + 
                                 "organization, userImageURL, email) " +
                                 "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
    
    public static final String insertValuesIntoUserPasswordMapping =  "INSERT INTO " + 
                                 "userPasswordMapping(email, password) " +
                                 "VALUES(?, ?);";
    
    public static final String getUserDetails = "SELECT u.userID, u.firstName, u.lastName, u.age, u.userImageURL, " + 
                                                "u.dateOfBirth, u.contactNumber, u.organization, u.email, upm.password " + 
                                                "FROM user AS u " + 
                                                "JOIN userPasswordMapping AS upm ON u.email = upm.email " + 
                                                "WHERE u.email = ? ;";
    
    public static final String updateUser = "Update user " + 
                                            "SET firstName = ?, " + 
                                                "lastName = ?, " + 
                                                "age = ?, " +
                                                "dateOfBirth = ?, " + 
                                                "contactNumber = ?, " +
                                                "organization = ? " +
                                            "WHERE email = ? ;"; 
    
    public static final String getFriendList = "SELECT email, firstName, lastName " + 
                                               "FROM user " + 
                                               "WHERE organization = ?;";
    
    public static final String changeImageUrl = "Update user " + 
                                                "SET userImageURL = ? " +
                                                "WHERE email = ? ;";
}
