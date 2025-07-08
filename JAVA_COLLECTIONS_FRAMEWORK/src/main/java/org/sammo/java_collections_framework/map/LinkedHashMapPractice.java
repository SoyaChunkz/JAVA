package org.sammo.java_collections_framework.map;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCache (int capacity) {
        super(capacity, 0.75f, true );
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class LinkedHashMapPractice {

    public static void main(String[] args) {

//        LinkedHashMap<String, Integer> students = new LinkedHashMap<>(10, 0.5f, false); // false means read order is maintained
        LinkedHashMap<String, Integer> students = new LinkedHashMap<>(10, 0.5f, true); // true means access order is maintained

        students.put("Alice", 1);
        students.put("Bob", 2);
        students.put("Cody", 3);
        students.put("Mark", 4);

        students.get("Alice");

//        System.out.println(students);

        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("One", 1);
        lruCache.put("Two", 2);
        lruCache.put("Three", 3);

        lruCache.put("Four", 4); // the put method calls the overriden method and LRU key is removed

        lruCache.get("Two"); // this puts "Two" on the last position

        System.out.println(lruCache);

    }

}
