/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Reis;
import entities.Reiscategorie;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.ReisFacade;
import model.ReiscategorieFacade;


/**
 *
 * @author michael
 */
@Named(value = "LoginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private ReisFacade reisFacade;
    private ReiscategorieFacade reiscategorieFacade;
   
    public LoginController() {
    }
    
    public List<Reis> findAll(){
        
        return reisFacade.findAll();
    }    
    
    public List<Reiscategorie> findAllReisCategories(){
        return reiscategorieFacade.findAll();
    }
}
