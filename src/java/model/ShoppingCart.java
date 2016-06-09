/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Bestelling;
import entities.Reis;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateful;

/**
 *
 * @author michael
 */
@Stateful
public class ShoppingCart {

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

    public String getpersonenperReis() {

        String reizeCheckout = "";
        uniqueLocationNames = new HashSet<>(locationNames);
        for (String key : uniqueLocationNames) {

            reizeCheckout += "Voor " + Collections.frequency(locationNames, key) + " personen naar " + key.toString() + ", ";
        }
        System.out.println(uniqueLocationNames);
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

    public Float getTotal() {
        if (rList == null || rList.isEmpty()) {
            return 0f;
        }
        Float total = 0f;
        total = rList.stream().map((reizen) -> (reizen.getPrijs())).reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }



    public void clearCart() {
        rList.clear();
    }
}
