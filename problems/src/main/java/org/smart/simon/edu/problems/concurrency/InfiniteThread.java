package org.smart.simon.edu.problems.concurrency;

public class InfiniteThread {

    public static void main(String[] args) {
        int threadCount = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < threadCount; i++) {
            Thread infiniteThread = new Thread(()->{
                while (true) {
                    //infinitive thread
                }
            });
            infiniteThread.start();
            infiniteThread.start();
        }
        MyThread thread = new MyThread();
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("p: " + i);
            }
        });
        thread2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("i: " + i);
        }
    }


}
