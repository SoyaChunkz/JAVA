package org.sammo.java_8.predicates;

import java.util.function.BiPredicate;

public class BiPredicatePractice {

    public static void main(String[] args) {

        BiPredicate<String, Integer> isNameLongerThan = (name, length) -> name.length() > length;

        System.out.println(isNameLongerThan.test("Sameer", 3)); // true
        System.out.println(isNameLongerThan.test("AI", 5));     // false
    }
}
