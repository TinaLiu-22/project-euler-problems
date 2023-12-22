package com.projecteuler.problems.active;

import com.projecteuler.utils.MathUtils;

public class problem45 {
    public static void main(String[] args) {
        int Hn = 143;
        int Pn = 165;
        int Tn = 285;

        boolean stop = false;

        for (int x = Hn + 1; ; x++) {
            double tempH = MathUtils.calculateNthHexagonalNumber(x);
            System.out.println("Value of x: " + x);
            for (int y = Pn + 1; MathUtils.calculateNthPentagonalNumber(y) <= tempH + 1; y++) {
//                System.out.println("Value of y: " + y);
                double tempP = MathUtils.calculateNthPentagonalNumber(y);
                if (tempH == tempP) {
                    for (int z = Tn + 1; MathUtils.calculateNthTriangleNumber(z) <= tempH + 1; z++) {
                        System.out.println("Value of z: " + z);
                        double tempT = MathUtils.calculateNthTriangleNumber(z);
                        if (tempH == tempT) {
                            System.out.println("Value of Tn: " + z);
                            System.out.println("Value of Pn: " + y);
                            System.out.println("Value of Hn: " + x);
                            System.out.println("Next triangle-pentagonal-hexagonal number: " + tempH);
                            stop = true;
                        }
                        if (stop) break;
                    }
                }
                if (stop) break;
            }
            if (stop) break;
        }
    }
}
