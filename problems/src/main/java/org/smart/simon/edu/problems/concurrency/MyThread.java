package org.smart.simon.edu.problems.concurrency;

class MyThread extends Thread {
    private String letter = "k";

    public MyThread() {
    }

    public MyThread(String letter) {
        this.letter = letter.trim();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(letter + ": " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("k");
        MyThread t2 = new MyThread("t");
        MyThread t3 = new MyThread("f");
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Main thread ended");
    }
}
