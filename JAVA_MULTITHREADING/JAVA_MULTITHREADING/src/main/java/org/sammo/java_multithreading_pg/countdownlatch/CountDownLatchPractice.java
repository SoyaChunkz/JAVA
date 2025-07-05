package org.sammo.java_multithreading_pg.countdownlatch;

import java.util.concurrent.*;

class Task1 implements Callable<String> {

    private final CountDownLatch latch;

    public Task1 (CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " Task1 started....");
            Thread.sleep(3000);
            System.out.println("Callable");
        } finally {
            latch.countDown();
        }
        return "ok";
    }
}

class Task2 implements Runnable {

    private final CountDownLatch latch;

    public Task2(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Task2 started....");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runnable");
        } finally {
            latch.countDown();
        }
    }
}

public class CountDownLatchPractice {

    public static void main(String[] args) throws InterruptedException {

        int numberOfServices = 3;
        ExecutorService service = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch1 = new CountDownLatch(numberOfServices);

        service.submit(new Task1(latch1));
        service.submit(new Task1(latch1));
        service.submit(new Task1(latch1));

        latch1.await(1, TimeUnit.SECONDS);
        System.out.println("MAIN1...");
//        service.shutdown();
        service.shutdownNow();

//        CountDownLatch latch2 = new CountDownLatch(numberOfServices);
//        for (int i = 0; i < numberOfServices; i++) {
//            Thread t = new Thread(new Task2(latch2));
//            t.start();
//        }
//
//        latch2.await(2, TimeUnit.SECONDS);
//        System.out.println("MAIN2...");
    }
}
