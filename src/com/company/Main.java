package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {


    public static synchronized void  main(String[] args) throws InterruptedException {
        Semaphore cashBox = new Semaphore(4, true);
        CountDownLatch Bus= new CountDownLatch(100);

        for (int i = 1; i <= 100; i++) {
            PassengerThread Passenger = new PassengerThread(cashBox, Bus,i );
            Passenger.start();

        }

        }
    }


