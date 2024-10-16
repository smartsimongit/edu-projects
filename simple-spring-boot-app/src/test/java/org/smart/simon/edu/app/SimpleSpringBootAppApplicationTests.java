package org.smart.simon.edu.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleSpringBootAppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        Assertions.assertTrue(1 == 1);
    }
}
