package org.sammo.java_collections_framework.list;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

class Node {

    private int data;

    Node next;

    public Node (int data) {
        this.data = data;
    }

    public int getData () {
        return data;
    }
}

public class LinkedListPractice {

    private static void printLL (Node head) {

        Node pointer = head;

        while (pointer != null) {
            System.out.print(pointer.getData() + " -> ");
            pointer = pointer.next;
        }

        System.out.print("null");
    }

    public static void main(String[] args) {

        // singly LL
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

//        printLL(node1);

/*
*
*
*
*
*
*
*
* */

        // doubly LL
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3,4));
        System.out.println(linkedList);

        linkedList.add(5);                  // O(1) - add at end
        linkedList.addFirst(0);          // O(1) - add at beginning
        linkedList.addLast(6);           // O(1) - add at end (same as add())

        linkedList.add(2, 99);      // O(n) - add at index

        linkedList.remove();               // O(1) - remove first
        linkedList.removeFirst();          // O(1) - remove first
        linkedList.removeLast();           // O(1) - remove last

        linkedList.remove(Integer.valueOf(3)); // O(n) - remove by value

        linkedList.get(2);                 // O(n) - get by index
        linkedList.set(2, 88);             // O(n) - update by index

        linkedList.contains(99);           // O(n) - search
        linkedList.indexOf(99);            // O(n) - find index of element

        linkedList.peek();                 // O(1) - get first without removing
        linkedList.peekFirst();            // O(1)
        linkedList.peekLast();             // O(1)

        linkedList.poll();                 // O(1) - remove and return first
        linkedList.pollFirst();            // O(1)
        linkedList.pollLast();             // O(1)

        linkedList.push(111);           // O(1) - add to front (stack style)
        linkedList.pop();                  // O(1) - remove from front (stack style)

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Dog", "Cat", "Lion"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Sher"));

        animals.removeAll(animalsToRemove);
        System.out.println(animals);

    }
}
