package com.example;

import java.util.concurrent.Callable;

public class GetShares implements Callable<String> {
    private String stockName;
    private TraderService traderService;



    public GetShares(TraderService traderService, String stockName) {
        this.stockName = stockName;
        this.traderService = traderService;
    }

    @Override
    public String call() throws Exception {
        System.out.println("G");
        Stock stock = traderService.getStock(stockName);
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            //do nothing
        }
        //Get #shares of Stock @ price
        return "Found "+ stock;
    }



}
