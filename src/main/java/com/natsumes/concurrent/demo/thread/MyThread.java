package com.natsumes.concurrent.demo.thread;

/**
 * @author hetengjiao
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "-" + i + " thread running");
        }
    }
}
