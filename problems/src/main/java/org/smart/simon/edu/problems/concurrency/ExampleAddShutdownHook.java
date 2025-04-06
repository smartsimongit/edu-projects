package org.smart.simon.edu.problems.concurrency;

public class ExampleAddShutdownHook extends Thread {
    public void run() {
        System.out.println("shutdown hook задачу выполнил");
    }

    public static void main(String[] args) {
        System.out.println("Begin");
        Runtime.getRuntime().addShutdownHook(new ExampleAddShutdownHook());

        System.out.println("Теперь программа засыпает, нажмите ctrl+c чтоб завершить ее.");
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("End");
    }


}
