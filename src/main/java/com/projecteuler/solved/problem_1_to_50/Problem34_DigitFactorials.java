package com.projecteuler.solved.problem_1_to_50;

import com.projecteuler.utils.MathUtils;

import java.util.List;
import java.util.stream.IntStream;

public class Problem34_DigitFactorials {

    private static int findUpperBoundDigit(int baseDigit) {

        double factN = MathUtils.factorial(baseDigit);
        double logN = Math.log10(factN);
        double logNPlusOne = logN + 1;

        int d = 1;
        double lowerBound;
        double upperBound;

        while (true) {
            double baseBound = d - Math.log10(d);
            lowerBound = baseBound;
            upperBound = baseBound + 1;

            System.out.format("Check interval for d=%d || %f <= %f < %f%n", d, lowerBound, logNPlusOne, upperBound);
            if (lowerBound <= logNPlusOne && logNPlusOne < upperBound) {
                break;
            }

            d++;
        }

        return d;
    }

    public static void main(String[] args) {
        List<Long> factorials = MathUtils.factorialsArray(9);
        int result = IntStream.range(3, (int) Math.pow(10, findUpperBoundDigit(9)))
                .filter((i) -> {
                    int temp = i;
                    int sum = 0;
                    while (temp > 0) {
                        sum += factorials.get(temp % 10);
                        temp = temp / 10;
                    }
                    return i == sum;
                })
                .peek(System.out::println)
                .sum();

        System.out.printf("The sum of all numbers which are equal to the sum of the factorial of their digits is %d.",
                result);
    }
}