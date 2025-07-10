package org.sammo.java_collections_framework.list;

import java.util.ArrayList;
import java.util.List;

class Person implements Comparable<Person> {

    private final String name;

    private final int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public int getId() {
        return id;
    }


    // natural ordering
    @Override
    public int compareTo(Person p) {
        return this.id - p.getId(); // asc
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

public class ComparablePractice {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Sammo", 1));
        people.add(new Person("Mark", 3));
        people.add(new Person("Alice", 2));
        people.add(new Person("Bob", 0));


        people.sort(null); // calls the comparable (natural ordering defined in compareTo)
        System.out.println("Comparable: " + people);

        people.sort((p1, p2) -> p2.getId() - p1.getId()); // we give the comparator for custom ordering
        System.out.println("Comparator: " + people);
    }
}
