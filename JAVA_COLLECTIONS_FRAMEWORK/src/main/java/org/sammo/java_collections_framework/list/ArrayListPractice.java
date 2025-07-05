package org.sammo.java_collections_framework.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPractice {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // both okay
        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(20);

        // java.util.ArrayList
//        System.out.println(list1.getClass().getName());
//        System.out.println(list2.getClass().getName());

        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }

//        Field field = ArrayList.class.getDeclaredField("elementData");
//        field.setAccessible(true);
//        Object[] elementData = (Object[]) field.get(list1);
//
//        System.out.println("INITIAL CAPACITY: " + elementData.length);
//        System.out.println("INITIAL SIZE: " + list1.size());
//
//        list1.add(10);
//        elementData = (Object[]) field.get(list1);
//
//        System.out.println("AFTERWARDS CAPACITY: " + elementData.length);
//        System.out.println("AFTERWARDS SIZE: " + list1.size());

/*
*
*
*
*
*
*
*
*
*
*
*
* */
        /*
        Arrays.asList() return an instance of java.util.Arrays.ArrayList, an internal class in the Arrays class.

        Backed by the original array — changes to the list affect the array and vice versa.
        Fixed size — you cannot add or remove elements (will throw UnsupportedOperationException).
        Allows element update — you can use set(index, value) to update elements. */

        List<Integer> list3 = Arrays.asList(1, 2, 3);
        Integer[] arr = new Integer[]{4, 5, 6};
        List<Integer> list4 = Arrays.asList(arr);

        // java.util.Arrays$ArrayList
//        System.out.println(list3.getClass().getName());
//        System.out.println(list4.getClass().getName());

//        list3.add(9); // throws exception

/*
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */
        /*
        ImmutableCollections$ListN is an internal class in Java used by the List.of() method introduced in Java 9 to
        create immutable lists.

        Immutable — You cannot add, remove, or modify elements.
        add(), remove(), set() all throw UnsupportedOperationException.
        Null elements are not allowed — List.of(null) throws NullPointerException.
        Fixed size and ordered — Maintains insertion order.
        Optimized for small lists — memory-efficient and fast. */

        List<Integer> list5 = List.of(1, 2, 3);

        // ImmutableCollections$ListN
//        System.out.println(list5.getClass().getName());

/*
*
*
*
*
*
*
*
*
*
*
* */

        /*
        you can pass the Arrays$ArrayList and ImmutableCollections$ListN objects in the constructor of ArrayList
        as both of them are Collections to make a new mutable list */

        ArrayList<Integer> list6 = new ArrayList<>(list3);
        ArrayList<Integer> list7 = new ArrayList<>(list5);

        /*
        passing a mutable and immutable list into mutable list

        list4 is from Arrays.asList() → fixed-size, backed by array but still allows get() and set().
        list5 is from List.of() → immutable, no modifications allowed. */

        list6.addAll(list4);
        list6.addAll(list5);
        System.out.println(list6);
    }
}
