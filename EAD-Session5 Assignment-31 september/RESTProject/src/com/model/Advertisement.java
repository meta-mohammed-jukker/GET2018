package com.model;

public class Advertisement
{
    int id; 
    String title; 
    String description;
    int categoryID;
    
    public Advertisement(int id, String title, String description, int categoryID)
    {
        this.id = id; 
        this.title = title;
        this.description = description; 
        this.categoryID = categoryID;
    }
    
    public Advertisement(String title, String description, int categoryID)
    { 
        this.title = title;
        this.description = description; 
        this.categoryID = categoryID;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }
    
    
}
