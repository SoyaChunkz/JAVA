package org.sammo.java_collections_framework.map;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapPractice {

    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
//        SortedMap<Integer, String> sortedMap = new TreeMap<>((i1, i2) -> i2 - i1);

        sortedMap.put(3, "Three");
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");

//        System.out.println(sortedMap);
//        System.out.println(sortedMap.firstKey());      // 1
//        System.out.println(sortedMap.lastKey());       // 3
//        System.out.println(sortedMap.headMap(3));      // {1=One, 2=Two}
//        System.out.println(sortedMap.tailMap(2));      // {2=Two, 3=Three}
//        System.out.println(sortedMap.subMap(1, 3));    // {1=One, 2=Two}

/*
*
*
*
*
*
* */

        NavigableMap<Integer, String> navigableMap = new TreeMap<>();

        navigableMap.put(10, "Ten");
        navigableMap.put(20, "Twenty");
        navigableMap.put(30, "Thirty");
        navigableMap.put(40, "Forty");

        System.out.println(navigableMap.lowerKey(25));      // 20
        System.out.println(navigableMap.floorKey(20));      // 20
        System.out.println(navigableMap.ceilingKey(25));    // 30
        System.out.println(navigableMap.higherKey(30));     // 40
        System.out.println(navigableMap.descendingMap());   // {40=Forty, 30=Thirty, 20=Twenty, 10=Ten}
        System.out.println(navigableMap.subMap(15, true, 35, false)); // {20=Twenty, 30=Thirty}

        /*
        When the reference type is SortedMap or NavigableMap but the object type is TreeMap,
        only the methods available in the reference type can be accessed at compile-time—even though
        TreeMap supports more; so using a NavigableMap reference allows access to more navigation methods
        (like lowerKey(), ceilingKey()), while a SortedMap reference restricts you to only sorted map methods
        (like subMap(), firstKey(), etc.).

        If you make the reference type TreeMap, then you can access all methods from:
        Map, SortedMap, NavigableMap and the methods defined in TreeMap itself
        This gives you full access to the entire functionality of TreeMap, including navigation
        (lowerKey, ceilingEntry, descendingMap, etc.) and sorting (firstKey, subMap, etc.). */
    }
}
