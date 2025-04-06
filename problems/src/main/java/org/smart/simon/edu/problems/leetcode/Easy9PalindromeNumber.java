package org.smart.simon.edu.problems.leetcode;

public class Easy9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int temp = x;
        int nn = 0;
        if (x < 0) {
            return false;
        }

        while (temp != 0) {
            nn = nn * 10 + temp % 10;
            temp /= 10;
        }
        return nn == x;
    }

    public static void main(String[] args) {
        System.out.println(  isPalindrome(123321));
    }

}
