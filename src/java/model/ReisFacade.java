/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Reis;
import entities.Reiscategorie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author michael
 */
@Stateless
public class ReisFacade extends AbstractFacade<Reis> {

    @PersistenceContext(unitName = "KutprojectPU")
    private EntityManager em;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReisFacade() {
        super(Reis.class);
    }   
    
     public List<Reis> getReisList(){
         
        Reiscategorie cat = null;
       // System.out.println("Reizen: " + cat.getReisList());
         return cat.getReisList();

      //  Reiscategorie cat = (Reiscategorie) em.createNamedQuery("Reiscategorie.findByNaam").setParameter("naam", category).getSingleResult();
       
        //return cat.getReisList();  
      }
    
  
}
