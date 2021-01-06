package com.natsumes.concurrent.demo.mq;

import java.util.Random;

/**
 * @author hetengjiao
 */
public class Producer extends Thread {

    private final MyQueue myQueue;

    private int index = 0;

    private final Random rd = new Random();

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String tmp = "生产者: " + index;
            myQueue.put(tmp);
            System.out.println(tmp);
            index++;
            try {
                Thread.sleep(rd.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
