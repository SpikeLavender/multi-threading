package com.natsumes.concurrent.demo.mq;

/**
 * @author hetengjiao
 */
public class MyQueue {

    // private final Object lock = new Object();

    private final String[] data = new String[10];

    /**
     * 下一条记录的下标
     */
    private int putIndex = 0;

    /**
     * 下一条要获取的元素的下标
     */
    private int getIndex = 0;

    /**
     * data中的元素个数
     */
    private int size = 0;

    public synchronized void put(String element) {
        if (size == data.length) {
            try {
                // blocking, wait
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            put(element);
        } else {
            put0(element);
            notify();
        }
    }

    private void put0(String element) {
        data[putIndex++] = element;
        size++;
        if (putIndex == data.length) {
            putIndex = 0;
        }
    }

    public synchronized String get() {
        if (size == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return get();
        } else {
            String result = get0();
            notify();
            return result;
        }
    }

    private String get0() {
        String result = this.data[getIndex++];
        if (getIndex == data.length) {
            getIndex = 0;
        }
        size--;
        return result;
    }

}
