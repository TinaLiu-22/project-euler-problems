package com.projecteuler.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrimeUtils {

    public static HashSet<Integer> getPrimes(int min, int max) {

        HashSet<Integer> nonPrimes = new HashSet<>();
        HashSet<Integer> primes = new HashSet<>();

        for (int i = min; i <= max; i++) { // Evaluate each natural numbers.

            //System.out.println("i = " + i);

            if (nonPrimes.contains(i)) { // If already labeled as not prime, skip.
                //System.out.println("i = " + i + " nonprimes.contains(i)");
                continue;
            }

            //System.out.println("i = " + i + " primes.add(i)");
            primes.add(i); // It is necessarily a prime.

            // Find all multiples of i.
            int j = 2;
            int num;
            while (true) {
                num = j * i; // j-nth multiple of i.

                if (num > max) { // If exceeded limit, stop loop.
                    //System.out.println("num = " + num + " num > max");
                    break;
                }

                //System.out.println("num = " + num + " nonPrimes.add(num)");
                nonPrimes.add(num); // New non prime.

                j++; // Next multiple of i.
            }

        }

        return primes;
    }

    public static List<Integer> getTruncablePrimes(int nbOfTruncablePrimes) {

        List<Integer> truncablePrimes = new ArrayList<>();
        HashSet<Integer> primes = getPrimes(2, 1000000);
        List<Integer> doNotInclude = List.of(2, 3, 5, 7);

        primes.stream()
                .sorted()
                .forEach(p -> {
                    if (!doNotInclude.contains(p) && truncablePrimes.size() < nbOfTruncablePrimes) {
                        List<Integer> substrings = Utils.getTruncatedInteger(p);
                        if (primes.containsAll(substrings)) {
                            truncablePrimes.add(p);
                        }
                    }
                });

        System.out.println(truncablePrimes);
        System.out.println(truncablePrimes.size());

        return truncablePrimes;
    }
}
