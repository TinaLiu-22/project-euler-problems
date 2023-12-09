package com.projecteuler.active;

import com.projecteuler.utils.PrimeUtils;

import java.util.List;

public class problem58_SpiralPrimes {

    public static void main(String[] args) {

        List<Long> primes = PrimeUtils.getPrimes().stream().sorted().toList();
        long primeCount = 0;
        long diagonalTotal = 1;
        long n = 1;

        for (long i = 2; i < 1000000; i += 2) {
            for (long j = 0; j < 4; j++) {
                n += i;
                if (PrimeUtils.isPrime(n, primes)) {
                    primeCount++;
                }
            }
            diagonalTotal += 4;
            if (10 * primeCount < diagonalTotal) {
                System.out.println("result: " + (i + 1));
                break;
            }
        }
    }
}
