package org.sammo.java_8.streams_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsPractice {

    /*
    In Java Streams, intermediate operations are the steps in the middle of a stream pipeline that transform
    or filter the data without producing a final result immediately. These operations are lazy, meaning they
    are not executed until a terminal operation is called. Each intermediate operation returns a new stream,
    allowing you to chain multiple operations together in a fluent and readable way. */

    public static void main(String[] args) {

        /*
        1. filter(Predicate)
        The filter() method is used to select elements that match a given condition.
        It takes a Predicate and returns a stream with only those elements that satisfy it. */
        List<String> names = List.of("sammo", "alex", "bob", "pam");
        names.stream()
                .filter((name) -> name.length() > 3)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");

        /*
        2. map(Function)
        The map() method is used to transform each element in the stream.
        It takes a function and applies it to every element, returning a new stream of the results. */
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");

        /*
        3. flatMap(Function)
        flatMap() is used to flatten nested structures.
        It maps each element to a stream and then flattens all the resulting streams into a single stream. */
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        listOfLists.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        listOfLists.add(new ArrayList<>(Arrays.asList(7, 8)));
        listOfLists.add(new ArrayList<>(List.of(9)));

        listOfLists.stream()
                .flatMap((list) -> {
                    Stream<Integer> intermediateStream = list.stream();
                    System.out.println();
                    System.out.print(intermediateStream.toList() + " → ");
                    return list.stream();
                })
                .forEach(System.out::print);
        System.out.println();
        /*
        First flatMap() takes [1, 2, 3], converts it into a stream → 1 2 3.
        These elements are immediately passed into forEach(), which consumes them and prints them.
        Then flatMap() moves to the next list [4, 5, 6], creates a stream → 4 5 6.
        Again, forEach() consumes and prints them.*/
        System.out.println("----------------------------------------------------------------");

        /*
        4. distinct()
        Removes duplicate elements from the stream.
        It uses equals() to check for uniqueness. */
        List<Integer> nums = List.of(1, 2, 2, 2, 3, 3);
        nums.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");

        /*
        5. sorted()
        Sorts the elements in natural order (for numbers, strings, etc.).
        You can also provide a custom comparator. */
        List<Integer> numbers = List.of(5, 2, 6, 1, 0, 8);
        numbers.stream()
                .sorted()
                .forEach(System.out::print);
        System.out.println();
        numbers.stream()
                .sorted((i1, i2) -> i2 - i1)
                .forEach(System.out::print);
        System.out.println();
        System.out.println("----------------------------------------------------------------");

        /*
        6. limit(n)
        Limits the number of elements in the stream to the first n. */
        Stream.of(1, 2, 3, 4, 5, 6)
                .limit(4)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");

        /*
        7. skip(n)
        Skips the first n elements and processes the rest. */
        Stream.of(1, 2, 3, 4, 5, 6)
                .skip(2)
                .map((num) -> Math.pow(num, 2))
                .mapToInt(Double::intValue)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");

        /*
        8. peek(Consumer)
        Used for debugging or inspecting elements in the pipeline without modifying them.
        It’s like a "sneak peek" inside the stream. */
        Stream.of("sam", "alex", "bob", "tate")
                .filter(name -> name.length() < 4)
                .peek(name -> System.out.println("After filter: " + name))
                .map(String::toUpperCase)
                .peek(name -> System.out.println("After map: " + name))
                .forEach(System.out::println);
    }
}
