package org.sammo.java_multithreading_pg.locks_basics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccount (int balance) {
        this.balance = balance;
    }

    public void withdraw (int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal.");
                        // simulate dummy transaction/db operation
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " withdrawal complete, remaining balance is " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();  // restore the flag
                        System.out.println("This is for InterruptedException, if thread is interrupted while sleeping.");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance.");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to acquire the lock, please try again later.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // restore the flag
            System.out.println("This is for InterruptedException, if thread is interrupted while waiting to acquire lock.");
        }

        /* clean up code,
        this fails if we don't restore the interrupt flag manually
        if (Thread.currentThread().isInterrupted()) {

        } */

    }
}
