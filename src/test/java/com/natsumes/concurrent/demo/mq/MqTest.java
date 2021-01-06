package com.natsumes.concurrent.demo.mq;


import org.junit.Test;

public class MqTest {

    @Test
    public void test() throws Exception {
        MyQueue myQueue = new MyQueue();
        new Producer(myQueue).start();
        new Consumer(myQueue).start();

        Thread.sleep(10000);
    }

    @Test
    public void test2() throws Exception {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 5; i++) {
            new Producer(myQueue).start();
            new Consumer(myQueue).start();
        }

        Thread.sleep(10000);
    }
}