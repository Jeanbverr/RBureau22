/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author michael
 */
@Named(value = "ShoppingCartController")
@SessionScoped
public class ShoppingCartController implements Serializable {

    @EJB
    private model.ShoppingCart shoppingCart;

    
    @LoggerM
    public void addItem(Reis item) {      
        
        shoppingCart.addItem(item);

    }

    public String getReisListsize() {

        return shoppingCart.getReisListsize();
    }
    
    public String getpersonenperReis(){
    
      return shoppingCart.getpersonenperReis();
    
    }

    public void ConfirmBestelling(Klant klant) {

    }

    public void clearCart() {
    }

}

