package org.sammo.java_multithreading_pg.locks_basics;

public class Main {

    public static void main (String[] args) {

        BankAccount bankAccount = new BankAccount(100);

        // creating a new instance of an unnamed/anonymous class that implements Runnable
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        t1.start();
        t2.start();


    }
}
