package org.sammo.java_multithreading_pg.lambda_expression;

class Task1 implements Runnable {

    @Override
    public void run() {
        System.out.println("This is Task1's run");
    }
}

public class LambdaExpression {
    public static void main(String[] args) {

        Runnable task1 = new Task1();
        Thread t1 = new Thread(task1, "basic_runnable");

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is Task2's run");
            }
        };
        Thread t2 = new Thread(task2, "anonymous_runnable_class_implementation");

        Runnable task3 = () -> {System.out.println("This is Task3's run");};
        Thread t3 = new Thread(task3, "lambda_expression");

        Thread t4 = new Thread(() -> {System.out.println("This is Task4's run");}, "inline_lambda_expression");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
