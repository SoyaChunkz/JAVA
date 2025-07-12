package org.sammo.java_8.functions;

import java.util.function.Function;

public class FunctionPractice {

    public static void main(String[] args) {

        /*
        Function is a functional interface with apply() as the abstract method, so we give its implementation
        via a lambda expression.
        It takes one input and returns one output. */
        Function<String, Integer> getLength = (string) -> string.length();
        Function<Integer, String> getStar = (i) -> {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            return sb.toString();
        };

        System.out.println(getLength.apply("abc"));

        /*
         Function chaining:
         - andThen(): apply getLength first, then pass the result to getStar
         - compose(): apply getLength first (since it's the argument), then getStar */
        Function<String, String> andThen = getLength.andThen(getStar);
        Function<String, String> compose = getStar.compose(getLength);

        System.out.println(andThen.apply("sammo"));
        System.out.println(compose.apply("darling"));

        /*
         Function.identity(): returns a function that returns its input as-is.
         Useful as a default placeholder or identity mapper. */
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(5));
    }
}
