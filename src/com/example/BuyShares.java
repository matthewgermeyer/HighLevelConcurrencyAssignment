package com.example;

import java.util.concurrent.Callable;

public class BuyShares implements Callable<String>{
    private TraderService traderService;
    private String stockName;
    private int price;
    private int numSharesIWant;
    private String traderName;

    public BuyShares(TraderService traderService, String stockName, int price, int numSharesIWant, String traderName) {
        this.traderService = traderService;
        this.stockName = stockName;
        this.price = price;
        this.numSharesIWant = numSharesIWant;
        this.traderName = traderName;
    }

    @Override
    public String call() throws Exception {
        System.out.println("B");
        try {
            Trade trade = traderService.buyShares(traderName, stockName, numSharesIWant, price);
            if (trade == null){
                return "no trade occurred!";
            }
            //System.out.println(traderService);
        } catch (SharesException e) {
            return e.getMessage();
        }
        // System.out.println(traderService);

        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            //do nothing
        }
        //Bought #shares of Stock @ price
        return "Bought " + numSharesIWant + " shares of  "+ stockName + " at $" + price +  " !";
    }
}
