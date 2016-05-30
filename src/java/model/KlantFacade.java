/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Klant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author michael
 */
@Stateless
public class KlantFacade extends AbstractFacade<Klant> {

    @PersistenceContext(unitName = "KutprojectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
    
    public Klant findByEmail(String email){
        Klant klant = null;
        try{
            klant = (Klant) em.createNamedQuery("Klant.findByEmail").setParameter("email",email).getSingleResult();
        }catch(NoResultException ex ){
            ex.getMessage();
        }
        
        return klant;
    }

    public KlantFacade() {
        super(Klant.class);
        
    }
    
}
