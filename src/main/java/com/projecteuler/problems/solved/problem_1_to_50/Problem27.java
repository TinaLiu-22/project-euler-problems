package com.projecteuler.problems.solved.problem_1_to_50;

import com.projecteuler.utils.NumberRangeUtils;
import com.projecteuler.utils.PrimeUtils;

import java.util.List;

public class Problem27 {

    public static void main(String[] args) {
        // |a| < 1000 and |b| < 1000
        // n^2 + an + b > 0
        // n >= 0
        // a = -997 b = 999
        // n = 0, 1000 > b >= 2
        // n > 0, n*n + a*n + b > 1 => 1000n > a*n > 1 - b - n*n => 1000 > a >= 1 + Math.floor((1-b-n*n)/n)

        int bestPrimeCount = 0;
        int bestBValue = 2;
        int bestAValue = 0;
        int iterationCount = 0;
        for (int b = 2; b < 1000; b++) {
            if (!PrimeUtils.isPrime(b)) {
                continue;
            }
            List<Integer> arrayOfA = NumberRangeUtils.intRange(-999, 1000);
            int finalB = b;
            for (int n = 0; arrayOfA.size() > 0; n++) {
                int finalN = n;
                List<Integer> arrayOfPossibleA = arrayOfA.stream()
                        .filter(a -> PrimeUtils.isPrime(finalN*finalN + a* finalN + finalB))
                        .toList();
                if (arrayOfPossibleA.size() == 1 && bestPrimeCount < n) {
                    bestAValue = arrayOfPossibleA.get(0);
                    bestBValue = finalB;
                    bestPrimeCount = n;
                }
                arrayOfA = arrayOfPossibleA;
                iterationCount++;
            }
        }

        System.out.println("Number of iterations: " + iterationCount);
        System.out.println("Value of a: " + bestAValue);
        System.out.println("Value of b: " + bestBValue);
        System.out.println("Value of n: " + bestPrimeCount);
        System.out.println("Product of a and b: " + (bestAValue * bestBValue));
    }
}
