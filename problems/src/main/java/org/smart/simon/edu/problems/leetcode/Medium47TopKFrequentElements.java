package org.smart.simon.edu.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Medium47TopKFrequentElements {
    //TODO find faster solution
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        int[] arr = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue() //TODO remember!
                        .reversed()).limit(k)
                .map(e -> e.getKey())
                .mapToInt(Integer::intValue).toArray();


        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {7, 7};
        topKFrequent(nums, 1).toString();
    }
}
