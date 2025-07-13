package org.sammo.java_8.streams_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationPractice {

    public static void main(String[] args) {

        /*
        You can create streams in Java from collections, arrays, values, infinite generators, or files,
        depending on your use case. */

        /*
        *
        */

        /*
        Most common and straightforward method is by calling .stream() on a collection like a List or Set.
        This creates a sequential stream and is perfect when you're working with in-memory data structures.
        If you want to process elements in parallel, you can use .parallelStream() instead, which splits the
        data into chunks and processes them concurrently. */
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<String> listStream = names.stream().collect(Collectors.toList());

        /*
         *
         */

        /*
        For arrays, you can use Arrays.stream(array) to convert an array into a stream. This is especially
        useful when working with primitive arrays like int[], where the stream returned is a specialized
        primitive stream like IntStream, LongStream, or DoubleStream. */
        Integer[] integerArray = {1, 2, 3, 4};
        Stream<Integer> arrayStream1 = Arrays.stream(integerArray);
        int[] intArray = {1, 2, 3, 4};
        IntStream arrayStream2 = Arrays.stream(intArray);

        /*
         *
         */

        /*
        When you want to create a stream from a fixed set of values, you can use Stream.of(). It’s concise
        and ideal for quick examples or short pipelines. Unlike .stream() from collections, Stream.of()
        doesn’t require a pre-defined data structure — it takes varargs directly. */
        Stream<String> fixedStream = Stream.of("Java", "Python", "C++");

        /*
         *
         */

        /*
        For infinite or custom sequences, Java provides Stream.iterate() and Stream.generate().
        Stream.iterate(seed, nextFunction) is useful when you want to produce a predictable, increasing
        (or changing) sequence like even numbers. Stream.generate(supplier) is helpful when you want random
        or repeated values (like generating UUIDs or timestamps). However, both must usually be limited
        using .limit(n) to avoid infinite processing. */
        Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(20);
        Stream<Double> randoms = Stream.generate(Math::random).limit(10);
    }
}
