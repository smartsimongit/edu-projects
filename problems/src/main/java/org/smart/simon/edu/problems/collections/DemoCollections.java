package org.smart.simon.edu.problems.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DemoCollections {

    public static void iterIter(String[] args) {
        List<String> names = new ArrayList<>(List.of("Аня", "Борис", "Вика", "Григорий"));
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.length() > 4) {
                iterator.remove();
            }
        }
        System.out.println(names);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("String", 33);
        map.put("String", 11);
        map.put("String", 23);
        map.put("String", 44);
        System.out.println(  map.get("String"));

    }
}
