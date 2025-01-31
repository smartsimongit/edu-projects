package org.smart.simon.edu.problems.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CmpltblFtrJoin {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = future();
        System.out.println("КОНЕЦ");
        list.forEach(System.out::println);
//        Thread.sleep(10000);
    }

    private static List<String> future() {
        List<String> list = new ArrayList<>();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add("future1");

            System.out.println("Задача 1 выполнена");
        });


        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add("future2");
            System.out.println("Задача 2 выполнена");
        });

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            list.add("future3");
            System.out.println("Задача 3 выполнена");
        });

//        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
//
//        combinedFuture.thenRun(() -> {
//            System.out.println("Все задачи выполнены");
//        });

        List<CompletableFuture> futureList = new ArrayList<>();
        futureList.add(future1);
        futureList.add(future2);
        futureList.add(future3);
        futureList.forEach(CompletableFuture::join);
        return list;
    }
}
