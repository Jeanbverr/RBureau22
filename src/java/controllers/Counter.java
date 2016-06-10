/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import counter.websiteVisits;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jean
 */
@Named(value = "Counter")
@RequestScoped
public class Counter {

    @EJB
    private websiteVisits counterBean;

    private int hitCount;

    public Counter() {
        this.hitCount = 0;
    }

    public int getHitCount() {
        hitCount = counterBean.getHits();
        return hitCount;
    }
    public void setHitCount(int newHits) {
        this.hitCount = newHits;
    }
    
}