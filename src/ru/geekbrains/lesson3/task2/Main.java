package ru.geekbrains.lesson3.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Counter counter = new Counter();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " - " + counter.increment());
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " - " + counter.increment());
                lock.unlock();
            }
        }).start();
    }
}
