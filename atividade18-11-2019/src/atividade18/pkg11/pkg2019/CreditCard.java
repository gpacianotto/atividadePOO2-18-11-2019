/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade18.pkg11.pkg2019;

/**
 *
 * @author SAMSUNG
 */
public class CreditCard {
    
    private int amount;
    private String number;
    private String date;
    private String cvv;
    
    public CreditCard(String number, String date, String cvv){
        
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
        
        
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return amount;
    }
    
    
    
}
