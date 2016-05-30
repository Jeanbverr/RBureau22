/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Reis;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import model.ReisFacade;
import model.ReiscategorieFacade;

/**
 *
 * @author michael
 */
@Named(value = "reisController")
@SessionScoped
public class ReisController implements Serializable {

    @EJB
    private ReisFacade reisFacade;

    @EJB
    private ReiscategorieFacade reiscategorieFacade;
    
  
    public ReisController() {
    }
    

    //Elke categorie bevat een lijst van bijhorende reizen (in de entity)
        public List<Reis> getReizenByCategorie(String categorie){
        
        
        System.out.println("de categorie is " + categorie);
        return reiscategorieFacade.getReizenByCategory(categorie);
    }
    
     
    
}
