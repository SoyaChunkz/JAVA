package org.sammo.java_collections_framework.map;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

class Phone {

    private String name;

    private String model;

    public Phone(String name, String model) {
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

class GC {
    public static void main(String[] args) {

        /*
        STRONG REFERENCE
        redmi is a strong reference, so the object it points to will never be garbage collected
        as long as redmi is reachable. */
        Phone redmi = new Phone("Redmi", "Note 7 Pro");

        /*
        WEAK REFERENCE
        moto is a weak reference. The object it points to is eligible for garbage collection
        immediately if no strong references to it exist.
        You're creating a new object and passing it directly to a weak reference,
        making it eligible for GC immediately after that line (assuming no other strong refs exist).*/
        WeakReference<Phone> moto = new WeakReference<>(new Phone("Moto", "E13"));

        System.out.print("BEFORE: ");
        System.out.print(redmi + " ----- ");
        System.out.println(moto.get());

        // Suggests the JVM to perform GC (may or may not run immediately)
        System.gc();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print("AFTER: ");
        System.out.print(redmi +  " ----- ");
        System.out.println(moto.get()); // likely null if GC ranf
    }
}

public class WeakHashMapPractice {

    public static void main(String[] args) {

        WeakHashMap<String, Phone> phoneCache = new WeakHashMap<>();

        /*
        "key1" and "key2" are string literals, and they are stored in the StringPool,
        they are strong referenced throughout the entire lifecycle of the program
        phoneCache.put("key1", new Phone("iPhone", "16"));
        phoneCache.put("key2", new Phone("iPhone", "16")); */

        /*
        passing a weak reference like this will help the JVM to clear the keys as we are using a WeakHashMap */
        phoneCache.put(new String("key1"), new Phone("iPhone", "16"));
        phoneCache.put(new String("key2"), new Phone("Samsung", "S24"));

        System.out.println("BEFORE: " + phoneCache);

        System.gc();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("AFTER: " + phoneCache);

        /*
        WeakHashMap uses weak references for its keys.
        If a key is no longer strongly referenced elsewhere, it becomes eligible for garbage collection,
        and the entry is removed from the map.
        We are intentionally avoiding string literals like "key1" by using new String("key1") to ensure the
        key isn’t in the String Pool (which would make it strongly referenced). */
    }

}
