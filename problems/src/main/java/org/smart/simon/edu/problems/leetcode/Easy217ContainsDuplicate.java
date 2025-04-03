package org.smart.simon.edu.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy217ContainsDuplicate {

        public static boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            boolean result = false;
            for (int i = 0; i < nums.length; i++) {
                int e = nums[i];
                result = map.containsKey(e);
                if (result) {
                    break;
                }
                map.put(e, i);

            }
            return result;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int[] nums2 = {1, 2, 3, 4, 5, 6, 4, 8, 9};

            System.out.println(containsDuplicate(nums));
            System.out.println(containsDuplicate(nums2));
        }

    }

