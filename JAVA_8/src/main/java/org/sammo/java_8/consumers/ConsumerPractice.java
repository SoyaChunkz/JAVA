package org.sammo.java_8.consumers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {

    public static void main(String[] args) {

        /*
        Consumer is a functional interface with accept() as the abstract method, so we give its implementation
        via a lambda expression.
        It takes one input and returns no output. */
        Consumer<String> printUpper = name -> System.out.println(name.toUpperCase());
        printUpper.accept("sameer");  // Output: SAMEER

        Consumer<String> greet = name -> System.out.print("Hello, ");
        Consumer<String> printName = name -> System.out.println(name);

        Consumer<String> combined = greet.andThen(printName);
        combined.accept("Sameer");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<Integer> printDouble = num -> System.out.println(num * 2);

        numbers.forEach(printDouble);
    }
}
