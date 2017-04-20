package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraderServiceImpl implements TraderService {

    private Map<String, Stock> stocks = new HashMap<>();
    private List<Trade> trades = new ArrayList<>();

    public synchronized void addShares(String stockName, int numShares, int price) {
        Stock stock = stocks.get(stockName);
        //if stock does not exist..
        if (stock == null) {
            //create the stock
            Stock stock1 = new Stock(stockName, price, numShares);
            //add it to the map 'stocks'
            stocks.put(stockName, stock1);
        } else {
            // increment number of shares for the stock
            int newNumofShares = numShares + stock.getSharesAvailable();
            Stock stock1 = new Stock(stockName, price, newNumofShares);
            stocks.put(stockName, stock1);
        }

    }

    @Override
    public synchronized Stock getStock(String stockName) {
        return stocks.get(stockName);
    }

    @Override
    public Trade buyShares (String traderName, String stockName, int numSharesToBuy, int price) throws SharesException {
        Stock stock = stocks.get(stockName);

        //If stock name is invalid.
        if (stock == null){
            throw new SharesException("that stock does not exist!  ");
        }
        // If purchase is too big for available numSharesAvailable throw...
        if (numSharesToBuy > stock.getSharesAvailable()){
            throw new SharesException("I dont have enough shares, wanted " + numSharesToBuy + " but only had " + stock.getSharesAvailable());
        }

        int remainingShares = stock.getSharesAvailable() - numSharesToBuy;
        Stock stock1 = new Stock(stockName, price, remainingShares);
        stocks.put(stockName, stock1);

        /*
        public Trade(String stockName, int price, int sharesPurchased, String trader, LocalDateTime timeOfTrade)
         */
        Trade trade = new Trade(stockName, price, numSharesToBuy, traderName, LocalDateTime.now());

        trades.add(trade);
        return trade;
    }

    @Override
    public void clearStocks() {
        stocks.clear();

    }

    @Override
    public List<Trade> getTrades() {
        return trades;
    }

    @Override
    public String toString() {
        return "TraderServiceImpl{" +
                "stocks=" + stocks +
                '}';
    }
}
