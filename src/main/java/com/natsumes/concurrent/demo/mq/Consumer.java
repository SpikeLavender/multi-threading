package com.natsumes.concurrent.demo.mq;

import java.util.Random;

/**
 * @author hetengjiao
 */
public class Consumer extends Thread{

    private final MyQueue myQueue;

    private final Random rd = new Random();

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String s = myQueue.get();
            System.out.println("consumer: " + s);
            try {
                Thread.sleep(rd.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
