package com.facade;

import java.util.List;

import com.dao.CategoryDAO;
import com.model.Category;

public class CategoryFacade
{    
    /**
     * Adds category
     */
    public boolean add(Category category)
    {
        CategoryDAO categoryOperations = new CategoryDAO();
        boolean isAdded = categoryOperations.add(category);
        categoryOperations.dispose();
        return isAdded;
    }
    
    /**
     * Returns list of all categories
     */
    public List<Category> getAll()
    {
        CategoryDAO categoryOperations = new CategoryDAO();
        List<Category> categoryList = categoryOperations.getAll();
        categoryOperations.dispose();
        return categoryList;
    }
    
    /**
     * Update category name
     */
    public boolean updateName(String oldCategoryName, String newCategoryName)
    {
        CategoryDAO categoryOperations = new CategoryDAO();
        boolean isUpdated = categoryOperations.updateName(oldCategoryName, newCategoryName);
        categoryOperations.dispose();
        return isUpdated;
    }
    
    /**
     * Deletes category
     */
    public boolean delete(int id)
    {
        CategoryDAO categoryOperations = new CategoryDAO();
        boolean isDeleted = categoryOperations.delete(id);
        categoryOperations.dispose();
        return isDeleted;
    }
}
