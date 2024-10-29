package org.smart.simon.edu.problems.exception;

import static java.util.stream.IntStream.range;

//OutOfMemoryError: unable to create native thread
public class OutOfMemoryNativeThread {
    public static void main(String[] args) {
        int size = 1_000_000;
        range(1, size).forEach(OutOfMemoryNativeThread::createThread);
    }

    private static void createThread(int i) {
        new Thread(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
            }
        }).start();
        System.out.printf("Created %d threads\n", i);
    }
}
