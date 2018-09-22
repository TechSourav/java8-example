package com.sourav.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatmapDemo {
    public static void main(String[] args) {

        System.out.println("Example 1");
        List<String> carComp= Arrays.asList("Maruti","Honda","Audi","Nissan");
        List<String> carModels= Arrays.asList("Swift","City","H123","Micra");
        List<List<String>> cars = Arrays.asList(carComp,carModels);//new ArrayList<List<String>>();
        List<String> finalCars=cars.stream().flatMap(x->x.stream()).collect(Collectors.toList());
        finalCars.stream().forEach(System.out::println);
        finalCars.stream().filter(x->x.startsWith("H")).forEach(System.out::println);

        System.out.println("Example 2");

        String[][] strArr = new String[][] {{"a","b"},{"c","d"},{"e","d"}};
        Stream<String[]> strArrStream = Arrays.stream(strArr);
        Stream<String> strStream = strArrStream.flatMap(x->Arrays.stream(x));  // this is imporant
        strStream.filter(x->"c".equals(x.toString()))
                 .forEach(System.out::println);

        System.out.println("Example 3");

        String[][] strArr2 = new String[][] {{"a","b"},{"c","d"},{"e","d"}};
        Stream<String[]> strArrStream2 = Arrays.stream(strArr2);
        strArrStream2.filter(x->"c".equals(x.toString()))
                .forEach(System.out::println); // The output is empty since we did not convert into flatMap.

    }
}
