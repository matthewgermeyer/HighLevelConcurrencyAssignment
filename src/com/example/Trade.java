package com.example;

import java.time.LocalDateTime;

public class Trade extends Stock{
    private String trader;
    private LocalDateTime timeOfTrade;

    public Trade(String stockName, int price, int sharesPurchased, String trader, LocalDateTime timeOfTrade) {
        super(stockName, price, sharesPurchased);
        this.trader = trader;
        this.timeOfTrade = timeOfTrade;
    }

    public String getTrader() {
        return trader;
    }

    public LocalDateTime getTimeOfTrade() {
        return timeOfTrade;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "trader='" + trader + '\'' +
                ", timeOfTrade=" + timeOfTrade +
                '}';
    }
}
