package org.sammo.java_collections_framework.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapPractice {

    public static void main(String[] args) {

        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "One");  // put
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println("Value for key 2: " + map.get(2)); // get

        map.replace(2, "Two Updated"); // replace

        map.putIfAbsent(4, "Four"); // put if absent

        map.remove(3); // remove

        map.remove(1, "One"); // remove if value matches too

        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key)); // won’t throw ConcurrentModificationException
        }

        /*
            Resizing              - Yes, doubles capacity
            Resize strategy       - Gradual, 1 bucket at a time
            Threads during resize - Each thread that accesses the map helps move one small part
                                    (bucket) at a time.
            Collision handling    - Linked List → Tree (if too many items) */
    }
}
