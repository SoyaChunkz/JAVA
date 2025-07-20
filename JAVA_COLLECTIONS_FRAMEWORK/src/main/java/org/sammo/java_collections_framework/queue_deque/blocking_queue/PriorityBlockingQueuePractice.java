package org.sammo.java_collections_framework.queue_deque.blocking_queue;

import java.util.concurrent.PriorityBlockingQueue;

class Task implements Comparable<Task> {

    private final int priority;
    private final String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Task other) {
        // Lower priority number = higher priority
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + '}';
    }
}

public class PriorityBlockingQueuePractice {

    public static void main(String[] args) {

        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        // Producer
        Thread producer = new Thread(() -> {
            try {
                queue.put(new Task(3, "Low Priority Task"));
                Thread.sleep(300);
                queue.put(new Task(1, "High Priority Task"));
                Thread.sleep(300);
                queue.put(new Task(2, "Medium Priority Task"));

                System.out.println(queue);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Delay to let producer fill the queue
                while (!queue.isEmpty()) {
                    Task task = queue.take(); // Takes highest-priority available
                    System.out.println("Consumed: " + task);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
