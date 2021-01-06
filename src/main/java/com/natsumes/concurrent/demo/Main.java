package com.natsumes.concurrent.demo;

import com.natsumes.concurrent.demo.thread.MyThread;

/**
 * @author hetengjiao
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");

        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();

        System.out.println(Thread.currentThread().getName() + " end");
    }
}
