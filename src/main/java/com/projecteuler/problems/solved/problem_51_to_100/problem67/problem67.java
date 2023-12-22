package com.projecteuler.problems.solved.problem_51_to_100.problem67;

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with 
one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! 
If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm 
to solve it. ;o)
*/

// Can re-use problem18.java. Backtracking with dynamic programming.

import com.projecteuler.problems.solved.problem_1_to_50.problem18.problem18;

public class problem67 {
	
	public static void main(String[] args) {
	
		long last = System.currentTimeMillis();

		System.out.println("Result: " + (new problem18("triangle.txt")).solve());

		long now = System.currentTimeMillis();
		long delta = now - last;
		System.out.println("It took " + delta + " milliseconds.");
	
	}
}

