package com.logiccache;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FizzbuzzTest {

    @Test
    public void test_start_value_0() {
        assertThatThrownBy(() -> Fizzbuzz.of(0, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Argument start was 0 but expected to be greater than zero");
    }

    @Test
    public void test_start_value_less_than_0() {
        assertThatThrownBy(() -> Fizzbuzz.of(-1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Argument start was -1 but expected to be greater than zero");
    }

    @Test
    public void test_finish_value_less_than_start() {
        assertThatThrownBy(() -> Fizzbuzz.of(10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Argument end was 0 but expected to be greater than or equal to start");
    }

    @Test
    public void test_fizzbuzz_of_1() {
        assertThat(Fizzbuzz.of(1, 1))
                .containsExactly("1");
    }

    @Test
    public void test_fizzbuzz_of_1_to_3() {
        assertThat(Fizzbuzz.of(1, 3))
                .containsExactly("1", "2", "lucky");
    }

    @Test
    public void test_fizzbuzz_of_1_to_5() {
        assertThat(Fizzbuzz.of(1, 5))
                .containsExactly("1", "2", "lucky", "4", "buzz");
    }

    @Test
    public void test_fizzbuzz_of_1_to_15() {
        assertThat(Fizzbuzz.of(1, 15))
                .containsExactly("1", "2", "lucky", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "lucky", "14", "fizzbuzz");
    }

    @Test
    public void test_fizzbuzz_of_10_to_15() {
        assertThat(Fizzbuzz.of(10, 15))
                .containsExactly("buzz", "11", "fizz", "lucky", "14", "fizzbuzz");
    }

    @Test
    public void test_fizzbuzz_of_1_to_20() {
        assertThat(Fizzbuzz.of(1, 20))
                .containsExactly("1", "2", "lucky", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "lucky", "14", "fizzbuzz", "16", "17", "fizz", "19", "buzz");
    }
}