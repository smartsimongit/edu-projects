package org.smart.simon.edu.problems.leetcode;

public class Medium167TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int y = numbers.length-1;
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i]+numbers[y] == target)
                return new int[]{numbers[i],numbers[y]};
        }
        return new int[0];
    }
}
