package com.logiccache;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.base.Preconditions.checkArgument;


public class Fizzbuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String FIZZBUZZ = "fizzbuzz";
    private static final String LUCKY = "lucky";

    public static List<String> of(int start, int end) {
        checkArgument(start > 0, "Argument start was %s but expected to be greater than zero", start);
        checkArgument(end >= start, "Argument end was %s but expected to be greater than or equal to start", end);
        List<String> values = IntStream.rangeClosed(start, end)
                .mapToObj(Fizzbuzz::of)
                .collect(Collectors.toList());
        printStatistics(values);
        return values;
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

    private static boolean divisibleByThree(Integer number) {
        return number % 3 == 0;
    }

    private static boolean divisibleByFive(Integer number) {
        return number % 5 == 0;
    }

    private static void printStatistics(List<String> values) {
        int noOfFizz = 0, noOfBuzz = 0, noOfFizzbuzz = 0, noOfLucky = 0, noOfNumber = 0;
        for (String value : values) {
            switch (value) {
                case FIZZ:
                    noOfFizz++;
                    break;
                case BUZZ:
                    noOfBuzz++;
                    break;
                case FIZZBUZZ:
                    noOfFizzbuzz++;
                    break;
                case LUCKY:
                    noOfLucky++;
                    break;
                default:
                    noOfNumber++;
                    break;
            }
        }
        System.out.println("fizz: " + noOfFizz);
        System.out.println("buzz: " + noOfBuzz);
        System.out.println("fizzbuzz: " + noOfFizzbuzz);
        System.out.println("lucky: " + noOfLucky);
        System.out.println("number: " + noOfNumber);
    }
}
