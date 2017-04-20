package com.example;

import java.util.List;

public interface TraderService {

    void addShares(String stockName, int numSharesToAdd, int price);
    Stock getStock(String stockName);
    Trade buyShares(String traderName, String stockName, int numSharesToBuy, int price) throws SharesException;
    void clearStocks();
    List<Trade> getTrades();
}
