package org.sammo.java_collections_framework.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorPractice {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>(5, 3);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

//        System.out.println(vector + " " + "CAPACITY: " + vector.capacity());

        vector.add(6);
//        System.out.println(vector + " " + "CAPACITY: " + vector.capacity());

/*
*
*
*
*
*
*
*
* */

        ArrayList<Integer> unsafe = new ArrayList<>();
        Vector<Integer> safe = new Vector<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafe.add(i);
                safe.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafe.add(i);
                safe.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ArrayList: " + unsafe.size());
        System.out.println("Vector: " + safe.size());
    }
}
