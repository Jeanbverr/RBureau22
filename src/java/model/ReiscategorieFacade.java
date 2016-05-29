/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Reiscategorie;
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
    
}
