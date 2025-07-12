package org.sammo.java_8.suppliers;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierPractice {

    public static void main(String[] args) {

        /*
        Supplier is a functional interface with get() as the abstract method, so we give its implementation
        via a lambda expression.
        It takes no input and returns one output. */
        Supplier<String> greet = () -> "Hello";
        System.out.println(greet.get());

        Supplier<Integer> randomInt = () -> new Random().nextInt(100); // 0 to 99
        System.out.println("Random number: " + randomInt.get());
    }
}
