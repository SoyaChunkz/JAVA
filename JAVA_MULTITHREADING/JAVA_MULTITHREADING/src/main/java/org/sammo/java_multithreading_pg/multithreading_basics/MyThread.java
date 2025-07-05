package org.sammo.java_multithreading_pg.multithreading_basics;

public class MyThread implements Runnable{
    @Override
    public void run() {

//        System.out.println(Thread.currentThread().getName() + " is running...");
//        for (int i=0; i<10; i++) {
//            try {
//                Thread.sleep(1000);
////                System.out.println("Thread- " + Thread.currentThread().getName() + " was stopped for 1s...");
////                System.out.println("Thread- " + Thread.currentThread().getName() + " --> " + Thread.currentThread().getPriority());
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Thread- " + Thread.currentThread().getName() + " finished.");
//        }

//        for (int i=0; i<100; i++) {
//            System.out.println(Thread.currentThread().getName());
//            Thread.yield();  // It’s a hint to the thread scheduler that the current thread is willing to pause and let other threads run.
//        }

//        while (!Thread.currentThread().isInterrupted()) {
//            System.out.println("Still not interrupted...");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                System.out.println(e);
//                break;
//            }
//        }
//
//        System.out.println("Now Interrupted...");


        try {
            Thread.sleep(5000); // blocked
        } catch (InterruptedException e) {
            System.out.println("Woken up! Interrupted during sleep.");
        }
    }
}

//public class MyThread extends Thread{
//
//    @Override
//    public void run() {
//        System.out.println("RUNNING -> From my thread");
//
//        try{
//            Thread.sleep(2000);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}
