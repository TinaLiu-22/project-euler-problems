package com.projecteuler.utils;

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

    public static double quadraticRoot(double a, double b, double c) {

        double root1, root2;

        // calculate the determinant (b2 - 4ac)
        double determinant = b * b - 4 * a * c;

        // check if determinant is greater than 0
        if (determinant > 0) {

            // two real and distinct roots
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

//            System.out.println("root1 = " + root1 + " and root2 = " + root2);
        }

        // check if determinant is equal to 0
        else if (determinant == 0) {

            // two real and equal roots
            // determinant is equal to 0
            // so -b + 0 == -b
            root1 = root2 = -b / (2 * a);
//            System.out.print("root1 = " + root1 + " and root2 = " + root2);
        }

        else {
            return -1;
        }

//        System.out.println(" returns " + (root1 >= 0 ? root1 : root2));
        return root1 >= 0 ? root1 : root2;
    }
}
