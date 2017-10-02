package com.controller;

import com.beans.*;
import com.dao.UserDAO;
import com.factory.Factory;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Path("/")
public class UserController {

    private UserDAO userDAO = Factory.getUserDAO();
    private final String SALT = "ENCRYPTED";

    /*@GET
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("idUser") Long id){
        return userDAO.getUser(id);
    }*/

    @GET
    @Path("users/{idUser}")
    @Produces(MediaType.TEXT_HTML)
    public Viewable getUser(@PathParam("idUser") Long id){

        Map<String, Object> model = new HashMap<>();
        model.put("user", userDAO.getUser(id));

        return new Viewable("/pages/myProfile.jsp", model);
    }

    @GET
    @Path("users")
    @Produces(MediaType.TEXT_HTML)
    public Viewable getUsers(){
        //return Response.temporaryRedirect(URI.create("/pages/register.jsp")).build();
        Map<String, Object> model = new HashMap<>();
        List<User> users = userDAO.getUsers();
        model.put("users", users);

        return new Viewable("/pages/allUsers.jsp", model);
    }

    /*@POST
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user){
        System.out.println("here !!!");
        return userDAO.addUser(user);
    }*/

    @GET
    @Path("register")
    @Produces(MediaType.TEXT_HTML)
    public Viewable register(){
        return new Viewable("/pages/register.jsp");
    }

    @POST
    @Path("users")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Viewable addUser(@FormParam("fname") String fname,
                        @FormParam("lname") String lname,
                        @FormParam("email") String email,
                        @FormParam("username") String username,
                        @FormParam("password") String password){

        Map<String, Object> model = new HashMap<>();

        fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
        lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);

        if (null != email) {
            String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                model.put("errormsg", "Invalid email address");
                return new Viewable("/pages/register.jsp", model);
            }
        }

        //Username should be checked against db

        password = get_SHA_512_SecurePassword(password, SALT);

        User user = new User();
        user.setLname(lname);
        user.setFname(fname);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);


        model.put("user", userDAO.addUser(user));
        model.put("msg", "Registration successful");    //var msg should be adapted to the result of addUser()

        return new Viewable("/pages/login.jsp", model);
    }

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Viewable getUserByLogin(@Context HttpServletRequest request,
                                   @FormParam("username") String username,
                                   @FormParam("password") String password){

        password = get_SHA_512_SecurePassword(password, SALT);
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
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public Viewable login(){
        return new Viewable("/pages/login.jsp");
    }

    @GET
    @Path("logout")
    @Produces(MediaType.TEXT_HTML)
    public Viewable logout(@Context HttpServletRequest request){
        request.getSession().invalidate();
        return new Viewable("/pages/home.jsp");
    }

    @DELETE
    @Path("users/{idUser}")
    public void deleteUser(@PathParam("idUser") Long id){
        userDAO.deleteUser(id);
    }

    @PUT
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(User user){
        return userDAO.updateUser(user);
    }


    public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
