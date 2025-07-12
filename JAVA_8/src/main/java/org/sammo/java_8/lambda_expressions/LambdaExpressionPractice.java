package org.sammo.java_8.lambda_expressions;

@FunctionalInterface
interface MathOperation {

    int operate (int a, int b); // Single abstract method

    // Default method – can be inherited or overridden by implementing classes
    default void getPi() {
        System.out.println("Default 3.14");
    }

    // Static method – belongs to interface, called via InterfaceName.method()
    static int square(int x) {
        return x * x;
    }
}

// Concrete Implementation of MathOperation using a class
class AddOperation implements MathOperation {

    @Override
    public int operate(int a, int b) {
        return a + b;
    }

    @Override
    public void getPi () {
        System.out.println("AddOperation 3.14");
    }
}

public class LambdaExpressionPractice {

    public static void main(String[] args) {

        MathOperation add = new AddOperation();
        System.out.println(add.operate(1, 2));
        add.getPi();
        System.out.println(MathOperation.square(5));

        /*
        Instead of creating an implementation class like AddOperation for each operation, we can use lambda
        expression as MathOperation is a functional interface it will have only one abstract method and
        passing a lambda expression in the Interface's reference will override that abstract method. */

        MathOperation sub = (a, b) -> a - b;
        MathOperation mul = (a, b) -> a * b;
        MathOperation div = (a, b) -> {
            if (b != 0 && a > b) return a / b;
            else if (b == 0) return -1;
            else return 0;
        };

        System.out.println(sub.operate(2, 4));
        System.out.println(mul.operate(2, 3));
        System.out.println(div.operate(2, 3));
        System.out.println(div.operate(2, 0));
        sub.getPi();
        System.out.println(MathOperation.square(5));
    }
}
