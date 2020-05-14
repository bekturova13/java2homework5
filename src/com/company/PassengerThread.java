package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public PassengerThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public synchronized void run() {
        try {
            semaphore.acquire();
            System.out.println( this.getName() + " bought a ticket");
            sleep(1000);
            semaphore.release();
            System.out.println(this.getName() + " boarded to bus");

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }


}
