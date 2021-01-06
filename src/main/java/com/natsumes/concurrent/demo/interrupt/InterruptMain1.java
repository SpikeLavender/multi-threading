package com.natsumes.concurrent.demo.interrupt;

/**
 * @author hetengjiao
 */
public class InterruptMain1 {

    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread = new MyThread1();
        myThread.start();
        Thread.sleep(30);
        //中断线程
        myThread.interrupt();
        Thread.sleep(100);

        System.exit(0);
    }
}
