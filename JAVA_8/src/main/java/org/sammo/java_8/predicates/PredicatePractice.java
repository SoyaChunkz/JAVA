package org.sammo.java_8.predicates;

import java.util.function.Predicate;

public class PredicatePractice {

    public static void main(String[] args) {

        /*
        Predicate is a functional interface with test() as the abstract method, so we give its implementation
        via a lambda expression. */
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        Predicate<Integer> isGreaterThan10 = (x) -> x > 10;

        // Combining predicates using and()
        Predicate<Integer> andPredicate = isEven.and(isGreaterThan10);
        System.out.println("Is 20 even and > 10? " + andPredicate.test(20)); // true

        // Using or()
        Predicate<Integer> orPredicate = isEven.or(isGreaterThan10);
        System.out.println("Is 7 even or > 10? " + orPredicate.test(7));     // false
        System.out.println("Is 12 even or > 10? " + orPredicate.test(12));   // true

        // Using negate()
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println("Is 9 not even? " + isOdd.test(9));             // true

        // Example with Strings: check if string is empty
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("Is \"\" empty? " + isEmpty.test(""));            // true

    }
}
