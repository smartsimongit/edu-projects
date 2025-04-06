package org.smart.simon.edu.problems.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencySoup {
    //static AtomicInteger potato = new AtomicInteger(0);
    static int potato = 0;

    public static void main(String[] args) {
        Thread kolya = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                addPotato();
            }
            System.out.println("kolya = " + potato);
        });
        kolya.start();

        Thread petya = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                addPotato();
            }
            System.out.println("petya = " + potato);
        });
        petya.start();
    }

//    static void addPotato() {
//        potato.addAndGet(1);
//    }

    synchronized static void addPotato() {
        potato = potato + 1;
    }
}
