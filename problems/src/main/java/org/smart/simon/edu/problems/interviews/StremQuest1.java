package org.smart.simon.edu.problems.interviews;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StremQuest1 {

    @Data
    public class Product {
        String name;
        Integer quantity;
        Double price;
    }

    @Data
    public class Order {
        String orderId;
        String costumerName;
        List<Product> products;
    }

    @Service
    public class OrderAnalysis {
        public static Double calculate(Order rorder) {
            return rorder.getProducts().stream().mapToDouble(p -> p.quantity * p.price).sum();
            // return rorder.getProducts().stream().map(p -> p.quantity * p.price).reduce(Double::sum).get();
        }

        public Set<String> getUniqueProductNames(List<Order> orders) {
            return orders.stream().flatMap (o -> o.getProducts().stream().map(Product::getName))
                    .collect(Collectors.toSet());
        }

        public List<String> getPopularProductNames(List<Order> orders, int topN) {
            Map<String, Integer> map =
            orders.stream().flatMap(o -> o.getProducts().stream())
                    .collect(Collectors.groupingBy(Product::getName,Collectors.summingInt(Product::getQuantity)));
                   // .forEach(product -> map.put(product.getName(), map.merge(product.getName(), product.getQuantity(), (prev, one) -> prev + one)));
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
            return list.stream().map(Map.Entry::getKey).limit(topN).collect(Collectors.toList());

        }
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("cherry", 20);
        map.put("strawberry", 15);
        map.put("peach", 21);
        map.put("melon", 12);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        list.stream().map(Map.Entry::getKey).limit(3).forEach(System.out::println);
    }

}
