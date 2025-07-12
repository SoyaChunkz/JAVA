package org.sammo.java_8.method_references;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class User {

    private String name;

    public User(String name) {
        this.name = name;
        System.out.println(name + " created!");
    }

    public void printHello () {
        System.out.println("Hello, " + name);
    }
}

public class MethodReferencePractice {

    /*
    There are 4 types of method references:
     1. Reference to a static method              → ClassName::staticMethod
     2. Reference to an instance method (object)  → object::instanceMethod
     3. Reference to an instance method (class)   → ClassName::instanceMethod
     4. Reference to a constructor                → ClassName::new */

    public static void sayHello (String name) {
        System.out.println("Hello, " + name);
    }

    void print(String msg) {
        System.out.println("Message: " + msg);
    }

    public static void main(String[] args) {

        // 1 Static Method Reference
        Consumer<String> consumerNormal = (name) -> sayHello(name);
        Consumer<String> consumerMethodReference = MethodReferencePractice::sayHello;

        consumerNormal.accept("from consumerNormal");
        consumerMethodReference.accept("from consumerMethodReference");
        System.out.println("----------------------------------------------------------------");


        // 2 Instance Method Reference (specific object)
        MethodReferencePractice obj = new MethodReferencePractice();
        Consumer<String> printerNormal = (msg) -> obj.print(msg);
        Consumer<String> printerMethodReference = obj::print;
        printerNormal.accept("invoking obj instance's print method");
        printerMethodReference.accept("just giving obj instance's method reference");
        System.out.println("----------------------------------------------------------------");


        // 3 Instance Method of Arbitrary Object (ClassName::method)
        List<String> names = Arrays.asList("sameer", "darling", "alex", "bob");
        names.forEach(String::toUpperCase);
//        names.stream().map((name) -> name.toUpperCase()).forEach((name) -> System.out.println(name));
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");


        // 4 Constructor Reference (ClassName::new)
//        names.stream().map((name) -> new User(name)).forEach((user) -> user.printHello());
        names.stream().map(User::new).forEach(User::printHello);


        /*
        When you use a method reference like obj::instanceMethod, you are referring to an instance method
        on a specific object that already exists. For example, if you have an object printer, doing
        printer::print means you’re telling Java to always call the print() method on that exact object.

        On the other hand, when you write ClassName::methodName, you are not pointing to one specific object
        — instead, you are telling Java, “For any object of this class, call this method on it.” This is
        commonly used in stream pipelines where each element in the stream is treated as an input, and the
        referenced method is applied to it. For instance, String::toUpperCase in a stream is interpreted
        as: “For each string in the stream, call its toUpperCase() method.” */

    }
}
