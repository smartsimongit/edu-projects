package org.smart.simon.edu.problems.interviews;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunnyQuests {
    // Создание бесконечного цикла на пустом месте
    public static void infinitiveLoop() {
        int start = Integer.MAX_VALUE - 1;
        for (int i = start; i <= start + 1; i++) {
            /* тут должен быть бесконечный цикл, менять ничего нельзя*/
            System.out.println(i);
        }
    }

    // Создайте комментарий, который будет выполнятся
    public static void executableComment() {
        // комментарий ниже будет выполнен!
        //
        System.out.println("выполняемый комментарий");
    }

    // О единственном дубликате в массиве целых чисел. Есть ArrayList или массив с элементами от 1 до 100. И только один элемент дублированный.
    // Как его найти?
    private static void findDuplicate(List<Integer> elements) {
        int distinctSum = elements.stream().distinct().mapToInt(e -> e).sum();
        int totalSum = elements.stream().mapToInt(e -> e).sum();
        System.out.println("Элемент, который повторяется : " + (totalSum - distinctSum));
    }

//    public static void main(String[] args) {
//        List <Integer> elements = IntStream.range(1, 101).boxed().collect(Collectors.toList());
//        elements.set(53, 23);
//        findDuplicate(elements);
//    }
    //О неединственном дубликате в массиве целых чисел
}
