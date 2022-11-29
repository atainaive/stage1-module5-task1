package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            return x.stream().allMatch(s -> Character.isUpperCase(s.toCharArray()[0]));
        };

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            x.addAll(x.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()));
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
           return values.stream().filter(s -> Character.isUpperCase(s.charAt(0)))
                   .filter(s -> s.endsWith("."))
                   .filter(s -> s.split(" ").length > 3)
                   .collect(Collectors.toList());
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            return x.stream().collect(toMap(String::toString, String::length));
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {return Stream.concat(list1.stream(), list2.stream()).toList(); };
    }
}

