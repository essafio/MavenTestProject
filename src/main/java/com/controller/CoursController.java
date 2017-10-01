package com.controller;

import com.beans.*;
import com.dao.*;
import com.factory.Factory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cours")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursController {

    private CoursDAO coursDAO = Factory.getCoursDAO();

    @GET
    @Path("/{idCours}")
    public Cours getCour(@PathParam("idCours") Long id){
        return coursDAO.getCour(id);
    }

    @GET
    public List<Cours> getCours(){
        return coursDAO.getCours();
    }

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
