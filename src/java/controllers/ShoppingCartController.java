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
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    
     public void ConfirmBestelling() throws ServletException, IOException {
         
      
      bestelling = shoppingCart.addBestelling(loginController.getKlant());  
      String message = "Uw bestelling met een totaal van " + bestelling.getTotaal() + " eur werd succesvol verwerkt.\n";
      message += "Uw confirmatie nummer is " + bestelling.getConfirmatienummer();
      runServlet(message);
      //return "bestellingconfirmatie?faces-redirect=true";
      
    }
 
    public void clearCart() {
        
        shoppingCart.clearCart();
    }   
    
    public void runServlet(String message) throws ServletException, IOException {
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        System.out.println("adres van de receiver = " + loginController.getKlant().getEmail());
        
        request.setAttribute("receiver",loginController.getKlant().getEmail());
        request.setAttribute("subject", "Bestelling bij Reisbureau ");
        request.setAttribute("content", message);
        
        ServletContext sc = (ServletContext) fc.getExternalContext().getContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/MailServlet");
        dispatcher.forward(request,response);
    }
   

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

}

