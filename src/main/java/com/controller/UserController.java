package com.controller;

import com.beans.*;
import com.dao.UserDAO;
import com.factory.Factory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private UserDAO userDAO = Factory.getUserDAO();

    @GET
    @Path("/{idUser}")
    public User getUser(@PathParam("idUser") Long id){
        return userDAO.getUser(id);
    }

    @GET
    public List<User> getUsers(){
        return userDAO.getUsers();
    }

    @POST
    public User addUser(User user){
        return userDAO.addUser(user);
    }

    @DELETE
    @Path("/{idUser}")
    public void deleteUser(@PathParam("idUser") Long id){
        userDAO.deleteUser(id);
    }

    @PUT
    public User updateUser(User user){
        return userDAO.updateUser(user);
    }

}
