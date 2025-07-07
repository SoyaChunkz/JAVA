package org.sammo.java_collections_framework.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StackPractice {

    public static void main(String[] args) {

//        Stack<Integer> stack = new Stack<>();
//        stack.push(10); // add to top
//        stack.push(20);
//        stack.push(30);
//
//        System.out.println("Top element (peek): " + stack.peek()); // 30
//        System.out.println("Removed element (pop): " + stack.pop()); // 30
//        System.out.println("Is stack empty? " + stack.empty()); // false
//        System.out.println("Search 10: " + stack.search(10)); // 2 (1-based)
//        System.out.println("Stack: " + stack); // [10, 20]

/*
 *
 *
 *
 *
 * */
        LinkedList<Integer> linkedListAsStack = new LinkedList<>();

        linkedListAsStack.addLast(1); // push
        linkedListAsStack.addLast(2);
        linkedListAsStack.addLast(3);

        linkedListAsStack.removeLast(); // pop
        linkedListAsStack.getLast();    // peek

/*
 *
 *
 *
 *
 * */
        ArrayList<Integer> arrayListAsStack = new ArrayList<>();

        arrayListAsStack.add(1); // push
        arrayListAsStack.add(2);
        arrayListAsStack.add(3);

        arrayListAsStack.remove(arrayListAsStack.size() - 1); // pop
        arrayListAsStack.get(arrayListAsStack.size() - 1);          // peek
    }
}
