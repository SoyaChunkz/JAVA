package org.sammo.java_collections_framework.queue_deque.blocking_queue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueuePractice {

    public static void main(String[] args) {

        SynchronousQueue<String> queue = new SynchronousQueue<>();

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                String[] items = {"One", "Two", "Three"};
                for (String item : items) {
                    System.out.println("Producer: Trying to put " + item);
                    queue.put(item); // blocks until a consumer takes it
                    System.out.println("Producer: Put " + item);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(1000); // simulate delay
                    String item = queue.take(); // blocks until a producer puts
                    System.out.println("Consumer: Took " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
