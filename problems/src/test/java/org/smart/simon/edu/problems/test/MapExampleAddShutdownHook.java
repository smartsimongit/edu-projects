package org.smart.simon.edu.problems.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapExampleAddShutdownHook {


    @Test
    void test() {
        TestClass testClass2 = new TestClass("FileName", 64l);
        TestClass testClass1 = new TestClass("FileName", 32l);
        List<TestClass> testClassList = new ArrayList<>();
        testClassList.add(testClass1);
        testClassList.add(testClass2);


        try {
            Map<String, TestClass> map1 =
                    testClassList.stream().collect(Collectors.toMap(s -> s.name, s -> s));
        } catch (Exception e) {
            Assertions.assertTrue(e.getClass().equals(IllegalStateException.class));
        }


        Map<String, TestClass> map2 =
                testClassList.stream().collect(Collectors.toMap(s -> s.name, s -> s, (a, b) -> b));

        Assertions.assertNotEquals(testClass1, testClass2);
        Assertions.assertEquals(1, map2.size());
        Assertions.assertTrue(map2.containsValue(testClass2));
    }

    public class TestClass {
        public String name;
        public Long size;

        public TestClass(String name, Long size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestClass testClass = (TestClass) o;
            return Objects.equals(name, testClass.name) && Objects.equals(size, testClass.size);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, size);
        }
    }
}
