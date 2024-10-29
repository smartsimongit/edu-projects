package org.smart.simon.edu.problems.exception;


public class OutOfMemoryError {
    public static void main(String[] args) {
//        outOfMemoryErrorStack(); //OutOfMemoryError: Requested array size exceeds VM limit
        outOfMemoryErrorHeap();    //OutOfMemoryError: Java heap space

    }

    private static void outOfMemoryErrorHeap() {
        int size = 1_000_000;
        int[][] array = new int[size][];
        for (int i = 0; i < size; i++) {
            array[i] = new int[size]; // new large Object
        }
        System.out.println(array.length);
    }

    private static void outOfMemoryErrorStack() {
        int[] arr = new int[Integer.MAX_VALUE];
    }
}
