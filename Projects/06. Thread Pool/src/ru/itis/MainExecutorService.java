package ru.itis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

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

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
    }
}
