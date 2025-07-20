package org.sammo.java_collections_framework.queue_deque.non_blocking_queue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequePractice {

    public static void main(String[] args) {

        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

        // Producer
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                deque.offerFirst("First-" + i);
                deque.offerLast("Last-" + i);
                System.out.println("Added: First-" + i + " & Last-" + i);
                System.out.println(deque);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        }).start();

        // Consumer
        new Thread(() -> {
            while (true) {
                String item1 = deque.pollFirst(); // OR pollLast()
                if (item1 != null)
                    System.out.println("Consumed: " + item1);
                try { Thread.sleep(150); } catch (InterruptedException ignored) {}
            }
        }).start();
    }
}
