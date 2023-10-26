package com.projecteuler.solved.problem_1_to_50;

import java.util.HashSet;

public class problem7_optimised {

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

    public static void main(String[] args) {

        for (Integer integer : getPrimes(2, 30)) {
            System.out.println(integer);
        }

    }
}
