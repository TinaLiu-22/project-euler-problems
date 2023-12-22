package com.projecteuler.problems.solved.problem_1_to_50;

import com.projecteuler.utils.Utils;

import java.util.stream.IntStream;

/**
 * @see <a href="https://projecteuler.net/problem=36">Project Euler Problem</a>
 */
public class Problem36_DoubleBasePalindromes {

    public static void main(String[] args) {
        int result = IntStream.rangeClosed(1, 1000000)
                .filter(i -> Utils.isPalindrome(Integer.toString(i)) && Utils.isPalindrome(Utils.convertIntToBase(i, 2)))
                .sum();

        System.out.println(result);
    }
}
