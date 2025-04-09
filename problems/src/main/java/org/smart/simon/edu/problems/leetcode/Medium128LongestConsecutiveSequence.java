package org.smart.simon.edu.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Medium128LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 2, 5, 4, 6, 1, 1};
        System.out.println(longestConsecutive(nums));
    }
}
