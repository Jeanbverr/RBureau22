/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import cart.ReisItem;
import entities.BesteldeReis;
import entities.BesteldeReisPK;
import entities.Bestelling;
import entities.Klant;
import entities.Reis;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author michael
 */
@Stateful
public class ShoppingCart {

    @EJB
    private BesteldeReisFacade besteldeReisFacade;

    @EJB
    private BestellingFacade bestellingFacade;  
    
    @PersistenceContext(unitName = "KutprojectPU")
    private EntityManager em;
    
    
    
    
    private List<ReisItem> rList = new ArrayList<ReisItem>();  
       

    public void addItem(Reis item) {

        ReisItem currentReisitem = null;
        for (ReisItem reisI : rList) {

            if (reisI.getReis().getLocatie().equals(item.getLocatie())) {
                currentReisitem = reisI;            }
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

    public void removeReis(ReisItem item) {
        if (rList.contains(item)) {
            rList.remove(item);
        }
    }

    public int getNumberOfReizen() {
        if (rList.isEmpty() || rList == null) {
            return 0;
        } else {
            return rList.size();
        }
    }

    public float getTotalBestelling() {
        float totalBestelling = 0f;
        for(ReisItem reisI: rList){
            
            totalBestelling += reisI.getTotal();
        
        }
        return totalBestelling;
    }
    
    
    
    public Bestelling addBestelling(Klant klant){
        
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantId(klant);
        bestelling.setTotaal(this.getTotalBestelling());
        
        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        bestelling.setConfirmatienummer(i); 
        
        
        bestellingFacade.create(bestelling);  
       // System.out.println("The id van de bestelling is " + bestelling.getId());
        //Voeg reizen in de shoppingcart toe aan de bestelling
       addReizentoBestelling(bestelling);       
        
        // maak shopping cart leeg       
       clearCart();
       
       return bestelling;
    
    }
    
    public void addReizentoBestelling(Bestelling bestelling){
        
            

            //The ID is only guaranteed to be generated at flush time.
            //Persisting an entity only makes it "attached" to the persistence context. So, either flush the entity manager explicitely
            em.flush();
            
            System.out.println("The id van de bestelling is " + bestelling.getId());
            for(ReisItem reisItem: rList){
            
                int reisId = reisItem.getReis().getId();
                
                //Koppel elke reis aan de bestelling vd klant door pk object
                BesteldeReisPK besteldeReisPK = new BesteldeReisPK();
                besteldeReisPK.setReisId(reisId);
                besteldeReisPK.setBestellingId(bestelling.getId());
                
                //bestelde reis wordt aangemaakt met primary key object
                BesteldeReis besteldereis = new BesteldeReis(besteldeReisPK);
                besteldereis.setAantalPersonen(reisItem.getAantal());
                besteldeReisFacade.create(besteldereis);               
            
            }    
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

    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
