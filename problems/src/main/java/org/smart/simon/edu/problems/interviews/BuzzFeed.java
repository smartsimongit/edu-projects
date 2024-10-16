package org.smart.simon.edu.problems.interviews;

import java.util.stream.IntStream;

/**
 * Write a program that outputs the numbers from 1 to 100.
 * Instead of numbers that are multiples of three, the program should output the word 'Fizz,'
 * and instead of numbers that are multiples of five, it should output the word 'Buzz.'
 * If a number is a multiple of both 3 and 5, the program should output the word 'FizzBuzz.'
 */
public class BuzzFeed {

    /**
     * Напишите программу, которая выводит на экран числа от 1 до 100.
     * При этом вместо чисел, кратных трем, программа должна выводить слово «Fizz»,
     * а вместо чисел, кратных пяти — слово «Buzz». Если число кратно и 3, и 5,
     * то программа должна выводить слово «FizzBuzz»
     */
    public static void main(String[] args) {
//        buzzFeed(100);
        buzzFeed2(100);
    }

    public static void buzzFeed(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println(i + " Fizz");
            } else if (i % 5 == 0) {
                System.out.println(i + " Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void buzzFeed2(int max) {
        IntStream.rangeClosed(1, max).mapToObj(i -> mapToFizzBuzz(i)).forEach(System.out::println);
    }

    private static String mapToFizzBuzz(int i) {
        return i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz " : "Fizz ") : (i % 5 == 0 ? "Buzz " : i + " ");
    }
}
