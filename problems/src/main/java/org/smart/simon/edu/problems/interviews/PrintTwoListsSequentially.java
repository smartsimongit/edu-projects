package org.smart.simon.edu.problems.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * Print sequentially two lists of different lengths of n elements each
 */
public class PrintTwoListsSequentially {
    public static void main(String[] args) {
        List<String> listString = Arrays.asList("a", "b", "c", "d", "e", "f", "j", "k", "l", "t", "y", "z", "u");
        List<Integer> intString = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        int packSize = 3;

        int fullLength = listString.size() >= intString.size() ? listString.size() : intString.size();


        for (int i = 0; i < fullLength; i = i + packSize) {
            screen(i > intString.size() ? new ArrayList<>() : listString.subList(i,
                            Math.min(i + packSize, listString.size())),
                    i > intString.size() ? new ArrayList<>() : intString.subList(i,
                            Math.min(i + packSize, intString.size())));
        }
    }

    static void screen(List<String> listString, List<Integer> intString) {
        listString.forEach(System.out::println);
        intString.forEach(System.out::println);
    }
}
