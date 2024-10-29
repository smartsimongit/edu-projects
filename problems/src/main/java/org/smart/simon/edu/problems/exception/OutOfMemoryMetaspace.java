package org.smart.simon.edu.problems.exception;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

//TODO: jar
public class OutOfMemoryMetaspace {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int count = 1_000_000_000;
        final List<Object> instances = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final Class<?> cls = String.class;
            final Object o = cls.getDeclaredConstructor().newInstance(); //todo instance of ext-jar
            instances.add(o);
        }
        System.out.println("Total instances: " + instances.size());
    }

}
