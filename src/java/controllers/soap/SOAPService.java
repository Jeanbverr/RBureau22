/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.soap;

import entities.Reis;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.WebResult;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import model.ReiscategorieFacade;

/**
 *
 * @author Thomas
 */
@WebService(serviceName = "ReizenSOAPService")
@Stateless()
public class SOAPService {
    
    @EJB
    private ReiscategorieFacade reisCategorieFacade;
    
    @WebResult(name= "lijstReizen")
    @WebMethod(operationName = "GetCategorieReizen")
    public List<Reis> getSneeuwReizen(@WebParam(name = "categorie") String categorie) throws SOAPException {
        try{
            return reisCategorieFacade.getReizenByCategory(categorie);            
        }
        catch(Exception e){
            return null;
        }
    }
}
