package org.smart.simon.edu.problems.leetcode;

public class Easy242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] char_counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i)-'a']++;
            char_counts[t.charAt(i)-'a']--;
        }
        for (int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
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
