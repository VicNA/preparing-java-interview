package ru.geekbrains.lesson3.task1;

public class PingPong {
    private final Object monitor = new Object();
    private volatile int step = 1;

    public void ping() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (step != 1) {
                        monitor.wait();
                    }
                    System.out.println("Ping");
                    step = 2;
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pong() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (step != 2) {
                        monitor.wait();
                    }
                    System.out.println("Pong");
                    step = 1;
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
