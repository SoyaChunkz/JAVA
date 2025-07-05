package org.sammo.java_multithreading_pg;

import org.sammo.java_multithreading_pg.multithreading_basics.MyThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
// Thread
//        Thread t1 = new MyThread();

// Runnable
//        MyThread myThread = new MyThread();
//        Thread t1 = new Thread(myThread);

//        System.out.println(t1.getName());
//        System.out.println(t1.getState());
//        t1.start();
//        System.out.println(t1.getState());
//        Thread.sleep(1000); // to give t1 chance of execution
//        System.out.println(t1.getState());
//        t1.join();
//        System.out.println(t1.getState());
    

//        System.out.println("Hello world!");


//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getState());


          MyThread myThread = new MyThread();
//          Thread t1 = new Thread(myThread, "sammo");
//          Thread t2 = new Thread(myThread);
//          t2.setName("darling");
//          t1.start();
//          t2.start();
//
//          t1.run(); // this is not "sammo", it just runs the current thread's run fn


//          t1.start();
//        A Thread object in Java can only be started once.
//        After it finishes execution, it's in the TERMINATED (dead) state.
//        You can't restart a dead thread.
//          t1.start(); //The start() method checks the internal thread state. If it's already started or terminated, it throws IllegalThreadStateException.

//        t1.join(); // awaits the main thread until t1 finishes
//        System.out.println(Thread.currentThread().getName() + " is RESUMES...");

//        Thread t1 = new Thread(myThread, "low");
//        Thread t2 = new Thread(myThread, "med");
//        Thread t3 = new Thread(myThread, "high");

//        Priority doesn’t guarantee execution order or performance, it's just a hint to the JVM scheduler.
//        (in modern OSes like Windows/Linux, the scheduler has its own rules).
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);
//        t3.setPriority(Thread.NORM_PRIORITY);

//        t1.setDaemon(true);

//        t1.start();
//        t2.start();
//        t3.start();

            Thread t1 = new Thread(myThread);

            t1.start();

            Thread.sleep(2000); // await the main thread and give t1 some time
            t1.interrupt();
            System.out.println("MAIN DONE");

    }
}