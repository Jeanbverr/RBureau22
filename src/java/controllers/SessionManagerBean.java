/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.servlet.annotation.WebListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 *
 * @author Jean
 */
@Named(value = "SessionManagerBean")
@Singleton
@LocalBean
@WebListener
public class SessionManagerBean implements HttpSessionListener {

  private static int totalActiveSessions;


  @Override
  public void sessionCreated(HttpSessionEvent arg0) {       
	totalActiveSessions++;
	System.out.println("sessionCreated - add one session into counter: " + totalActiveSessions);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
         totalActiveSessions--;
	System.out.println("sessionDestroyed - deduct one session from counter");
  }

    public int getTotalActiveSessions() {
        return totalActiveSessions;
    }

    public void setTotalActiveSessions(int totalActiveSessions) {
        SessionManagerBean.totalActiveSessions = totalActiveSessions;
    }
    
}