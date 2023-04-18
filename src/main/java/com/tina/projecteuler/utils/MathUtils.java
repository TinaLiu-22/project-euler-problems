package com.tina.projecteuler.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class MathUtils {

    public static long factorial(long n) {
        if (n == 0L) {
            return 1;
        }

        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

    public static List<Long> factorialsArray(int n) {
        return LongStream.rangeClosed(0, n)
                .map(MathUtils::factorial)
                .boxed()
                .collect(Collectors.toList());
    }
}
