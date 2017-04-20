package com.example;

public class Stock {
    private String name;
    private int price;
    private int sharesAvailable;

    public Stock(String name, int price, int sharesAvailable) {
        this.name = name;
        this.price = price;
        this.sharesAvailable = sharesAvailable;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSharesAvailable() {
        return sharesAvailable;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sharesAvailable=" + sharesAvailable +
                '}';
    }
}
