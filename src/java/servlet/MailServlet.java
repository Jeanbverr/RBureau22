/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author michael
 */
@WebServlet(name = "MailServlet", urlPatterns = {"/MailServlet"})
public class MailServlet extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;
 
    @Override
    public void init() {        
        host = "smtp.gmail.com";
        port = "587";
        user = "michael.feyaerts@gmail.com";
        pass = "michael1301";
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // reads form fields
        String recipient = (String) request.getAttribute("recipient");
        String subject = (String) request.getAttribute("subject");
        String content = (String) request.getAttribute("content");
        
        System.out.println(recipient + subject + content);
        String resultMessage = "";
 
        try {
            
            //SendMail.sendEmail(host, port, user, pass, recipient, subject,
             //       content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There was an error: " + ex.getMessage();
        } finally {
            System.out.println(resultMessage);
//            getServletContext().getRequestDispatcher("/login?faces-redirect=true")
//                    .forward(request, response);
//            RequestDispatcher rd = request.getRequestDispatcher("/login.xhtml");
//            rd.forward(request, response);
            response.sendRedirect("login.xhtml");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
