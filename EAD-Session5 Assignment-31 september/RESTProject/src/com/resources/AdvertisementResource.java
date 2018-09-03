package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.facade.AdvertisementFacade;
import com.google.gson.Gson;
import com.model.Advertisement;
import com.model.Category;

@Path("/advertisements")
public class AdvertisementResource
{
    private AdvertisementFacade advertisementFacade = new AdvertisementFacade();
    
    @GET
    @Path("/getAdvertisment")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAdvertisement() 
    {
        List<Advertisement> advertismentList = advertisementFacade.getAll();
        Gson gson = new Gson();
        String advertismnetJson = gson.toJson(advertismentList);
        return advertismnetJson;
    }
    
    @GET
    @Path("/getAdvertismentByCategory/{categoryID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAdvertisementsByCategory(@PathParam("id") String categoryID) 
    {
        int id = Integer.parseInt(categoryID);
        List<Advertisement> advertismentList = 
                advertisementFacade.getAllAdvertisementsByCategoryID(id);
        Gson gson = new Gson();
        String advertismnetJson = gson.toJson(advertismentList);
        return advertismnetJson;
    }
    
    @POST
    @Path("/addAdvertisement")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addAdvertisement(String advertisementInput)
    {
        Gson g = new Gson();
        Advertisement advertisement = g.fromJson(advertisementInput, Advertisement.class);
        return advertisementFacade.add(advertisement);
    }
    
    @DELETE
    @Path("/deleteAdvertisement")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteAdvertisement(String advertisementID)
    {
        int id = Integer.parseInt(advertisementID);
        return advertisementFacade.delete(id);
    }
    
    @PUT
    @Path("/updateAdvertisement")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateCategory(String advertisementTitles)
    {
        String[] advertisementTitle = advertisementTitles.split(" to ");
        return advertisementFacade.updateName(advertisementTitle[0], advertisementTitle[1]);
    }
    
}
