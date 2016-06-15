///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controllers;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
///**
// *
// * @author Jean
// */
//public class jsonTest {
//
//    JSONObject jsonObject;
//
//    public jsonTest() {
//    }
//
//    public String getJsonFromURL() {
//        try {
//            JSONParser parser = new JSONParser();
//            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=2996746&appid=64a79f5d634a103105af8dd363550cd9");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            if (conn.getResponseCode() != 200) {
//                return "0";
//            }
//            
//
//            BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String input;
//         //   StringBuffer jsonString = new StringBuffer();
//            while ((input = buffer.readLine()) != null) {
//                jsonObject = (JSONObject) parser.parse(input);
//                System.out.println("IETS TESTEN: " +jsonObject.get("coord"));
//            }
//            
//            conn.disconnect();
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(getCityIDs.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException | ParseException ex) {
//            Logger.getLogger(getCityIDs.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception e) {
//            return "false";
//        }
//        return "";
//    }
//}
//
