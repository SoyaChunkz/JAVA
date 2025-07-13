package org.sammo.java_8.streams_api;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsPractice {

    /*
    In Java Streams, terminal operations are the final step in a stream pipeline. They trigger the processing
    of the stream and consume it — meaning once a terminal operation is called, the stream cannot be reused.
    Terminal operations either produce a result, a side effect, or both. They are essential because
    intermediate operations (like map, filter, etc.) are lazy and won’t execute until a terminal operation
    is invoked. */

    public static void main(String[] args) {

        /*
        1. collect()
        Gathers the elements into a collection (like List, Set, Map, etc.). */
        List<Integer> list1 = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(1, 2, 3, 4).toList();
        System.out.println("----------------------------------------------------------------");

        /*
        2. forEach()
        Performs an action (usually a side effect like printing) on each element. */
        Stream.of("a", "b", "c")
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");

        /*
        3. toArray()
        Converts the stream into an array. */
        String[] capsNames = Stream.of("sammo", "bob", "alice")
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.stream(capsNames).toList());
        System.out.println("----------------------------------------------------------------");

        /*
        4. reduce()
        Reduces the stream to a single value using a binary operator (like sum, concat, etc.). */
//        Optional<Integer> sum = Stream.of(1, 2, 3, 4, 5).reduce((a, b) -> a + b);
        Optional<Integer> sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(Integer::sum);
        System.out.println(sum.get());
        System.out.println("----------------------------------------------------------------");


        /*
        5. count()
        Returns the total number of elements in the stream. */
        long count = Stream.of(1, 2, 3).count();
        System.out.println(count);
        System.out.println("----------------------------------------------------------------");

        /*
        6. min() / max()
        Finds the minimum or maximum element using a comparator. */
        Optional<Integer> min = Stream.of(1, 2, 3, 4).min(Integer::compare);
        Optional<Integer> max = Stream.of(1, 2, 3, 4).max(Integer::compare);
        System.out.println(min.get());
        System.out.println(max.get());
        System.out.println("----------------------------------------------------------------");

        /*
        7. anyMatch()
        Returns true if any element matches the given predicate. */
        boolean hasEven = Stream.of(1, 3, 5, 6)
                .anyMatch(n -> n % 2 == 0);
        System.out.println(hasEven);
        System.out.println("----------------------------------------------------------------");

        /*
        8. allMatch()
        Returns true only if all elements match the given predicate. */
        boolean allPositive = Stream.of(0, 1, 2, 3, 4)
                .allMatch(n -> n > 0);
        System.out.println(allPositive);
        System.out.println("----------------------------------------------------------------");

        /*
        9. noneMatch()
        Returns true only if no elements match the given predicate. */
        boolean noneNegative = Stream.of(-1, 1, 2, 3)
                .noneMatch(n -> n < 0);
        System.out.println(noneNegative);
        System.out.println("----------------------------------------------------------------");

        /*
        10. findFirst()
        Returns the first element of the stream, wrapped in Optional. */
        Optional<Integer> first = Stream.of(4, 5, 6)
                .findFirst();
        System.out.println(first.get());
        System.out.println("----------------------------------------------------------------");

        /*
        11. findAny()
        Returns any one element from the stream. Useful in parallel streams. */
        Optional<Integer> any = Stream.of(7, 8, 9)
                .findAny();
        System.out.println(any.get());
        System.out.println("----------------------------------------------------------------");

    }
}

class LazyEvaluationPractice {

    public static void main(String[] args) {

        // Creating a stream of strings with a filter operation.
        // This filter is an intermediate operation and won't execute immediately.
        Stream<String> stringStream = Stream.of("sammo", "alice", "bob")
                .filter((name) -> {
                    System.out.println("        Filtering: " + name);
                    return name.length() > 3;
                });

        // This line prints immediately because intermediate operations are lazy.
        // Nothing above (filtering) has actually happened yet.
        System.out.println("This will be printed before even if its written after intermediate operation");

        // Terminal operation (toList) triggers the execution of the stream pipeline.
        // Now the filter actually runs on each element.
        System.out.println("Filtering we begin now");
        List<String> list = stringStream.toList();

        // After the terminal operation, we can print the result.
        System.out.println("After terminal operation");
        System.out.println(list);

    }
}
