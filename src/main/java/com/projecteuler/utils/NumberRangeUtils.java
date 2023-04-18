package com.projecteuler.utils;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumberRangeUtils {

    public static List<BigInteger> bigIntegerRange(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive)
                .mapToObj(BigInteger::valueOf)
                .collect(Collectors.toList());
    }

    public static List<BigInteger> bigIntegerRange(long startInclusive, long endExclusive) {
        return LongStream.range(startInclusive, endExclusive)
                .mapToObj(BigInteger::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Integer> intRange(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Long> longRange(long startInclusive, long endExclusive) {
        return LongStream.range(startInclusive, endExclusive)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Double> doubleRangeFromInt(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive)
                .asDoubleStream()
                .boxed()
                .collect(Collectors.toList());
    }
}
