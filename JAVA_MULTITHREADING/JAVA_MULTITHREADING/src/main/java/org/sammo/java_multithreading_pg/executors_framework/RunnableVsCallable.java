package org.sammo.java_multithreading_pg.executors_framework;

import java.util.concurrent.*;

public class RunnableVsCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> { System.out.println("FROM RUNNABLE: " + 9); };  // doesn't return anything (void)
        Callable<Integer> callable = () -> 9;                                      // returns something

        System.out.println("RUNNABLE ");
        Future<?> run1 = service.submit(runnable);

        Thread.sleep(1);
        System.out.println("RUNNABLE with return ");
        Future<?> run2 = service.submit(runnable, 9);

        Thread.sleep(1);
        System.out.println("CALLABLE ");
        Future<Integer> call = service.submit(callable);

        System.out.println(run1.get() + ", " + run2.get() + ", " + call.get());

        service.shutdown();
    }
}