package org.sammo.java_multithreading_pg.read_write_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public void increment () {
        writeLock.lock();
        try {
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount () {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main (String[] args) throws InterruptedException {

        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            }
        };


        Thread writerThread1 = new Thread(writeTask, "WRITER-1");
        Thread readerThread1 = new Thread(readTask, "READER-1");
        Thread readerThread2 = new Thread(readTask, "READER-2");

        writerThread1.start();
        readerThread1.start();
        readerThread2.start();

        writerThread1.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println(Thread.currentThread().getName() + " - " + counter.getCount());
    }
}
