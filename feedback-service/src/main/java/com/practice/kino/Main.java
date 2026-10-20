package com.practice.kino;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, null);
        Map<Integer, Boolean> mappedNumbers = mapEvenNumbers(input);
        System.out.println("Result: " + mappedNumbers);
    }

    public static Map<Integer, Boolean> mapEvenNumbers(List<Integer> numbers) {
        Map<Integer, Boolean> map = new HashMap<>();
        return numbers.stream()
                .filter(i -> i != null)
                .collect(Collectors.toMap(i -> i, i -> i % 2 == 0));
    }
}
