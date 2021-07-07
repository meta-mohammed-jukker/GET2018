package com.facade;

import java.util.List;

import com.dao.AdvertisementDAO;
import com.model.Advertisement;

public class AdvertisementFacade
{ 
    /**
     * Adds advertisement
     */
    public boolean add(Advertisement category)
    {
        AdvertisementDAO advertisementOperations = new AdvertisementDAO();
        boolean isAdded =  advertisementOperations.add(category);
        advertisementOperations.dispose();
        return isAdded;
    }
    
    /**
     * Returns list of all advertisements
     */
    public List<Advertisement> getAll()
    {
        AdvertisementDAO advertisementOperations = new AdvertisementDAO();
        List<Advertisement> advertisementList = advertisementOperations.getAll();
        advertisementOperations.dispose();
        return advertisementList;
    }
    
    /**
     * Updates advertisement name
     */
    public boolean updateName(String oldAdvertisementTitle, String newAdvertisementTitle)
    {
        AdvertisementDAO advertisementOperations = new AdvertisementDAO();
        boolean isUpdated = advertisementOperations.updateName(oldAdvertisementTitle, newAdvertisementTitle); 
        advertisementOperations.dispose();
        return isUpdated;
    }
    
    /**
     * Deletes advertisement
     */
    public boolean delete(int id)
    {
        AdvertisementDAO advertisementOperations = new AdvertisementDAO();
        boolean isDeleted = advertisementOperations.delete(id);
        advertisementOperations.dispose();
        return isDeleted;
    }
    
    /**
     * Returns all advertisements of a particular category
     * @param categoryID
     * @return
     */
    public List<Advertisement> getAllAdvertisementsByCategoryID(int categoryID)
    {
        AdvertisementDAO advertisementOperations = new AdvertisementDAO();
        List<Advertisement> advertisementList = 
                advertisementOperations.getAllAdvertisementsByCategoryID(categoryID);
        advertisementOperations.dispose();
        return advertisementList;
    }
}
