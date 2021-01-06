package com.natsumes.concurrent.demo.thread;

import org.junit.Test;

public class MyRunnableTest {
    @Test
    public void testRunnable() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        new Thread(new MyRunnable()).start();

        System.out.println(Thread.currentThread().getName() + " end");
    }
}