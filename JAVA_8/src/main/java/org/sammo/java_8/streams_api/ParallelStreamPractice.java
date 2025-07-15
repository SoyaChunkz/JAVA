package org.sammo.java_8.streams_api;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamPractice {

    private static BigInteger factorial (int n) {

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {

    /*
        List<String> names = List.of("sammo", "alice", "bob", "john", "doe", "pam");

        List<String> list = names.parallelStream()
                .filter((name) -> {
                    System.out.println("Filtering: " + name + " | Thread: " + Thread.currentThread().getName());
                    return name.length() > 3;
                })
                .map((name) -> {
                    System.out.println("Mapping: " + name + " | Thread: " + Thread.currentThread().getName());
                    return name.toUpperCase();
                })
                .toList();

        System.out.println(names);
    */

        // *********************************************************************************************

/*
        List<Integer> nums = Stream.iterate(1, (x) -> x + 1)
                .limit(1500)
                .toList();

        long startTime = System.currentTimeMillis();
        List<BigInteger> sequentialFactorials = nums.stream()
                .map(ParallelStreamPractice::factorial)
                .toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken sequential stream: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        List<BigInteger> parallelFactorials = nums.parallelStream()
                .map(ParallelStreamPractice::factorial)
                .toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken parallel stream: " + (endTime - startTime) + " ms");

        System.out.println("First 10 Sequential Factorials: ");
        sequentialFactorials.stream().limit(10).forEach(System.out::println);

        System.out.println("First 10 Parallel Factorials: ");
        parallelFactorials.stream().limit(10).forEach(System.out::println);
*/

        // *********************************************************************************************

    /*
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sumTillNow = new AtomicInteger(0);
        List<Integer> cumulativeSum = nums.stream()
                .map(sumTillNow::addAndGet)
                .toList();
        List<Integer> wrongCumulativeSum = nums.parallelStream()
                .map(sumTillNow::addAndGet)
                .toList();
        System.out.println(cumulativeSum);
        System.out.println(wrongCumulativeSum);
    */

        // *********************************************************************************************

        /*
        Sometimes, part of your processing benefits from parallelism (e.g., CPU-heavy operations), but later
        steps require order or are not thread-safe. You can use .sequential() to ensure safe, ordered
        execution.*/

//        List<String> names = List.of("sammo", "alice", "bob", "john", "mark", "pam", "roy");

//        names.parallelStream()
//                .filter((name) -> {
//                    System.out.println("Filtering: " + name + " | Thread: " + Thread.currentThread().getName());
//                    return name.length() > 3;
//                })
//                .peek(name -> System.out.println("Before sequential: " + name + " | " + Thread.currentThread().getName()))
//                .sequential()
//                .peek(name -> System.out.println("After sequential: " + name + " | " + Thread.currentThread().getName()))
//                .forEach(name -> System.out.println("Final: " + name));

        List<Integer> numbers = Stream.iterate(1, (x) -> x + 1)
                .limit(10)
                .toList();


        numbers.parallelStream()
                .filter(num -> {
                    System.out.println("Filtering: " + num + " | Thread: " + Thread.currentThread().getName());
                    try { Thread.sleep(10); } catch (InterruptedException e) {Thread.currentThread().interrupt();}
                    return num % 2 == 0;
                })
                .peek(num -> System.out.println("Before sequential: " + num + " | " + Thread.currentThread().getName()))
                .sequential()
                .peek(num -> System.out.println(": " + num + " | " + Thread.currentThread().getName()))
                .forEach(num -> System.out.println("Processed: " + num));
    }
}
