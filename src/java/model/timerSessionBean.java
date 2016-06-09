/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*Automatic timer*/
import entities.Reis;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.Timeout;

/**
 *
 * @author Jean
 */
@Stateless
public class timerSessionBean {

    @EJB
    private ReisFacade reisFacade;
    private List<Reis> reizen;
 
    @Schedule(second = "0", minute = "0", hour ="0", dayOfWeek = "Sun")
    public void myTimer() {
         System.out.println(new Date());
        reizen = reisFacade.findAll();
        reizen.stream().forEach((reizen1) -> {       
              reizen1.setPrijs(reizen1.getPrijs()+reizen1.getPrijs()*0.1f);
        });
    }

     @Schedule(minute = "0", second = "0", hour = "0", dayOfWeek = "Mon")
     public void otherTimer(){
            reizen = reisFacade.findAll();
        reizen.stream().forEach((reizen1) -> {       
              reizen1.setPrijs(reizen1.getPrijs()-reizen1.getPrijs()*0.1f);
        });
     }
  
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
