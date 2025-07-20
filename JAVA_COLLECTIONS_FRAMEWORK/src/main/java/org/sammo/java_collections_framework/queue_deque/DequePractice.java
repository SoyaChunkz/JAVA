package org.sammo.java_collections_framework.queue_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequePractice {

    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();

        // Add elements at both ends
        deque.addFirst("first");       // front
        deque.addLast("last");         // rear

        // Offer methods (return boolean instead of throwing exception)
        deque.offerFirst("new-first");
        deque.offerLast("new-last");

        // Peek methods (view without removing)
        System.out.println("Peek First: " + deque.peekFirst());  // new-first
        System.out.println("Peek Last: " + deque.peekLast());    // new-last

        // Poll methods (remove and return, or return null if empty)
        System.out.println("Poll First: " + deque.pollFirst());  // new-first
        System.out.println("Poll Last: " + deque.pollLast());    // new-last

        // Push/Pop for stack-like behavior
        deque.push("pushed");
        System.out.println("Popped: " + deque.pop());            // pushed

        // Remove methods (remove and throw exception if empty)
        deque.add("middle");
        System.out.println("Remove First: " + deque.removeFirst());  // middle

        // Remaining elements
        System.out.println("Final deque: " + deque);

        /*
        Both ArrayDeque and LinkedList implement the Deque interface and support insertion/removal from
        both ends. However:

        ArrayDeque is generally faster for most Deque operations because it uses a resizable array internally.
        It has better cache locality and lower memory overhead, making it more efficient unless you need
        frequent middle insertions/removals (which it doesn’t support well).

        LinkedList uses a doubly linked list internally, which allows constant-time insertions/removals at
        both ends, but has higher memory cost (due to node objects and pointers) and can be slower due to
        less efficient memory access.
         */

        /*
        ArrayDeque in Java is implemented using a resizable circular array. This means elements are stored
        in a fixed-size array that wraps around when it reaches the end, allowing constant-time insertions
        and removals from both ends. It uses two pointers (head and tail) to track the start and end of the
        deque. When the array becomes full, it dynamically resizes (typically doubles its capacity) and
        repositions the elements. This circular structure ensures efficient memory usage and fast operations,
        making ArrayDeque a preferred alternative to LinkedList for stack or queue implementations. However,
        it does not allow null elements, as null is used internally to indicate empty slots.
         */
    }
}
