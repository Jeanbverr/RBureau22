/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import cart.ReisItem;
import entities.Bestelling;
import entities.Klant;
import entities.Reis;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateful;

/**
 *
 * @author michael
 */
@Stateful
public class ShoppingCart {

    private List<ReisItem> rList = new ArrayList<ReisItem>();  
    private Bestelling bestelling = new Bestelling();
    
   
    

    public void addItem(Reis item) {

        ReisItem currentReisitem = null;
        for (ReisItem reisI : rList) {

            if (reisI.getReis().getLocatie().equals(item.getLocatie())) {
                currentReisitem = reisI;
            }
        }

        if (currentReisitem == null) {
            ReisItem reisItem = new ReisItem(item);
            rList.add(reisItem);

        } else {

            currentReisitem.incrementAantal();

        }
        rList.stream().forEach((reisitem) -> {
            System.out.println(reisitem.getReis().getLocatie());

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

    public String getpersonenperReis() {

          String reizeCheckout = "";
//        uniqueLocationNames = new HashSet<>(locationNames);
        for (ReisItem reisI : rList) {

            reizeCheckout += "Voor " + reisI.getAantal() + " personen naar " + reisI.getReis().getLocatie() + ", ";
        }        
        return reizeCheckout;

    }

    public void removeReis(Reis item) {
        if (rList.contains(item)) {
            rList.remove(item);
        }
    }

    public Integer getNumberOfReizen() {
        if (rList.isEmpty() || rList == null) {
            return 0;
        } else {
            return rList.size();
        }
    }

    public Float getTotalBestelling() {
        float totalBestelling = 0f;
        for(ReisItem reisI: rList){
            
            totalBestelling += reisI.getTotal();
        
        }
        return totalBestelling;
    }
    
    public void addBestelling(Klant klant){
        
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantId(klant);
        bestelling.setTotaal(this.getTotalBestelling());
        
        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        bestelling.setConfirmatienummer(i);
        
              
        
        
    }
    
    public void addReizentoBestelling(){
    
    
    }

    public void clearCart() {
        rList.clear();
    }

    public List<ReisItem> getrList() {
        return rList;
    }

    public void setrList(List<ReisItem> rList) {
        this.rList = rList;
    }
    
    
}
