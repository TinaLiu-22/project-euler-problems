package com.projecteuler.solved.problem_1_to_50.problem22;// Problem 22

/*
	Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, 
	begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical 
	position in the list to obtain a name score.

	For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
	So, COLIN would obtain a score of 938 × 53 = 49714.

	What is the total of all the name scores in the file?
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

// problem22 takes as granted that all names are upper-cased.
public class problem22 {
	
	private final static String filename = "names.txt";
	
	// Fusion sorting recursively.
	private static ArrayList<String> sort(ArrayList<String> array) {
		
		if (array.size() == 1) {
			return array;
		} else {
			int half = (int) array.size()/2;
			
			// Left side.
			ArrayList<String> left = new ArrayList<>(array.subList(0, half));
			PriorityQueue<String> sortedLeft = new PriorityQueue<>(sort(left));
			
			// Right side.
			ArrayList<String> right = new ArrayList<>(array.subList(half, array.size()));
			PriorityQueue<String> sortedRight = new PriorityQueue<>(sort(right));
			
			// Sort left with right. 
			ArrayList<String> sortedList = new ArrayList<>(array.size());
			for (int i = 0; i < array.size(); i++) {
				
				// If all elements from left has been placed in new list, add the rest from right to new list.
				if (sortedLeft.peek() == null) {
					while (sortedRight.peek() != null) {
						sortedList.add(sortedRight.poll());
					}
				} 
				
				// If all elements from right has been placed in new list, add the rest from right to new list.
				else if (sortedRight.peek() == null) {
					while (sortedLeft.peek() != null) {
						sortedList.add(sortedLeft.poll());
					}
				} 
				
				// Normal case.
				else if ( (sortedLeft.peek()).compareTo(sortedRight.peek()) < 0 ) { // If left element < right element, then add left element to list.
					sortedList.add(sortedLeft.poll());
				} else { // Else, right element < left element. Then add right element to list.
					sortedList.add(sortedRight.poll());
				}
			}
			
			return sortedList;
		}
		
	}

	private static int getASCIIValue(String name) {
		int sum = 0;
		// fixme
//		for (int j = 1; j < name.length() - 1; j++) {
//				sum += alphabetValue.get( name.substring(j, j+1) ); // Add alphabetical value.
//		}

		return sum;
	}
	
	public static void main(String[] args) {
		
		// Create buckets for each letter.
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		HashMap<String, Integer> alphabetValue = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			map.put( Character.toString((char) (i + 65)), new ArrayList<String>() );
			alphabetValue.put( Character.toString((char) (i + 65)), i );
		}
		
		// Read the file.
		FileReader fr = null;
		BufferedReader reader = null;

		try {
			fr = new FileReader(filename);
			reader = new BufferedReader(fr);

			String s = reader.readLine();
			String[] array = s.split(",");
			
			// Place every name in a bucket according to their first letter.
			for (int i = 0; i < array.length; i++) {
				String c = array[i].substring(1,2);
				map.get(c).add(array[i]);
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
		
		// Sort every bucket with fusion sorting algorithm. Ignore the empty buckets.
		ArrayList<String> list = new ArrayList<>();
		for (ArrayList<String> array : map.values()) {
			if (array.size() == 0) continue;
			else list.addAll(sort(array));
		}
		
		// Get the sum for this problem.
		int sum = 0;
		String name;
		for (int i = 0; i < list.size(); i++) {
			sum += getASCIIValue(list.get(i)) * i;
		}
		
		System.out.println("Result: " + sum);
	}
}