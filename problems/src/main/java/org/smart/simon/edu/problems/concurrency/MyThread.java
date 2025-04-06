package org.smart.simon.edu.problems.concurrency;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("k: " + i);
        }
    }
}
