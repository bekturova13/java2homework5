package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static synchronized void  main(String[] args) throws InterruptedException {
        Semaphore cashBox = new Semaphore(4);
        CountDownLatch countDownLatch=new CountDownLatch(100);
        Thread thread=new Thread();
        for (int i = 1; i <= 100; i++) {
            PassengerThread Passenger = new PassengerThread(cashBox);
            Passenger.setName("Passenger" + i);
            Passenger.start();
            thread.join();
        }
        System.out.println("Bus went to Osh");
    }

}
