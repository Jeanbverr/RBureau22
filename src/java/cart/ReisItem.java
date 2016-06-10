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
    short aantal_personen;

    public ReisItem(Reis reis) {
        this.reis = reis;
        aantal_personen = 1;
    }

    public Reis getReis() {
        return reis;
    }

    public short getAantal() {
        return aantal_personen;
    }

    public void setAantal(short aantal_personen) {
        this.aantal_personen = aantal_personen;
    }

    public void incrementAantal() {
        aantal_personen++;
    }

    public void decrementAantal() {
        aantal_personen--;
    }

    public double getTotal() {
        float amount = 0;
        amount = (this.getAantal()) * reis.getPrijs();
        return amount;
    }
    
}
