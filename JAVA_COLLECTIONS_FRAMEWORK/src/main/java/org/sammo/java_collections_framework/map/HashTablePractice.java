package org.sammo.java_collections_framework.map;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTablePractice {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                hashMap.put(i, "Thread1");
                hashtable.put(i, "Thread1");
            }
        }, "Thread1");

        Thread t2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                hashMap.put(i, "Thread2");
                hashtable.put(i, "Thread2");
            }
        }, "Thread2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("HashMap size: " + hashMap.size());
        System.out.println("HashTable size: " + hashtable.size());

        System.out.println("HashMap:" + hashMap);
        System.out.println("HashTable: " + hashtable);
    }
}
