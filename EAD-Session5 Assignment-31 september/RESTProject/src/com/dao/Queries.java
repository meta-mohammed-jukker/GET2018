package com.dao;

public class Queries
{
    public static final String setCategory = "INSERT INTO category(categoryName) VALUES (?) ;";
    
    public static final String setAdvertisement = "INSERT INTO advertisement(advertisementTitle, advertisementDescription, categoryID) " + 
                                                  "VALUES (?, ?, ?);";
    
    public static final String getAllCategories = "Select categoryID, categoryName FROM category;";
    
    public static final String getAllAdvertisement = "Select advertisementID, advertisementTitle, advertisementDescription, categoryID " + 
                                                     "FROM advertisement;";
    
    public static final String updateCategoryName = "UPDATE category " + 
                                                    "SET categoryName = ? " + 
                                                    "WHERE categoryName = ? ";
    
    public static final String updateAdvertisementName = "UPDATE advertisement " + 
                                                         "SET advertisementTitle = ? " + 
                                                         "WHERE advertisementTitle = ? ";
    
    public static final String deleteCategory = "DELETE FROM category WHERE categoryID = ? ;";
    
    public static final String deleteAdvertisement = "DELETE FROM advertisement WHERE advertisementID = ? ;"; 
    
    public static final String getAdvertisementsByCategoryID = "SELECT advertisementID, advertisementTitle, advertisementDescription, categoryID " +
                                                               "FROM advertisement WHERE categoryID = ? ;";
}
