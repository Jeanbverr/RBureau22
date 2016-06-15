/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*Automatic timer*/
import entities.Reis;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
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

    private List<Float> oudeReizen = new ArrayList<>();
     //private List<Reis> reizenTemp;
    
    @EJB
    private ReisFacade reisFacade;
    private List<Reis> reizen;
    
   

    @Schedule(second = "20" , minute = "43", hour = "9", dayOfWeek = "Tue")
    public void myTimer() {
        System.out.println(new Date());

        reizen = reisFacade.findAll();
      
        reizen.stream().forEach((reizen1) -> {
           oudeReizen.add(reizen1.getPrijs());
            reizen1.setPrijs(reizen1.getPrijs() + reizen1.getPrijs() * 0.1f);
            
//              System.out.println(oudeReizen);
        });
    }

    @Schedule(minute = "43", second = "35", hour = "9", dayOfWeek = "Tue")
    public void otherTimer() {

        System.out.println("test");
        reizen = reisFacade.findAll();
        int i = 0;
            for(Reis reizen1: reizen) {
                   // reizen1.setPrijs(reizen1.getPrijs() - reizen1.getPrijs() * 0.1f);
                if(!(oudeReizen.isEmpty()) && oudeReizen != null){                
                reizen1.setPrijs(oudeReizen.get(i));
                i++;
            
                }else{
                    System.out.println("test2");
                    }
            }
             oudeReizen.clear();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
