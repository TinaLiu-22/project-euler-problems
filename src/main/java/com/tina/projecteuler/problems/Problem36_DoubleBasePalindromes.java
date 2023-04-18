package com.tina.projecteuler.problems;

import java.util.stream.IntStream;

import static com.tina.projecteuler.utils.Utils.*;

/**
 * @see <a href="https://projecteuler.net/problem=36">Project Euler Problem</a>
 */
public class Problem36_DoubleBasePalindromes {



    public static void main(String[] args) {
        int result = IntStream.rangeClosed(1, 1000000)
                .filter(i -> isPalindrome(Integer.toString(i)) && isPalindrome(convertIntToBase(i, 2)))
                .sum();

        System.out.println(result);
    }
}
