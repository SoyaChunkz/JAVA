package org.sammo.java_collections_framework.queue_deque;

import java.util.LinkedList;
import java.util.Queue;

public class LLasQueuePractice {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // ----------- add() and offer() -----------
        queue.add(10);       // throws exception if fails (usually never for LinkedList)
        queue.offer(20);     // returns false if fails
        queue.offer(30);

        System.out.println("Queue after add/offer: " + queue); // [10, 20, 30]

        // ----------- element() and peek() -----------
        System.out.println("element(): " + queue.element()); // 10 (head, throws exception if empty)
        System.out.println("peek(): " + queue.peek());       // 10 (head, returns null if empty)

        // ----------- remove() and poll() -----------
        System.out.println("remove(): " + queue.remove()); // removes 10 (throws exception if empty)
        System.out.println("poll(): " + queue.poll());     // removes 20 (returns null if empty)

        System.out.println("Queue after remove/poll: " + queue); // [30]

        // ----------- poll() on empty queue -----------
        queue.poll(); // removes 30
        System.out.println("poll() on empty queue: " + queue.poll()); // null

        // ----------- peek() on empty queue -----------
        System.out.println("peek() on empty queue: " + queue.peek()); // null

        // Uncommenting below will throw NoSuchElementException
        // System.out.println("remove() on empty queue: " + queue.remove());
        // System.out.println("element() on empty queue: " + queue.element());
    }
}
