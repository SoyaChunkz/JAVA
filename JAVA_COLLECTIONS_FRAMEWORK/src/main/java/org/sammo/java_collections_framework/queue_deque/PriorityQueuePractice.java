package org.sammo.java_collections_framework.queue_deque;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePractice {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(40);
        pq.offer(10);
        pq.add(30);
        pq.offer(20);

        System.out.println("PriorityQueue: " + pq); // Unpredictable order, but heap structure maintained

        // Peek at the head (smallest)
        System.out.println("Peek (head): " + pq.peek()); // 10

        // Remove the head
        System.out.println("Poll (remove head): " + pq.poll()); // 10
        System.out.println("After poll: " + pq); // Head becomes 20

        // Remove specific element
        pq.remove(30); // removes 30

        // Check if it contains an element
        System.out.println("Contains 20? " + pq.contains(20));

        // Size of queue
        System.out.println("Size: " + pq.size());

        // Clear all elements
        pq.clear();
        System.out.println("Empty? " + pq.isEmpty());

        /*
        Internal Data Structure
        Internally uses a resizable array: Object[] queue.
        Maintains the heap invariant: for every node at index i, its children at 2i + 1 and 2i + 2 must be
        greater than or equal to queue[i] (in a min-heap).
        Elements are ordered either by:
            Their natural ordering (e.g., numbers, strings), via Comparable
            Or a custom Comparator if provided in constructor

        Insertion (add() / offer())
        Element is appended at the end of the internal array.
        It then "bubbles up" (heapify-up) to its correct position by comparing with its parent.
        Time complexity: O(log n)

        Removal (poll() / remove())
        The root (smallest) element is removed.
        The last element in the array is moved to the root.
        It then "bubbles down" (heapify-down) to its correct position by comparing with children.
        Time complexity: O(log n)

*/
    }
}
