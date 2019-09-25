package ru.itis;

import java.util.Deque;
import java.util.LinkedList;

// класс представляет собой набор потоков
// готовых взять на исполнение какую-лио задачу
public class ThreadPool {
    // массив потоков, которые будут брать на выполнение какие-либо задачи
    private PoolWorker threads[];
    // очередь задач (Queue), Deque - Stack + Queue (двусторонняя очередь)
    // может работать как стек, так и как очередь
    private final Deque<Runnable> tasks;
    // конструктор Пула Потоков
    // на вход принимает количество потоков, которые должны работать
    public ThreadPool(int threadCount) {
        // создаем связный список очереди задач
        tasks = new LinkedList<>();
        // создаем массив потоков
        threads = new PoolWorker[threadCount];
        // создаем каждый поток и сразу его запускаем
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }
    // метод для отправки задачи на выполнение
    public void submit(Runnable task) {
        // пока мы кладем в очередь какую-то задачу
        // ни один поток не должен испортить очередь
        // поэтому мы блокируем очередь задач для всех других потоков
        synchronized (tasks) {
            // кладем задачу в очередь
            tasks.add(task);
            // после того, как мы положили в очередь задачу
            // мы говорим всем потокам -> пожалуйста, берите задачу
            tasks.notify();
        }
    }
    // вложенный класс, потомок Thread
    // представляет собой класс для объектов пула потоков
    private class PoolWorker extends Thread {
        @Override
        public void run() {
            Runnable task;
            // каждый поток работает бесконечно
            while (true) {
                // пока в очередь смотрит какой-то поток
                // доугие потоки не должны ее трогать
                // поэтому здесь мы ее блокируем
                synchronized (tasks) {
                    // пока очередь задач пустая
                    while (tasks.isEmpty()) {
                        try {
                            // поток уходит в ожидание
                            // на этой очереди
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                    // мы выходим из цикла, как только в очереди
                    // появляется задача
                    // забираем задачу из очереди
                    task = tasks.removeFirst();
                }
                // вызываем релазицию потока
                task.run();
            }
        }
    }
}