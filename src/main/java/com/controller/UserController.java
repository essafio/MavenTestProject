package com.controller;

import com.beans.*;
import com.dao.UserDAO;
import com.factory.Factory;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Produces(MediaType.TEXT_HTML)
    public Viewable getUsers(@Context HttpServletRequest request){
        //return Response.temporaryRedirect(URI.create("/pages/register.jsp")).build();
        Map<String, Object> model = new HashMap<>();
        List<User> users = userDAO.getUsers();
        model.put("users", users);
        return new Viewable("/pages/allUsers.jsp", model);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user){
        return userDAO.addUser(user);
    }

    @DELETE
    @Path("/{idUser}")
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
