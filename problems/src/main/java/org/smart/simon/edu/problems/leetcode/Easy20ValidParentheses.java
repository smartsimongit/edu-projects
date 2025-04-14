package org.smart.simon.edu.problems.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Easy20ValidParentheses {
    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(isValid2(s));
    }

    public static boolean isValid2(String s) {
        char[] brackets = s.toCharArray();
        if (brackets.length % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (char c : brackets) {
            if (!stack.isEmpty() && map.containsKey(c) && map.get(c) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid
            (String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();

        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}
