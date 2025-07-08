package org.sammo.java_collections_framework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student {

    private int roll;

    private String name;

    public Student (int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode () {
        return Objects.hash(roll, name);
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return roll == student.getRoll() && Objects.equals(name, ((Student) obj).getName());
    }

    @Override
    public String toString () {
        return "Name: " + name + " → " + "roll: " + roll;
    }
}


public class HashMapPractice {

    public static void main(String[] args) {

//        HashMap<String, Integer> fruitStore = new HashMap<>(10, 0.8f);
//
//        fruitStore.put("Apple", 50); // add
//        fruitStore.put("Mango", 40);
//        fruitStore.put("Banana", 30);
//
//        fruitStore.put("Apple", 60); // overwrites 50
//
//        System.out.println("Apple price: " + fruitStore.get("Apple")); // 60
//
//        System.out.println("Contains Banana? " + fruitStore.containsKey("Banana")); // true
//        System.out.println("Contains price 40? " + fruitStore.containsValue(40));   // true
//
//        fruitStore.remove("Mango");
//
//        fruitStore.put("Guava", 20);
//
//        for (Map.Entry<String, Integer> entry : fruitStore.entrySet()) {
//            System.out.println(entry.getKey() + " → " + entry.getValue());
//        }
//        for (String key : fruitStore.keySet()) {
//            System.out.println(key);
//        }
//        for (Integer value : fruitStore.values()) {
//            System.out.println(value);
//        }

/*
*
*
*
*
*
*
*
* */

        Student s1 = new Student(63, "Sammo");
        Student s2 = new Student(1, "Alice");
        Student s3 = new Student(3, "Bob");
        Student s4 = new Student(63, "Sammo");

        HashMap<Student, String> studentMap = new HashMap<>();

        studentMap.put(s1, "DEV");        // hashcode1 --- index1
        studentMap.put(s2, "Analyst");    // hashcode2 --- index2
        studentMap.put(s3, "Manager");    // hashcode3 --- index3
//        studentMap.put(s4, "Boss");       // hashcode4 --- index4     (before overriding hashcode and equals method)
        studentMap.put(s4, "Boss");       // hashcode1 --- index1      (after overriding)

        for (Map.Entry<Student, String> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " ---→ " + entry.getValue());
        }

        /*
        In Java, when using a custom class (like Student) as a key in a HashMap, it's crucial to override the equals() and hashCode() methods.
        This ensures the map can correctly identify and retrieve values associated with logically equivalent keys.
        HashMap uses the hashCode() of the key to determine the bucket index.
        It then uses equals() to check if the key already exists in that bucket.
        If two objects are logically equal (same data), but you don’t override these methods, the map will treat them as different keys, leading to duplicate entries.*/

    }
}
