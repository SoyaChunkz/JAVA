package org.sammo.java_collections_framework.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapPractice {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            map.put(i, "Value: " + i);
        }
        Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(map);

        // unmodifiableMap.put(6, "Value: 6"); // gives UnsupportedOperationException
        System.out.println(unmodifiableMap);

        map.put(6, "Value: 6");

        System.out.println(map);
        System.out.println(unmodifiableMap);

        /*
        When you create an unmodifiable map using Collections.unmodifiableMap(), it does not make a deep copy
        of the original map. Instead, it provides a read-only view of the same underlying map.
        So You can't modify the map through the unmodifiable reference
        But if the original (backing) map is modified elsewhere, those changes will reflect in the
        unmodifiable map.

        To overcome the issue of modifications reflecting in unmodifiable views,
        we use Map.of(...) (Java 9+) or Map.copyOf(...) (Java 10+) to create truly immutable maps. */

        Map<Integer, String> trueImmutableMap = Map.of(1, "One", 2, "Two", 3, "Three");

        System.out.println(trueImmutableMap);
    }
}
