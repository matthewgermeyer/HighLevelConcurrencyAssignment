package com.example;

import java.util.concurrent.Callable;

public class AddShares implements Callable<String> {
    private TraderService traderService;
    private String name;
    private int price;
    private int numSharesToAdd;


    public AddShares(TraderService traderService, String name, int price, int numSharesToAdd) {
        this.traderService = traderService;
        this.name = name;
        this.price = price;
        this.numSharesToAdd = numSharesToAdd;
    }

    @Override
    public String call() throws Exception {
        System.out.println("A");
        traderService.addShares(name, numSharesToAdd, price);
        //System.out.println(traderService);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            //do nothing
        }
        //Added shares to purchase!
        return "Added " + numSharesToAdd + " shares at price " + price + " for stock "+ name + " !";
    }
}



