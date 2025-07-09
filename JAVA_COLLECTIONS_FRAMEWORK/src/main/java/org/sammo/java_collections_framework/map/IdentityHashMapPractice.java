package org.sammo.java_collections_framework.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapPractice {

    public static void main(String[] args) {

        String key1 = new String("key");
        String key2 = new String("key");

        Map<String, Integer> map = new HashMap<>();

        map.put(key1, 1);
        map.put(key2, 2);

        /*
        the second put method updates the previous key as both of them are "key"

        HashMap uses the hashCode() and equals() methods of the key's class to determine uniqueness

        hashcode is the key's hashcode method in our case the String class' hashcode method which uses the
        string's content, so both keys will have the same hashcode and hence result to the same index in the internal array
        of the hashmap

        after matching hashcodes, HashMap uses equals() to check for key equality,
        String.equals() compares content, so both keys are treated as equal */

        System.out.println(map);

        Map<String, Integer> identityMap = new IdentityHashMap<>();

        identityMap.put(key1, 1);
        identityMap.put(key2, 2);

        /*
        the second put method won't update the previous key now

        IdentityHashMap uses reference equality (==) to compare keys, and uses System.identityHashCode()
        to compute the hash based on the object's memory address

        System.identityHashCode method uses the object's memory location, so both keys will have different
        hashcode and hence result to the different indices in the internal array of the Map

        reference equality (==) also uses the actual memory location of both keys, so it will be different */

        System.out.println(identityMap);

    }

}
