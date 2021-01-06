package com.natsumes.concurrent.demo.thread;

/**
 * @author hetengjiao
 */
public class MySyncClass {

    private final Object lock = new Object();

    public synchronized void method1() {
        // 实例方法的锁加在对象 mySyncClass 上
    }


    public static synchronized void method2() {
        // 静态方法的锁加在 MySyncClass.class 上
    }

    public void method3() {
        synchronized (this) {
            // equals method1
        }
    }

    public static void method4() {
        synchronized (MySyncClass.class) {
            // equals method2
        }
    }

    public void method5() {
        synchronized (lock) {
            // equals method2
        }
    }
}
