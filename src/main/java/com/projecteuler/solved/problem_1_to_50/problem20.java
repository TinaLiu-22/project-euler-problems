/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */

package com.projecteuler.solved.problem_1_to_50;

public class problem20 {

    public static int problem20(int n) {
        int[] res = new int[1000000];
        res[0] = 1;
        int size = 1;

        for (int i = 2; i <= n; i++) {

            //for (int j = size - 1; j >= 0; j--) {
                //System.out.print(res[j]);
            //}
            //System.out.println();

            int carry = 0;
            for (int j = 0; j < size; j++) {
                int product = res[j] * i + carry;
                res[j] = product % 10;
                carry = product / 10;

                //System.out.println("prod = " + product + " carry = " + carry);

                if (j + 1 == size && carry > 0) {
                    size++;
                }
            }

        }

        //for (int j = size - 1; j >= 0; j--) {
        //    System.out.print(res[j]);
        //}
        //System.out.println();

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += res[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(problem20(100));
    }

}
