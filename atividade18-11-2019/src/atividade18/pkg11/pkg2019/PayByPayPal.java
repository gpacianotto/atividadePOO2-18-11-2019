/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade18.pkg11.pkg2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SAMSUNG
 */
public class PayByPayPal implements PayStrategy{
    
    private static final Map<String,String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;
    
    static{
        DATA_BASE.put("joelSantana", "joelzinho@gmail.com");
        DATA_BASE.put("guttenclayton", "GTLindo@gmail.com");
    }
    
    @Override
    public void collectPaymentDetails(){
        try{
            while(!signedIn){
                System.out.println("enter the user's email: ");
                email = READER.readLine();
                if(verify()){
                    System.out.println("Data verification has been successful");
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private boolean verify(){
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }
    public boolean pay(int paymentAmount){
        if(signedIn){
            System.out.println("Paying "+paymentAmount+"using paypal.");
            return true;
        }
        else{
            return false;
        }
    }
    private void setSignedIn(boolean signedIn){
        this.signedIn = signedIn;
    } 
}
