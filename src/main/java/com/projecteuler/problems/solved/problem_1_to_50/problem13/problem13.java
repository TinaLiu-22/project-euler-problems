package com.projecteuler.problems.solved.problem_1_to_50.problem13;// Problem 13

/*
	Work out the first ten digits of the sum of the one-hundred 50-digit numbers in file.txt .
*/

import java.util.ArrayList;
import java.math.BigInteger;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class problem13 {
	
	private final static int nbOfNum = 100;
	private final static String filename = "file.txt";
	
	private static BigInteger sum(ArrayList<BigInteger> array) {
		
		BigInteger sum = BigInteger.ZERO;
		
		for (BigInteger n : array) {
			sum = sum.add(n);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		ArrayList<BigInteger> array = new ArrayList<>(nbOfNum);
		
		FileReader fr = null;
        BufferedReader reader = null;

        try {
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);

			String s;
			int i = 0;
			while ( (s = reader.readLine()) != null ) {
				array.add(new BigInteger(s));
				i++;
			}

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
				reader.close();
				fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
		System.out.println("Result: " + sum(array));
		
	}
}