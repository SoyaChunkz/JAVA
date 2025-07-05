package org.sammo.java_multithreading_pg.executors_framework;

public class SelfManaged {

    public static int factorial (int num) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (num == 0 || num == 1) return 1;

        return num * factorial(num-1);
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {

            int finalI = i;
            threads[i-1] = new Thread(() -> {
                System.out.println(factorial(finalI));
            });
            threads[i-1].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("TIME TAKEN: " + (System.currentTimeMillis() - startTime));

    }
}
