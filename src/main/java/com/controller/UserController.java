package com.controller;

import com.beans.*;
import com.dao.UserDAO;
import com.factory.Factory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserController {

    UserDAO userDAO = Factory.getUserDAO();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser(){
        return "Add user";
        //userDAO.addUser(user);

    }



}
