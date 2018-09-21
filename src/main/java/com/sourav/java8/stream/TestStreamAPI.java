package com.sourav.java8.stream;

import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestStreamAPI {
    public static void main(String[] args) {
        Arrays.asList("a1","a2","b2","b3","c1")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
        LongStream.range(2l,3l).forEach(System.out::println);
        System.out.println("..........................................");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
        System.out.println("..........................................");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {  // If return true, it will not execute the rest of the elements in stream
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
        System.out.println("..........................................");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
