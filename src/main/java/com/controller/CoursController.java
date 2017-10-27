package com.controller;

import com.beans.*;
import com.dao.*;
import com.factory.Factory;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/")
public class CoursController {

    private CoursDAO coursDAO = Factory.getCoursDAO();

    @GET
    @Path("/{idCours}")
    public Cours getCour(@PathParam("idCours") Long id){
        return coursDAO.getCour(id);
    }

//    @GET
//    public List<Cours> getCours(){
//        return coursDAO.getCours();
//    }

//    @GET
//    @Path("cours")
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable getCours(){
//        //return Response.temporaryRedirect(URI.create("/pages/register.jsp")).build();
//        Map<String, Object> model = new HashMap<>();
//        List<Cours> cours = coursDAO.getCours();
//        model.put("cours", cours);
//
//        return new Viewable("/pages/courseRegister.jsp", model);
//    }

    @GET
    @Path("courseRegister")
    @Produces(MediaType.TEXT_HTML)
    public Viewable register(){

        Map<String, Object> model = new HashMap<>();
        List<Cours> cours = coursDAO.getCours();
        model.put("cours", cours);

        return new Viewable("/pages/courseRegister.jsp", model);
    }

//    @POST
//    @Path("cours")
//    @Produces(MediaType.TEXT_HTML)
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Viewable addUser()
//
//    }

    @POST
    public Cours addCours(Cours cours){
        return coursDAO.addCours(cours);
    }

    @DELETE
    @Path("/{idCours}")
    public void deleteCours(@PathParam("idCours") Long id){
        coursDAO.deleteCours(id);
    }

    @PUT
    public Cours updateCours(Cours cours){
        return coursDAO.updateCours(cours);
    }


}
