package com.natsumes.concurrent.demo.interrupt;

/**
 * @author hetengjiao
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            boolean interrupted = isInterrupted();
            System.out.println("中断状态：" + interrupted);
        }
    }
}
