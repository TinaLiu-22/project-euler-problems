package com.projecteuler.solved.problem_1_to_50;

import java.util.Iterator;
import java.util.TreeSet;

public class problem7_optimised {

    static final int min = 2;
    static final int max = 1000000;

    public static TreeSet<Integer> getPrimes(int min, int max) {

        TreeSet<Integer> nonPrimes = new TreeSet<>();
        TreeSet<Integer> primes = new TreeSet<>();

        //primes.add(1);

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

                if (!nonPrimes.contains(num)){
                    //System.out.println("num = " + num + " nonPrimes.add(num)");
                    nonPrimes.add(num); // New non prime.
                }

                j++; // Next multiple of i.
            }

        }

        return primes;
    }

    public static void main(String[] args) {

        Iterator<Integer> iterator = getPrimes(2, 30).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
