package ru.itis.runnable;

public class Main {

    public static void main(String[] args) {
	    CustomThread customThread = new CustomThread();
	    customThread.start();
	    customThread.run();

	    CustomThreadRunnable runnable = new CustomThreadRunnable();
	    Thread thread = new Thread(runnable);
	    thread.start();

	    Runnable lambdaRunnable = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i + Thread.currentThread().getName());
			}
		};

	    Thread anotherThread = new Thread(lambdaRunnable);
	    anotherThread.start();

	    Thread oneMoreThread = new Thread(
				() -> {
					for (int i = 0; i < 100; i++) {
						System.out.println("Hello");
					}
				}
		);
	    oneMoreThread.start();
	}
}
