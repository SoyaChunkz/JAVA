package org.sammo.java_collections_framework.queue_deque.blocking_queue;


import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueuePractice {

    // Custom Delayed Element
    static class DelayedTask implements Delayed {

        private final String taskName;
        private final long startTime;

        public DelayedTask(String taskName, long delayInSeconds) {
            this.taskName = taskName;
            this.startTime = System.currentTimeMillis() + delayInSeconds * 1000;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long delay = startTime - System.currentTimeMillis();
            return unit.convert(delay, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), other.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return taskName;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        // Producer thread
        new Thread(() -> {
            try {
                queue.put(new DelayedTask("Task-1 (3s)", 3));
                queue.put(new DelayedTask("Task-2 (1s)", 1));
                queue.put(new DelayedTask("Task-3 (5s)", 5));
                System.out.println("All tasks added to DelayQueue.");
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                while (true) {
                    DelayedTask task = queue.take(); // blocks until delay expires
                    System.out.println("Consumed: " + task + " at " + System.currentTimeMillis() / 1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
