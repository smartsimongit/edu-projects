package org.smart.simon.edu.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
