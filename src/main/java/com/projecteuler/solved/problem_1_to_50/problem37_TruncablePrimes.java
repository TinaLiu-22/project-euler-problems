package com.projecteuler.solved.problem_1_to_50;

import com.projecteuler.utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://projecteuler.net/problem=37">...</a>
 */
public class problem37_TruncablePrimes {

    public static List<Integer> getSubstrings(int number) {

        List<Integer> substrings = new ArrayList<>();

        // Get substrings from Right to Left
        for (int i = number; i > 0; i = i / 10) {
            substrings.add(i);
        }

        // Get substring from Left to Right
        int nbOfDigits = Utils.getNbOfDigits(number);
        for (int i = 0; i < nbOfDigits - 1; i++) {
            number = number % (int) Math.pow(10, nbOfDigits - 1 - i);
            substrings.add(number);
        }

        return substrings;
    }

    public static List<Integer> getTruncablePrimes(int nbOfTruncablePrimes) {

        List<Integer> truncablePrimes = new ArrayList<>();
        HashSet<Integer> primes = problem7_optimised.getPrimes(2, 1000000);
        List<Integer> doNotInclude = List.of(2, 3, 5, 7);

        primes.stream()
                .sorted()
                .forEach(p -> {
                    if (!doNotInclude.contains(p) && truncablePrimes.size() < nbOfTruncablePrimes) {
                        List<Integer> substrings = getSubstrings(p);
                        if (primes.containsAll(substrings)) {
                            truncablePrimes.add(p);
                        }
                    }
                });

        System.out.println(truncablePrimes);
        System.out.println(truncablePrimes.size());

        return truncablePrimes;
    }

    public static void main(String[] args) {
        System.out.println(getTruncablePrimes(11)
                .stream()
                .reduce(0, Integer::sum));
    }
}
