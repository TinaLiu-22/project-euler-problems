package com.projecteuler.solved.problem_1_to_50;

import java.util.*;

public class problem12 {

    /**
     * Method that counts how many times a number appears in the list.
     * @param list
     * @return HashMap with K = natural number and V = number of repetitions of K in list.
     */
    public static HashMap<Integer, Integer> getMultipliers(LinkedList<Integer> list) {

        HashMap<Integer, Integer> multipliers = new HashMap<>();

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            int curr = iter.next();
            //System.out.println(curr);
            if (multipliers.containsKey(curr)) {
                multipliers.put(curr, multipliers.get(curr) + 1);
            } else {
                multipliers.put(curr, 1);
            }
        }

        return multipliers;
    }

    public static int problem12(int nth) {

        TreeSet<Integer> primes = problem7_optimised.getPrimes(2, 1000000);

        int current = 0;
        int i = 1;

        LinkedList<Integer> primeFactors = new LinkedList<>();
        while (true) { // For every triangle numbers

            current += i;

            // Find all primes factors of factorisation tree of triangle number.
            int temp = current;
            while (temp != 1) {

                Iterator<Integer> iter = primes.iterator();
                while (iter.hasNext()) { // Check every prime.
                    int currPrime = iter.next();
                    if (temp % currPrime == 0) { // If prime is factor of triangle number, include.
                        primeFactors.add(currPrime);
                        temp /= currPrime;
                        break;
                    }
                }
            }

            HashMap<Integer, Integer> multipliers = getMultipliers(primeFactors); // Count repetitions.

            int nbComb = 1;
            Collection<Integer> values = multipliers.values();

            for (Integer value : values) {
                nbComb *= (value + 1); // If 2 times prime 3, then 3 can be to the power of [0, 1, 2].
            }

            if (nbComb > nth) { // If found the answer.
                return current; // Send current.
            } else {
                i++;
                primeFactors = new LinkedList<>();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(problem12(500));
    }

}
