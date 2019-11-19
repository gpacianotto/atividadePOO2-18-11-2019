/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade18.pkg11.pkg2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author SAMSUNG
 */
public class PayByCreditCard implements PayStrategy {
    
    private final BufferedReader READER = new BufferedReader (new InputStreamReader (System. in) ) ;
    private CreditCard card;
    
    @Override
    public void collectPaymentDetails(){
        try {
            System. out. println ("Enter the card number: " ) ;
            String number = READER. readLine() ;
            System.out.println ("Enter the card expiration date 'mm/yy':");
            String date = READER.readLine() ;
            System.out.println("Enter the CVV code: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);
            //cödigo para validar nümero do cartäo de credito aqui
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public boolean pay(int paymentAmount){
        if(cardIsPresent()){
            System.out.println("Paying"+paymentAmount+"using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        }
        else{
            return false;
        }
    }

    private boolean cardIsPresent(){
        return card != null;
    }
    
}
