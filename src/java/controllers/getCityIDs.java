///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controllers;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Serializable;
//import java.net.URL;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Named;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
///**
// *
// * @author Jean
// */
//@Named(value = "cityID")
//@SessionScoped
//public class getCityIDs implements Serializable {
//
//    //Parser
//    //  private static final String filePath = "C:\\Users\\Jean\\Documents\\NetBeansProjects\\PhpProject1\\Reis\\RBureau222\\web\\json\\stedenNamen.json";
//    JSONObject jsonObject;
//    String travelName;
//    //jsonTest test;
//    public long getCityIDs(String name) {
//
//     //   test.getJsonFromURL();
//        try {
//            JSONParser parser = new JSONParser();
//            InputStream in = getClass().getResourceAsStream("/dataSteden/stedenNamen1.json");
//            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
//                String line;
//                while ((line = br.readLine()) != null) {
//                    jsonObject = (JSONObject) parser.parse(line);
//                    if(jsonObject.get("name").equals(name)){
//                       System.out.println(jsonObject.get("name"));
//                       long id = (long) jsonObject.get("_id");                      
//                       return id;
//                    }
//                }    
//            }  
//    }
//    catch (FileNotFoundException ex
//        ) {
//            Logger.getLogger(getCityIDs.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    catch (IOException | ParseException ex
//        ) {
//            Logger.getLogger(getCityIDs.class.getName()).log(Level.SEVERE, null, ex);
//    }
//
//    System.out.println (
//    "einde functie");
//
//return 0;
//    }
//
//    public String test() {
//        return "hello world";
//    }
//}
