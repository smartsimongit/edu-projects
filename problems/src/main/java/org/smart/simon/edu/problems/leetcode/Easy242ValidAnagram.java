package org.smart.simon.edu.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy242ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] char_counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }
        for (int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int count : arr) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static String twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int[] targetArr = new int[2];
        while (i < nums.length) {
            map.put(nums[i], i);
            i++;
        }
        i = 0;
        while (i < nums.length) {
            int second = target - nums[i];
            if (map.get(second) != null) {
                targetArr[0] = nums[i];
                targetArr[1] = second;
                return nums[i] + " " + second;
            }
        }
        return null;
    }


public static void main(String[] args) {
    int[] nums = new int[]{3, 4, 5, 6};
    int target = 7;
    System.out.println(twoSum(nums, target));
}
//    public boolean isAnagram(String s, String t) {
//        char[] schars= s.toCharArray();
//        char[] tchars= t.toCharArray();
//
//        Arrays.sort(schars);
//        Arrays.sort(tchars);
//
//        return Arrays.equals(schars,tchars);
//    }

}
