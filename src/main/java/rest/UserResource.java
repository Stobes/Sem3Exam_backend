/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookingDTO;
import dtos.UserDTO;
import dtos.WashingAssistantDTO;
import entities.User;
import facades.UserFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author 45319
 */
@Path("user")
public class UserResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade UF = UserFacade.getUserFacade(EMF);
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    public UserResource() {
    }

    @Path("adduser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO createUser(UserDTO u) throws Exception {
        return UF.create(u);
    }
    
    @Path("washers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllWashers() throws Exception {
        return Response.ok(gson.toJson(UF.getAllWashers()), MediaType.APPLICATION_JSON).build();
    }
    
    @Path("bookings/{userName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBookings(@PathParam("userName") String userName) throws Exception {
        return Response.ok(gson.toJson(UF.getAllBookings(userName)),  MediaType.APPLICATION_JSON).build();
    }
    
    @Path("addwasher")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public WashingAssistantDTO createWasher(WashingAssistantDTO wDTO) throws Exception {
        return UF.createWasher(wDTO);
    } 
    
    @Path("addbooking")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookingDTO createBookingWithWashers(BookingDTO bDTO) throws Exception {
        return UF.createBookingWithWashers(bDTO);
    }
    
    @Path("deletebooking/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBooking(@PathParam("id")int id) throws Exception{
        return Response.ok(gson.toJson(UF.deleteBooking(id)), MediaType.APPLICATION_JSON).build();
    }
}
