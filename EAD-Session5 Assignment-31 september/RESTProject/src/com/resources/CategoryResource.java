package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.facade.AdvertisementFacade;
import com.facade.CategoryFacade;
import com.google.gson.Gson;
import com.model.Advertisement;
import com.model.Category;

@Path("/categories")
public class CategoryResource
{
private CategoryFacade categoryFacade = new CategoryFacade();
    
    @GET
    @Path("/getCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCategories() 
    {
        List<Category> categoryList = categoryFacade.getAll();
        Gson gson = new Gson();
        String categoryJson = gson.toJson(categoryList);
        return categoryJson;
    }
    
    @POST
    @Path("/addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addCategory(String categoryInput)
    {
        Gson g = new Gson();
        Category category = g.fromJson(categoryInput, Category.class);
        return categoryFacade.add(category);
    }
    
    @DELETE
    @Path("/deleteCategory")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteCategory(String categoryID)
    {
        int id = Integer.parseInt(categoryID);
        return categoryFacade.delete(id);
    }
    
    @PUT
    @Path("/updateCategory")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateCategory(String categoryNames)
    {
        String[] categoryName = categoryNames.split(" to ");
        return categoryFacade.updateName(categoryName[0], categoryName[1]);
    }
}
