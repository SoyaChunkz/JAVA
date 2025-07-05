package org.sammo.java_multithreading_pg.thread_communication;

class SharedResource {

    private int data;

    private boolean hasData;

    public synchronized void produce (int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println(Thread.currentThread().getName() + " PRODUCED: " + data);
        notifyAll();
    }

    public synchronized int consume () {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println(Thread.currentThread().getName() + " CONSUMED: " + data);
        notifyAll();
        return data;
    }
}

class Producer implements Runnable {

    private SharedResource resource;

    public Producer (SharedResource resource) {
        this.resource = resource;
    }
    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable {

    private SharedResource resource;

    public Consumer (SharedResource resource) {
        this.resource = resource;
    }
    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((int) (Math.random() * 100)); // <-- Add this small random delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            resource.consume();
        }
    }
}

public class ThreadCommunication {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(new Producer(sharedResource), "producer");
        Thread t2 = new Thread(new Consumer(sharedResource), "consumer1");
        Thread t3 = new Thread(new Consumer(sharedResource), "consumer2");

        t1.start();
        t2.start();
        t3.start();
    }
}
