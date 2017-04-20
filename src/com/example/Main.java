package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    static ArrayList<String> stockNames = new ArrayList<>();
    static ArrayList<String> traderNames = new ArrayList<>();
    static final Random rando = new Random();

    static {
        stockNames.add("ABC");
        stockNames.add("IBM");
        stockNames.add("TIY");

        traderNames.add("Steve Johnson");
        traderNames.add("Abby Abberson");
        traderNames.add("Jared JoJo");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TraderService traderService = new TraderServiceImpl();
        List<Callable> callables = new ArrayList<>();

         for (int i = 0;i < 100; ++i){
            AddShares addShares =
                    new AddShares(traderService, stockNames.get(rando.nextInt(3)), rando.nextInt(150) + 1, rando.nextInt(49) + 1);
            BuyShares buyShares =
                    new BuyShares(traderService, stockNames.get(rando.nextInt(3)), rando.nextInt(150) + 1, rando.nextInt(49) + 1, traderNames.get(rando.nextInt(3)));
            GetShares getShares =
                    new GetShares(traderService, stockNames.get(rando.nextInt(3)));

            //Add the AddShares, BUyShares, GetShares to the callables list.
            callables.add(addShares);
            callables.add(buyShares);
            callables.add(getShares);
        }

        //new up AddShares, BuyShares, GetShares

        // Create an ExecutorService with a fixed thread pool of size 5.
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //create a List of Futures called futures.
        List<Future> futures = new ArrayList<>();

        // for every callable of class Callable in the list callables ..
        for (Callable callable : callables) {
            //Execute the threads using Executor submit.
            Future future = executorService.submit(callable);
            futures.add(future);
        }

        //Loop through the futures and sout the results.
        for (Future future : futures) {
            //fix this
            System.out.println(future.get());
        }

        executorService.shutdown();
        System.out.println(traderService.getTrades());
    }


}
