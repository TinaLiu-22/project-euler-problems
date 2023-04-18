package com.projecteuler.problems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a href="https://projecteuler.net/problem=30">Project Euler Problem</a>
 */
public class Problem30_DigitFifthPowers {

    /**
     * @see <a href="https://www.xarg.org/puzzle/project-euler/problem-30/">Calculate the upper bound for number length interval.</a>
     * @param power
     * @param baseDigit
     * @return
     */
    private static int findUpperBoundDigit(int power, int baseDigit) {

        double logN = power * Math.log10(baseDigit);
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
        int power = 5;
        int baseDigit = 9;

        int upperBoundForNumberLength = findUpperBoundDigit(power, baseDigit);
        System.out.format("Upper bound for number length is %d.%n", upperBoundForNumberLength);

        int upperboundForN = (int) (upperBoundForNumberLength * Math.pow(baseDigit, power));
        System.out.format("Upper bound for our search space is %d.%n", upperboundForN);

        List<Double> rangeDigitPower = IntStream.range(0, 10)
                .mapToDouble(i -> Math.pow(i, power))
                .boxed()
                .collect(Collectors.toList());

        int result = IntStream.range(10, upperboundForN + 1)
                .filter(i -> {
                    int temp = i;
                    int sum = 0;
                    while (temp > 0) {
                        sum += rangeDigitPower.get(temp % 10);
                        temp = temp / 10;
                    }
                    return i == sum;
                })
                .peek(System.out::println)
                .sum();

        System.out.printf("The sum of all the numbers that can be written as the sum of fifth powers of their digits is %d.",
                result);
    }
}
