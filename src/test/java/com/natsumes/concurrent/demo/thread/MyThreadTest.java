package com.natsumes.concurrent.demo.thread;

import org.junit.Test;

public class MyThreadTest {
    @Test
    public void testJoin() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        new Thread(new MyRunnable()).start();

        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();

        System.out.println(Thread.currentThread().getName() + " end");
    }

    @Test
    public void testThread() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");

        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName() + " end");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start");

        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName() + " end");
    }
}