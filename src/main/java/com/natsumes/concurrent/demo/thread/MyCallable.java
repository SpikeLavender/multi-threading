package com.natsumes.concurrent.demo.thread;

import java.util.concurrent.Callable;

/**
 * @author hetengjiao
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Call return value";
    }
}
