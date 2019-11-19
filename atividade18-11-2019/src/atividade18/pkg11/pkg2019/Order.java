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
public class Order {
    
    private int totalCost = 0;
    private boolean isClosed = false;
    
    public void processOrder(PayStrategy strategy){
        strategy.collectPaymentDetails();
        //aqui é possivel coletar e armazenar dados de pagamento da estrategia
    }
    public void setTotalCost(int cost){
        this.totalCost += cost;
    }
    public int getTotalCost(){
        return totalCost;
    }
    public boolean isClosed(){
        return isClosed;
    }
    public void setClosed(){
        isClosed = true;
    }
    
}
