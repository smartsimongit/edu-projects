package org.smart.simon.edu.problems.interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        addStudents(students);
        /**
         * Task 1: Вывести список имен студентов в алфавитном порядке
         */
        System.out.println(students.stream().map(Student::getName).sorted().toList());
        /**
         * Task 2: Найти средний возраст всех студентов
         */
        System.out.println(students.stream().mapToInt(Student::getAge).average().orElse(0));
        /**
         * Task 3: Получить список студентов, средний балл которых выше 4.5
         */
        System.out.println(students.stream().filter(s->s.getAverageGrade()>4.5).toList());
        /**
         * Task 4: Разделить студентов на две группы: младше и старше 21 года
         */
        System.out.println(students.stream().collect(Collectors.groupingBy(s-> s.getAge()>21 ? "Старше 21" : "Младше 21" )));
        /**
         * Task 5: Найти самого молодого студента с баллом выше 4.0
         */
        System.out.println(students.stream().filter(s -> s.getAverageGrade()>4.0).min(Comparator.comparingInt(s->s.getAge())).orElse(null));
    }

    private static void addStudents(List<Student> students) {
        students.add(new Student("Alice", 20, 4.8));
        students.add(new Student("Bob", 22, 4.2));
        students.add(new Student("Charlie", 19, 3.9));
        students.add(new Student("David", 30, 4.5));
        students.add(new Student("Eve", 18, 4.7));
        students.add(new Student("Frank", 21, 4.1));
        students.add(new Student("Grace", 23, 4.6));
        students.add(new Student("Henry", 17, 4.3));
        students.add(new Student("Isabella", 24, 4.9));
        students.add(new Student("Jack", 26, 4.0));
    }

    public static class Student {
        private final String name;
        private final int age;
        private final double averageGrade;

        public Student(String name, int age, double averageGrade) {
            this.name = name;
            this.age = age;
            this.averageGrade = averageGrade;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getAverageGrade() {
            return averageGrade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", averageGrade=" + averageGrade +
                    '}';
        }
    }
}
