/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entities.*;
import interceptor.LoggerM;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KlantFacade;

/**
 *
 * @author michael Session scoped -> data wordt gedurende een sessie behouden
 * Request scoped -> data wordt gedurende 1 request behouden(wanneer volgende
 * pagina laad is de data verloren)
 *
 */
@Named(value = "LoginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private KlantFacade klantFacade;
    private Klant klant = new Klant();

    private String email;
    private String pwd;
    private String name;
    private boolean loggedIn;

    public LoginController() {
    }

    //Returned de volledige lijst van klanten in de klant Tabel
    public List<Klant> findAll() {

        return klantFacade.findAll();
    }

    @LoggerM
    public String loginValidation() {
        klant = klantFacade.findByEmail(email);
        if (klant == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User does not exist, please register first", ""));
            return "login";
        } else if (klant.getEmail().equals(email) && klant.getPaswoord().equals(pwd)) {

            System.out.println("login succesful");
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
            //HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
            //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            // session.invalidate();
            //  final HttpSession session = request.getSession()
            request.setAttribute("authenticated", fc);
            HttpSession session = request.getSession(true);      
            name = klant.getNaam();
            loggedIn = true;
            return "default?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong combination of user and password", ""));
            return "login";
        }
    }

        public String logout() {       
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
         session.invalidate();
         return "login?faces-redirect=true";
    }
        
    

    //Voor registratie 
    public String add() {

        this.klantFacade.create(this.klant);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration succesfull, you can now log in", ""));
        return "";
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Klant getKlant() {
        return klant;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

}
