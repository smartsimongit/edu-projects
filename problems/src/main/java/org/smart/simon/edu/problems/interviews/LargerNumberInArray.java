package org.smart.simon.edu.problems.interviews;

/**
 * Find the Maximum Element
 * Write a function that takes an array of integers and returns the maximum element of that array.
 */
public class LargerNumberInArray {
    private static String getLargerNumber(int[] arr) {
        if (arr == null || arr.length == 0) return "none";
        int max = arr[0];
        for (int number : arr) {
            if (number > max) {
                max = number;
            }
        }
        return Integer.toString(max);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 8, 1};
        System.out.println(getLargerNumber(arr));
    }
}
