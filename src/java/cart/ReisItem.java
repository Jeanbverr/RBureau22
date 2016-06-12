/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entities.Reis;

/**
 *
 * @author michael
 */
public class ReisItem {
    
    
    Reis reis;
    int aantal_personen;

    public ReisItem(Reis reis) {
        this.reis = reis;
        aantal_personen = 1;
    }

    public Reis getReis() {
        return reis;
    }

    public int getAantal() {
        
        if(aantal_personen < 0){
            aantal_personen = 0;
        }
        return aantal_personen;
    }

    public void setAantal(int aantal_personen) {
        this.aantal_personen = aantal_personen;
    }

    public void incrementAantal() {
        aantal_personen++;
    }

    public void decrementAantal() {
        
        aantal_personen--;
    }

    public float getTotal() {
        float amount = 0;
        amount = (this.getAantal()) * reis.getPrijs();
        return amount;
    }
    
}
