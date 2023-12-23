package com.projecteuler.problems.solved.problem_1_to_50;

public class problem26 {

    public static void main(String[] args) {

        int upperBound = 1000;
        int bestDigitCount = 0;
        int bestDenominator = 0;

        for (int d = 2; d < upperBound; d++) {
            if (d % 2 == 0 || d % 5 == 0) {
                continue;
            }

            int a = 1;
            int digitCount = 0;
            do {
                a = a * 10 % d;
                digitCount++;
            } while (a != 1); // if it comes back to 1, we know the same sequence of digits will follow

            if (bestDigitCount < digitCount) {
                bestDigitCount = digitCount;
                bestDenominator = d;
            }
        }

        System.out.println(bestDigitCount);
        System.out.println(bestDenominator);
    }
}
