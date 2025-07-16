package org.sammo.java_8.streams_api;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsPractice {

    public static void main(String[] args) {

        // -------------------------------------------------------------------------------------
        // 1. Collect to List
        // -------------------------------------------------------------------------------------
        List<String> namesList = Stream.of("sammo", "alice", "bob", "mark").toList();
        System.out.println("toList: " + namesList);

        // -------------------------------------------------------------------------------------
        // 2. Collect to Set (removes duplicates)
        // -------------------------------------------------------------------------------------
        Set<Integer> numSet = Stream.of(1, 1, 2, 2, 3, 3, 4, 5)
                .collect(Collectors.toSet());
        System.out.println("toSet: " + numSet);

        // -------------------------------------------------------------------------------------
        // 3. Collect to Specific Collection (like ArrayDeque)
        // -------------------------------------------------------------------------------------
        ArrayDeque<String> arrayDequeNames = namesList.stream()
                .map(String::toUpperCase)
//                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println("toCollection (ArrayDeque): " + arrayDequeNames);


        // -------------------------------------------------------------------------------------
        // 4. toMap() variations
        // -------------------------------------------------------------------------------------

        // (a) Basic: toMap(keyMapper, valueMapper)
        Map<String, Integer> basicMap = Stream.of("java", "python", "c")
                .collect(Collectors.toMap(
                        s -> s,         // key
                        String::length) // value
                );
        System.out.println("toMap basic: " + basicMap);

        // (b) Handling duplicates: toMap(keyMapper, valueMapper, mergeFunction)
        Map<String, Integer> mergeMap = Stream.of("java", "c", "cpp", "java", "cpp", "rust", "java")
                .collect(Collectors.toMap(
                        (str) -> str, // key
                        (v) -> 1,     // value
//                        (oldV, v) -> oldV + v
                        Integer::sum  // merge duplicates
                ));
        System.out.println("toMap with merge: " + mergeMap);

        // (c) With custom Map: toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)
        Map<String, Integer> sortedMap  = Stream.of("java", "c", "java", "python", "c")
                .collect(Collectors.toMap(
                        s -> s,
                        s -> 1,
                        Integer::sum,
                        (Supplier<Map<String, Integer>>) () -> new TreeMap<>(Comparator.reverseOrder())  // creates a sorted TreeMap
                ));
        System.out.println("toMap with TreeMap: " + sortedMap);

        // -------------------------------------------------------------------------------------
        // 5. joining() – Combine strings
        // -------------------------------------------------------------------------------------
        String joined = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.joining(" -> "));
        System.out.println("joining: " + joined);

        // -------------------------------------------------------------------------------------
        // 6. counting() – Count number of elements
        // -------------------------------------------------------------------------------------
        long count = Stream.of(1, 2, 3, 4).collect(Collectors.counting());
        System.out.println("counting: " + count);

        // -------------------------------------------------------------------------------------
        // 7. Numeric collectors: summarizingInt, averagingInt, summingInt
        // -------------------------------------------------------------------------------------
        IntSummaryStatistics stats = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("summarizingInt: " + stats);
        System.out.println("average: " + stats.getAverage());
        System.out.println("sum: " + stats.getSum());

        // -------------------------------------------------------------------------------------
        // 8. groupingBy() – Group by classifier (string length)
        // -------------------------------------------------------------------------------------
        Map<Integer, List<String>> groupedByLength = Stream.of("sam", "alex", "bob", "john")
                .collect(Collectors.groupingBy(String::length));
        System.out.println("groupingBy: " + groupedByLength);

        // Grouping with downstream collector: count names of same length
        Map<Integer, Long> groupedAndCounted = Stream.of("sam", "alex", "bob", "john", "adam")
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("groupingBy + counting: " + groupedAndCounted);

        // -------------------------------------------------------------------------------------
        // 9. partitioningBy() – true/false grouping
        // -------------------------------------------------------------------------------------
        Map<Boolean, List<Integer>> evenOddPartition = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("partitioningBy: " + evenOddPartition);

        // -------------------------------------------------------------------------------------
        // 10. reducing() – Custom reduction logic
        // -------------------------------------------------------------------------------------
        int product = Stream.of(1, 2, 3, 4)
                .collect(Collectors.reducing(1, (a, b) -> a * b));
        System.out.println("reducing (product): " + product);
    }

}
