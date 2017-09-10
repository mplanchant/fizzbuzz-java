package com.logiccache;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.base.Preconditions.checkArgument;


public class Fizzbuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String LUCKY = "lucky";

    public static List<String> of(int start, int end) {
        checkArgument(start > 0, "Argument start was %s but expected to be greater than zero", start);
        checkArgument(end >= start, "Argument end was %s but expected to be greater than or equal to start", end);
        return IntStream.rangeClosed(start, end)
                .mapToObj(Fizzbuzz::of)
                .collect(Collectors.toList());
    }

    private static String of(int number) {
        if (contains3(number)) return LUCKY;
        StringBuilder builder = new StringBuilder();
        if (divisibleByThree(number)) builder.append(FIZZ);
        if (divisibleByFive(number)) builder.append(BUZZ);
        if (builder.length() == 0) builder.append(number);
        return builder.toString();
    }

    private static boolean contains3(int number) {
        return Integer.toString(number).contains("3");
    }

    private static boolean divisibleByThree(int number) {
        return number % 3 == 0;
    }

    private static boolean divisibleByFive(int number) {
        return number % 5 == 0;
    }
}
