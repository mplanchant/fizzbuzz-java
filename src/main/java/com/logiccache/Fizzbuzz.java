package com.logiccache;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.base.Preconditions.checkArgument;

public class Fizzbuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String FIZZBUZZ = "fizzbuzz";
    private static final String LUCKY = "lucky";
    private static final String NUMBER = "number";

    public static List<String> of(int start, int end) {
        checkArgument(start > 0, "Argument start was %s but expected to be greater than zero", start);
        checkArgument(end >= start, "Argument end was %s but expected to be greater than or equal to start", end);
        final Map<String, Integer> stats = new HashMap<>();
        final List<String> results = IntStream.rangeClosed(start, end).mapToObj(value -> of(value, stats)).collect(Collectors.toList());
        MapUtils.verbosePrint(System.out, "Fizzbuzz Stats", stats);
        return results;
    }

    private static String of(int number, Map<String, Integer> stats) {
        if (contains3(number)) return updateStats(LUCKY, stats);
        if (divisibleByThreeAndFive(number)) return updateStats(FIZZBUZZ, stats);
        if (divisibleByThree(number)) return updateStats(FIZZ, stats);
        if (divisibleByFive(number)) return updateStats(BUZZ, stats);
        return updateStats(number, stats);
    }

    private static String updateStats(Integer number, Map<String, Integer> stats) {
        stats.put(NUMBER, stats.getOrDefault(NUMBER, 0) + 1);
        return Integer.toString(number);
    }

    private static String updateStats(String key, Map<String, Integer> stats) {
        stats.put(key, stats.getOrDefault(key, 0) + 1);
        return key;
    }

    private static boolean contains3(Integer number) {
        return Integer.toString(number).contains("3");
    }

    private static boolean divisibleByThreeAndFive(Integer number) {
        return divisibleByThree(number) && divisibleByFive(number);
    }

    private static boolean divisibleByThree(Integer number) {
        return number % 3 == 0;
    }

    private static boolean divisibleByFive(Integer number) {
        return number % 5 == 0;
    }
}