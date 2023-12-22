package com.projecteuler.problems.solved.problem_1_to_50.problem18;

/*

By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

	   3*
	  7* 4
	 2 4* 6
	8 5 9* 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

				      75
				     95 64
				    17 47 82
			       18 35 87 10
			      20 04 82 47 65
			    19 01 23 75 03 34
			   88 02 77 73 07 63 67
		      99 65 04 28 06 16 70 92
		    41 41 26 56 83 40 80 70 33
		   41 48 72 33 47 32 37 16 94 29
	      53 71 44 65 25 43 91 52 97 51 14
	    70 11 33 28 77 73 17 78 39 68 17 57
	   91 71 52 38 17 14 91 43 58 50 27 29 48
	 63 66 04 68 89 53 67 30 73 16 69 87 40 31
	04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a 
triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class problem18 {

	private String filename;

    private ArrayList<Integer[]> pyramid = new ArrayList<>();
    private int listSize;

    private int maxSum;

    public problem18(String filename) {
		this.filename = filename;
        read();
    }

    public int getMaxSum() {
        return maxSum;
    }

    public int solve() {

        int[][] path = new int[listSize][];
        int[][] stateOpt = new int[listSize][];

        for (int i = 0; i < listSize; i++) {

            stateOpt[i] = new int[pyramid.get(i).length];
            path[i] = new int[pyramid.get(i).length];

            // Initialise last row.
            if (i == listSize - 1) {

                Integer[] temp = pyramid.get(i);
                for (int j = 0; j < temp.length; j++) {
                    stateOpt[i][j] = temp[j];
                }
            }

        }

        boolean first = true;
        for (int i = listSize - 2; i >= 0; i--) { // go through every row.

            //System.out.println(i); // todo remove.

            Integer[] temp = pyramid.get(i); // Get state options.
            int[] stateTemp = stateOpt[i+1]; // Get optimised options from next state.

            for (int j = 0; j < temp.length; j++) { // go through every element of row.

                int left = temp[j] + stateTemp[j]; // sum with bottom left number.
                int right = temp[j] + stateTemp[j + 1]; // sum with bottom right number.

                // Maximum value.
                if (left > right) {
                    path[i][j] = 0;
                    stateOpt[i][j] = left;
                } else {
                    path[i][j] = 1;
                    stateOpt[i][j] = right;
                }

            }

        }

        maxSum = stateOpt[0][0];

        return maxSum;
    }

    public void read() {

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);

            String s;
            while ( (s = reader.readLine()) != null) {

                String[] t = s.split(" " );
                Integer[] n = new Integer[t.length];

                for (int i = 0; i < t.length; i++) {
                    n[i] = Integer.parseInt(t[i]);
                }

                pyramid.add(n);
                listSize = pyramid.size();

            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {

        String string = "";

        for (Integer[] n : pyramid) {
            for (int i = 0; i < n.length; i++) {
                string += n[i] + " ";
            }
            string += "\n";
        }

        return string;
    }

    public static void main(String[] args) {

        long last = System.currentTimeMillis();

        System.out.println("Result: " + (new problem18("p067_triangle.txt")).solve());

        long now = System.currentTimeMillis();
        long delta = now - last;
        System.out.println("It took " + delta + " milliseconds.");
    }
}
