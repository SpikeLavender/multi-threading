package com.natsumes.concurrent.demo.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class MyCallableTest {

    @Test
    public void testThread() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();

        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        // start thread, execute callable
        new Thread(futureTask).start();

        // wait callable return
        String result = futureTask.get();
        System.out.println(result);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, 5,
                1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        ) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                // if error, handle at this
                super.afterExecute(r, t);
                System.out.println("task execute end " + t);
            }
        };

        // start thread, execute callable
        Future<String> future = executor.submit(myCallable);

        // wait callable return
        String result = future.get();
        System.out.println(result);
        executor.shutdown();
    }
}