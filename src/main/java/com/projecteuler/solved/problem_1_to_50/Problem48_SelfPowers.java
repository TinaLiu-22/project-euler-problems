package com.projecteuler.solved.problem_1_to_50;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * @see <a href="https://projecteuler.net/problem=48">Project Euler Problem</a>
 */
public class Problem48_SelfPowers {

    public static void main(String[] args) {
        BigInteger modulus = BigInteger.TEN.pow(10);

        LongStream.range(1, 1001)
                .mapToObj(BigInteger::valueOf)
                .map(bigInteger -> bigInteger.modPow(bigInteger, modulus))
                .reduce(BigInteger::add)
                .ifPresent(i -> System.out.println(i.mod(modulus)));
    }
}
