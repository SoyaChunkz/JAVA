package org.sammo.java_collections_framework.queue_deque.non_blocking_queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueuePractice {

    public static void main(String[] args) {

        Queue<String> queue = new ConcurrentLinkedQueue<>();

        // Producer Threads
        Runnable producer = () -> {
            for (int i = 1; i <= 3; i++) {
                String item = Thread.currentThread().getName() + "-Item" + i;
                queue.offer(item);
                System.out.println("Produced: " + item);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        };

        // Consumer Thread
        Runnable consumer = () -> {
            while (true) {
                String item = queue.poll(); // non-blocking
                if (item != null) {
                    System.out.println("Consumed: " + item);
                }
                try { Thread.sleep(150); } catch (InterruptedException ignored) {}
            }
        };

        // Start 2 producers and 1 consumer
        Thread p1 = new Thread(producer, "P1");
        Thread p2 = new Thread(producer, "P2");
        Thread c = new Thread(consumer, "C1");

        p1.start();
        p2.start();
        c.start();

        try {
            p1.join();
            p2.join();
            c.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
