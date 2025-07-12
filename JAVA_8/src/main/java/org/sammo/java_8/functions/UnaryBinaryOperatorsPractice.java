package org.sammo.java_8.functions;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperatorsPractice {

    public static void main(String[] args) {


        UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
        System.out.println(toUpperCase.apply("java")); // Output: JAVA

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // Output: 25

        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20)); // Output: 30

        BinaryOperator<String> join = (s1, s2) -> s1 + "-" + s2;
        System.out.println(join.apply("Hello", "World")); // Output: Hello-World
    }
}
