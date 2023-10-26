package com.projecteuler.solved.problem_1_to_50;

import com.projecteuler.utils.PrimeUtils;

public class problem7_optimised {



    public static void main(String[] args) {
        for (Integer integer : PrimeUtils.getPrimes(2, 30)) {
            System.out.println(integer);
        }
    }
}
