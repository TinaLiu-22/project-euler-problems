package com.projecteuler.solved.problem_1_to_50;

import com.projecteuler.utils.Utils;

/**
 * <a href="https://projecteuler.net/problem=37">Problem 37</a>
 */
public class problem37_TruncablePrimes {

    public static void main(String[] args) {
        System.out.println(Utils.getTruncatedInteger(11)
                .stream()
                .reduce(0, Integer::sum));
    }
}
