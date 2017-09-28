package com.controller;

import com.beans.*;
import com.dao.UserDAO;
import com.factory.Factory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserController {

    private UserDAO userDAO = Factory.getUserDAO();

    @GET
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("idUser") Long id){
        return userDAO.getUser(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        return userDAO.getUsers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user){
        return userDAO.addUser(user);
    }

    @DELETE
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("idUser") Long id){
        userDAO.deleteUser(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(User user){
        return userDAO.updateUser(user);
    }

}
