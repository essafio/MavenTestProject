package com.controller;

import com.beans.*;
import com.dao.UserDAO;
import com.factory.Factory;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/users")
public class UserController {

    private UserDAO userDAO = Factory.getUserDAO();

    /*@GET
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("idUser") Long id){
        return userDAO.getUser(id);
    }*/

    @GET
    @Path("/{idUser}")
    @Produces(MediaType.TEXT_HTML)
    public Viewable getUser(@PathParam("idUser") Long id){

        Map<String, Object> model = new HashMap<>();
        model.put("user", userDAO.getUser(id));

        return new Viewable("/pages/myProfile.jsp", model);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getUsers(){
        //return Response.temporaryRedirect(URI.create("/pages/register.jsp")).build();
        Map<String, Object> model = new HashMap<>();
        List<User> users = userDAO.getUsers();
        model.put("users", users);

        return new Viewable("/pages/allUsers.jsp", model);
    }

    /*@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user){
        return userDAO.addUser(user);
    }*/

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Viewable addUser(@FormParam("fname") String fname,
                        @FormParam("lname") String lname,
                        @FormParam("email") String email,
                        @FormParam("username") String username,
                        @FormParam("password") String password){

        User user = new User();
        user.setLname(lname);
        user.setFname(fname);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        Map<String, Object> model = new HashMap<>();
        model.put("user", userDAO.addUser(user));
        model.put("msg", "Registration successful");    //var msg should be adapted to the result of addUser()

        return new Viewable("/pages/login.jsp", model);
    }

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Viewable getUserByLogin(@Context HttpServletRequest request,
                                   @FormParam("username") String username,
                                   @FormParam("password") String password){

        User user = userDAO.getUserByLogin(username, password); //getting the user using login info

        //Initiating the session var
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        model.put("msg", "Login successful");   //var msg should be adapted to the result of the query

        return new Viewable("/pages/myProfile.jsp", model);
    }

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    public Viewable login(){
        return new Viewable("/pages/login.jsp");
    }

    @GET
    @Path("/logout")
    @Produces(MediaType.TEXT_HTML)
    public Viewable logout(@Context HttpServletRequest request){
        request.getSession().invalidate();
        return new Viewable("/pages/home.jsp");
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
