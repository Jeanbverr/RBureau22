/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.rest;

import entities.BesteldeReis;
import entities.BesteldeReisPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Thomas
 */
@Stateless
@Path("besteldereis")
public class BesteldeReisFacadeREST extends AbstractFacade<BesteldeReis> {
    @PersistenceContext(unitName = "KutprojectPU")
    private EntityManager em;

    private BesteldeReisPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;bestellingId=bestellingIdValue;reisId=reisIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.BesteldeReisPK key = new entities.BesteldeReisPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> bestellingId = map.get("bestellingId");
        if (bestellingId != null && !bestellingId.isEmpty()) {
            key.setBestellingId(new java.lang.Integer(bestellingId.get(0)));
        }
        java.util.List<String> reisId = map.get("reisId");
        if (reisId != null && !reisId.isEmpty()) {
            key.setReisId(new java.lang.Integer(reisId.get(0)));
        }
        return key;
    }

    public BesteldeReisFacadeREST() {
        super(BesteldeReis.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(BesteldeReis entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, BesteldeReis entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.BesteldeReisPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public BesteldeReis find(@PathParam("id") PathSegment id) {
        entities.BesteldeReisPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<BesteldeReis> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<BesteldeReis> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

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
