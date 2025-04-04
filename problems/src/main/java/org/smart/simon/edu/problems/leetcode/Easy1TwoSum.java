package org.smart.simon.edu.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            if (indices.containsKey(second) && indices.get(second) != i) {
                return new int[]{i, indices.get(second)};
            }
        }
        return new int[0];
    }
}
