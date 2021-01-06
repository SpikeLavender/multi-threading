package com.natsumes.concurrent.demo.interrupt;

/**
 * @author hetengjiao
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
