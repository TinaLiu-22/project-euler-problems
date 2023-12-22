package com.projecteuler.problems.solved.problem_1_to_50;

import com.projecteuler.utils.PermutationUtils;
import com.projecteuler.utils.PrimeUtils;

import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://projecteuler.net/problem=35">Problem link</a>
 */
public class Problem35_CircularPrimes {

    public static HashSet<Integer> getCircularPrimes(int min, int max) {

        HashSet<Integer> circularPrimes = new HashSet<>();

        HashSet<Integer> primes = PrimeUtils.getPrimes(min, max);
        primes.stream()
                .sorted()
                .forEach(i -> {
                    if (!circularPrimes.contains(i)) {
                        List<Integer> permutations = PermutationUtils.getDigitCircularPermutations(i);
                        if (!permutations.isEmpty() && primes.containsAll(permutations)) {
                            circularPrimes.addAll(permutations);
                            permutations.forEach(primes::remove);
                        }
                    }
                });

        return circularPrimes;
    }

    public static void main(String[] args) {
        System.out.println(getCircularPrimes(2, 1000000).size());
    }
}
