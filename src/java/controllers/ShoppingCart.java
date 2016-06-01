/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Bestelling;
import entities.Klant;
import entities.Reis;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author michael
 */
@Named(value = "ShoppingCart")
@SessionScoped
public class ShoppingCart implements Serializable {

    //Implementie in stateful session bean steken
    //List van reizen
    private List<Reis> rList = new ArrayList<Reis>();
    private List<String> locationNames = new ArrayList<String>();    
    private Set<String> uniqueLocationNames;
    private Bestelling bestelling = new Bestelling();

    public void addItem(Reis item) {        
        
        rList.add(item);
        locationNames.add(item.getLocatie());
        
        rList.stream().forEach((reis) -> {            
            System.out.println(reis.getLocatie());

        });
        System.out.println("There are " + rList.size() + " reizen in your shopping cart");
        

    }

    public String getReisListsize() {

        String size;
        if (rList.isEmpty()) {
            size = "";
        } else {
            size = Integer.toString(rList.size());

        }

        return size;
    }
    
    public String getpersonenperReis(){
    
        String kutstring="";
        uniqueLocationNames = new HashSet<>(locationNames);
        for(String key: uniqueLocationNames) {
            
            kutstring += "Voor "+Collections.frequency(locationNames, key)+" p naar " + key.toString() + ", ";
        }
        System.out.println(uniqueLocationNames);
        return kutstring;
    
    }

    public void ConfirmBestelling(Klant klant) {

    }

    public void clearCart() {
    }

}

