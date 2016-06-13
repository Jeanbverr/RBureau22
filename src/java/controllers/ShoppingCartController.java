/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cart.ReisItem;
import entities.Bestelling;
import entities.Klant;
import entities.Reis;
import interceptor.LoggerM;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import model.ShoppingCart;


/**
 *
 * @author michael
 */
@Named(value = "ShoppingCartController")
@SessionScoped
public class ShoppingCartController implements Serializable {

    @EJB
    private ShoppingCart shoppingCart; 
    
    @Inject    
    private LoginController loginController;
    
    Bestelling bestelling;

    public Bestelling getBestelling() {
        return bestelling;
    }
   

    @LoggerM
    public void addItem(Reis item) {          
        
        shoppingCart.addItem(item);
    }
    
    public void removeItem(ReisItem item){
    
        shoppingCart.removeReis(item);    
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
    
    public List<ReisItem> getReisItemList(){      
       
       // RequestContext.getCurrentInstance().execute("document.getElementById('reizen_string').innerHTML = '';");
        return shoppingCart.getrList();
    }
    
     public String ConfirmBestelling() {
         
      
      bestelling = shoppingCart.addBestelling(loginController.getKlant());  
     
      return "bestellingconfirmatie?faces-redirect=true";
      
    }
 
    public void clearCart() {
        
        shoppingCart.clearCart();
    }   
   

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

}

