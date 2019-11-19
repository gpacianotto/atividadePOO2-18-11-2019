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
public class Demo {
    
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;
    
    static{
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }
    
    public static void main(String[] args) throws IOException {
        while(!order.isClosed()){
            int cost;
            
            String continueChoice;
            do{
                System.out.println("Please Select a product: ");
                System.out.println("1 - MotherBoard ");
                System.out.println("2 - CPU ");
                System.out.println("3 - HDD ");
                System.out.println("4 - Memory ");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.println("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.println("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            }while(continueChoice.equalsIgnoreCase("y"));
        }
        if(strategy == null){
            System.out.println("Please select a payment method: ");
            System.out.println("1 - Paypal");
            System.out.println("2 - Credit Card");
            String paymentMethod = reader.readLine();
            
            if(paymentMethod.equals("1")){
                strategy = new PayByPayPal();
            }
            else{
                strategy = new PayByCreditCard();
            }
            order.processOrder(strategy);
            
            System.out.println("Pay"+order.getTotalCost() + "units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            
            if(proceed.equalsIgnoreCase("P")){
                if(strategy.pay(order.getTotalCost())){
                    System.out.println("Payment has been successful");
                }
                else{
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
    
}
