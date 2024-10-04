package org.smart.simon.edu.problems.algos;

/* Binary Search
 The time complexity of this algorithm - O(log n)
 */


public class BinarySearch {

    private static String binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + high;
            if (arr[mid] == x) {
                return String.valueOf(mid);
            }
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "none";
    }

    public static void main(String[] args) {
        int x = 12;
        int y = 14;
        int[] arr = {2, 4, 10, 12, 13, 17, 19};
        System.out.println(binarySearch(arr, x));
        System.out.println(binarySearch(arr, y));
    }
}
