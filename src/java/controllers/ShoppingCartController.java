/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cart.ReisItem;
import entities.BesteldeReis;
import entities.Bestelling;
import entities.Klant;
import entities.Reis;
import interceptor.LoggerM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.ShoppingCart;
import org.primefaces.context.RequestContext;

/**
 *
 * @author michael
 */
@Named(value = "ShoppingCartController")
@SessionScoped
public class ShoppingCartController implements Serializable {

    @EJB
    private ShoppingCart shoppingCart; 

    @LoggerM
    public void addItem(Reis item) {    
        
       
        
        shoppingCart.addItem(item);

    }
    
    public float getTotalBestelling(){
    
        return shoppingCart.getTotalBestelling();
    }

    public String getReisListsize() {

        return shoppingCart.getReisListsize();
    }
    
    public String getpersonenperReis(){
    
      return shoppingCart.getpersonenperReis();
    
    }

    public void ConfirmBestelling(Klant klant) {
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantId(klant);
        bestelling.setTotaal(shoppingCart.getTotalBestelling());
        
        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        bestelling.setConfirmatienummer(i);
        
        BesteldeReis besteldeReis = new BesteldeReis();
        
        

    }
    
    public List<ReisItem> getReisItemList(){
       
        
        
       // RequestContext.getCurrentInstance().execute("document.getElementById('reizen_string').innerHTML = '';");
        return shoppingCart.getrList();
    }
 
    public void clearCart() {
    }

}

