package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private int num;

    public int getNum() {
        return num;
    }

    public PassengerThread(Semaphore semaphore, CountDownLatch countDownLatch, int num) {
        this.semaphore = semaphore;
        this.countDownLatch=countDownLatch;
        this.num=num;
    }

    @Override
    public synchronized void run() {
        try {
            semaphore.acquire();
            System.out.println( num + " bought a ticket");
            sleep(1000);
            System.out.println( num +" boarded the bus");
            semaphore.release();
            countDownLatch.countDown();
            countDownLatch.await();
            if ( getNum()==100){
                System.out.println("Bus went to Osh");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


}
}
