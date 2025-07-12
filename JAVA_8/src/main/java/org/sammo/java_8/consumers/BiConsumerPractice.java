package org.sammo.java_8.consumers;

import java.util.function.BiConsumer;

public class BiConsumerPractice {

    public static void main(String[] args) {

        BiConsumer<String, Integer> printNameAndAge = (name, age) -> System.out.println("Name: " + name + " --> Age: " + age);
        printNameAndAge.accept("sammo", 21);
    }
}
