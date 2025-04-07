package org.smart.simon.edu.problems.leetcode;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.Arrays;

public class Medium238ProductOfArrayExceptSelf {

    @Deprecated
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] temp = new int[size];

        for (int i = 0; i < size; i++) {
            int var = 1;
            for (int k = 0; k < size; k++) {
                if (k != i) {
                    var = var * nums[k];
                }
            }
            temp[i] = var;
        }
        return temp;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int prod = 1, zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeroCount++;
            }
        }
        if (zeroCount > 1) {
            return new int[nums.length];
        }
        int[] tempArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                tempArr[i] = nums[i] == 0 ? prod : 0;
            } else {
                tempArr[i] = prod / nums[i];
            }
        }
        return tempArr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        nums = productExceptSelf2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
