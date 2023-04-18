package com.projecteuler.problems;

public class Problem35_CircularPrimes {

    private static double quadraticRoot(double a, double b, double c) {
        double root1, root2;

        // calculate the determinant (b2 - 4ac)
        double determinant = b * b - 4 * a * c;

        // check if determinant is greater than 0
        if (determinant > 0) {

            // two real and distinct roots
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

            System.out.println("root1 = " + root1 + " and root2 = " + root2);
        }

        // check if determinant is equal to 0
        else if (determinant == 0) {

            // two real and equal roots
            // determinant is equal to 0
            // so -b + 0 == -b
            root1 = root2 = -b / (2 * a);
            System.out.print("root1 = " + root1 + " and root2 = " + root2);
        }

        else {
            return -1;
        }

        System.out.println(" returns " + (root1 >= 0 ? root1 : root2));
        return root1 >= 0 ? root1 : root2;
    }

    public static void main(String[] args) {
        //   x^2  +   x  - 2 n  =  0
        // 3 y^2  -   y  - 2 n  =  0
        // 2 z^2  -   z  -   n  =  0

        double n = 40756;
        double rootX, rootY, rootZ;
        while(true) {
            rootX = quadraticRoot(1,  1, -2 * n);
            rootY = quadraticRoot(3, -1, -2 * n);
            rootZ = quadraticRoot(2, -1,        -n);
            if (rootX % 1 == 0 && rootY % 1 == 0 && rootZ % 1 == 0) {
                break;
            }
            n++;
        }
        System.out.println(n);
    }
}
