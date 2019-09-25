package ru.itis;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3);

        Runnable task1 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello " + Thread.currentThread().getName());
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Bye " + Thread.currentThread().getName());
            }
        };

        Runnable task3 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Marsel " + Thread.currentThread().getName());
            }
        };

        threadPool.submit(task1);
        threadPool.submit(task2);
        threadPool.submit(task3);
    }
}
