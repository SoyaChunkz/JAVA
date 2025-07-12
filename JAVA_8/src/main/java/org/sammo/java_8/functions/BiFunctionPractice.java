package org.sammo.java_8.functions;

import java.util.function.BiFunction;

public class BiFunctionPractice {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, String> sumToString = (a, b) -> "Sum: " + (a + b);

        System.out.println(sumToString.apply(5, 3));  // Output: Sum: 8
    }
}
