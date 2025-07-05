package org.sammo.java_multithreading_pg.executors_framework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFramework {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            Future<Integer> future = service.submit(() -> SelfManaged.factorial(finalI));

            if (!future.isDone()) System.out.println("NOT DONE YET!!!");
            System.out.println(future.get());
            if (future.isDone()) System.out.println("DONE !!!");

        }

        service.shutdown();
    }
}
