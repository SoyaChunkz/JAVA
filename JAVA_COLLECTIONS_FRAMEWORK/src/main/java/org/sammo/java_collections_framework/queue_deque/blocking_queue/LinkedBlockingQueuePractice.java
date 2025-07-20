package org.sammo.java_collections_framework.queue_deque.blocking_queue;

import java.util.concurrent.*;

public class LinkedBlockingQueuePractice {

    private static final int NUM_PRODUCERS = 2;
    private static final int NUM_CONSUMERS = 2;
    private static final int ITEMS_PER_PRODUCER = 5;
    private static final int POISON_PILL = -1;


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5); // bounded queue
        ExecutorService executor = Executors.newCachedThreadPool();

        // Producers
        for (int p = 1; p <= NUM_PRODUCERS; p++) {
            int producerId = p;
            executor.execute(() -> {
                try {
                    for (int i = 1; i <= ITEMS_PER_PRODUCER; i++) {
                        int item = producerId * 100 + i;
                        System.out.println("Producer-" + producerId + ": Putting " + item);
                        queue.put(item);
                        Thread.sleep(200);
                    }
                    // After producing, put one poison pill
                    queue.put(POISON_PILL);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Consumers
        for (int c = 1; c <= NUM_CONSUMERS; c++) {
            int consumerId = c;
            executor.execute(() -> {
                try {
                    while (true) {
                        int item = queue.take();
                        if (item == POISON_PILL) {
                            // Re-insert poison pill for other consumers
                            queue.put(POISON_PILL);
                            System.out.println("Consumer-" + consumerId + ": Received poison pill. Exiting.");
                            break;
                        }
                        System.out.println("Consumer-" + consumerId + ": Took " + item);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown executor after some delay to let all threads finish
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("All tasks completed. Program exiting.");

    }
}
