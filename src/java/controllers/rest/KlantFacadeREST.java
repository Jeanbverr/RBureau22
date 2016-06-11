/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entities.Klant;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jdk.nashorn.internal.ir.RuntimeNode;
import model.KlantFacade;

/**
 *
 * @author Thomas
 */
@Stateless
@Path("klant")
public class KlantFacadeREST extends AbstractFacade<Klant> {
    
    @EJB
    private KlantFacade klantFacade;
    @PersistenceContext(unitName = "KutprojectPU")
    private EntityManager em;
    private final Gson jsonConverter = new Gson();
    

    public KlantFacadeREST() {
        super(Klant.class);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(String jsonString) {
        System.out.println(jsonString);
        Klant klant = jsonConverter.fromJson(jsonString, Klant.class);
        super.create(klant);
        
        try{
            klantFacade.findByEmail(klant.getEmail());
            return Response.ok().build();
        }
        catch( Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Klant entity) {
        super.edit(entity);
    }

//    NIET NODIG
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Integer id) {
//        super.remove(super.find(id));
//    }

    @GET
    @Path("{email}/{password}")
    @Produces({"application/xml", "application/json"})
    public Response login(@PathParam("email") String email, @PathParam("password") String password) {
        Klant klant = klantFacade.findByEmail(email);
        
        if(klant == null){
            //return not found http response
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else{
            if(klant.getEmail().equals(email) && klant.getPaswoord().equals(password)){
                //return ok response with user object
                return Response.ok(klant, MediaType.APPLICATION_JSON).build();
            }
            else{
                //return bad request response -> password =! correct
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
    }

//    NIET NODIG -> MAG UITEINDELIJK WEG
//    @GET
//    @Override
//    @Produces({"application/xml", "application/json"})
//    public List<Klant> findAll() {
//        return super.findAll();
//    }

//    NIET NODIG -> MAG UITEINDELIJK WEG
//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<Klant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
