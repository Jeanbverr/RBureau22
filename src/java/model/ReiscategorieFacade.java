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
import javax.persistence.PersistenceContext;

/**
 *
 * @author michael
 */
@Stateless
public class ReiscategorieFacade extends AbstractFacade<Reiscategorie> {

    @PersistenceContext(unitName = "KutprojectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReiscategorieFacade() {
        super(Reiscategorie.class);
    }
    
    public List<Reis> getReizenByCategory(String category){
        Reiscategorie cat = (Reiscategorie) em.createNamedQuery("Reiscategorie.findByNaam").setParameter("naam", category).getSingleResult();
        System.out.println(cat.getReisList());
        return cat.getReisList();       
    
    }
    
}
