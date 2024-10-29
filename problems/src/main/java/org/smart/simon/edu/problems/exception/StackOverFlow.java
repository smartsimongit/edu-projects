package org.smart.simon.edu.problems.exception;

public class StackOverFlow {
    public static int counter = 0;
    public static void main(String[] args) {
        exceptionThrow0();
    }

    private static void exceptionThrow0() {
        System.out.println(counter++);
        exceptionThrow0();
    }
}
