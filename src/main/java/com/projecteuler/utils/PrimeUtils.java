package com.projecteuler.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class PrimeUtils {

    public static HashSet<Long> getPrimes() {
        final int SIEVE_SIZE = 10000000;
        return getPrimes(SIEVE_SIZE);
    }

    // Proper Sieve algorithm.
    public static HashSet<Long> getPrimes(int max) {
        HashSet<Long> nonPrimes = new HashSet<>();
        HashSet<Long> primes = new HashSet<>();

        nonPrimes.add(0L);
        nonPrimes.add(1L);

        for (long i = 4; i < max; i += 2) {
            nonPrimes.add(i);
        }

        for (long i = 3; i <= (Math.round(Math.sqrt(max)) + 1); i += 2) {
            if (!nonPrimes.contains(i)) {
                long tmp = i * i;
                while (tmp < max) {
                    nonPrimes.add(tmp);
                    tmp += i << 1; // tmp = tmp + i * 2
                }
            }
        }

        for (long i = 0; i < max; i++) {
            if (!nonPrimes.contains(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

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

    public static boolean isPrime(long n, List<Long> primes) {
        for (long p : primes) {
            if (n < p * p) {
                break;
            }
            if ((n % p) == 0) {
                return false;
            }
        }

        return true;
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

    public static boolean isPrime(int n) {
        return isPrime(n, 4);
    }

    /**
     * <a href="https://www.geeksforgeeks.org/primality-test-set-3-miller-rabin/#">Source</a>
     * It returns false if n is composite and returns true if n is probably prime.  k is an input parameter that determines
     * accuracy level. Higher value of k indicates more accuracy.
     * @param n
     * @param k
     * @return
     */
    public static boolean isPrime(int n, int k) {

        if (n <= 1 || n == 4) {
            return false;
        }

        if (n <= 3) {
            return true;
        }

        int d = n - 1;
        while (d % 2 == 0) {
            d /= 2;
        }

        for (int i = 0; i < k; i++) {
            if (!millerRabinTest(n, d)) {
                return false;
            }
        }

        return true;
    }

    /**
     * This function is called for all k trials. It return false if n is composite and returns true if n is probably
     * prime.
     * <p>
     * The Miller–Rabin primality test or Rabin–Miller primality test is a probabilistic primality test:
     * an algorithm which determines whether a given number is likely to be prime, similar to the Fermat primality test
     * and the Solovay–Strassen primality test. <a href="https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test">(Source)</a>
     * The parameter k determines the accuracy of the test. The greater the number of rounds, the more accurate the result.
     * @param n > 2, an odd integer to be tested for primality.
     * @param d, an odd number such that d*2^r = n-1 for some r >= 1.
     * @return "composite" if n is found to be composite, "probably prime" otherwise.
     */
    public static boolean millerRabinTest(int n, int d) {

        Random rand = new Random();
        int a = 2 + rand.nextInt(1, n - 3);
        int x = MathUtils.power(a, d, n);

        if (x == 1 || x == n-1) {
            return true;
        }

        while (d != n-1) {

            x = (x * x) % n;
            d *= 2;

            if (x == 1) {
                return false;
            }
            if (x == n-1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(9));
    }
}
