package com.projecteuler.other;

import java.io.*;
import java.util.LinkedList;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Checklist {

    private final static String filename = "src/main/java/com/projecteuler/solved_list.txt";
    private static LinkedList<Integer> list = new LinkedList<>();

	private final static String info = "This program is designed to keep track of a list of problems solved from the ProjectEuler in a naive and simple manner using a switch" 
			+ " and only takes NUMBERS as inputs. As the list gets bigger, a different sorting algorithm is needed to sort the list. It is expected to handle between 600 and 700.";
			
    private final static String[] commands = {
			"remove", "solved", "contain", "list", "sort", "info", "array"
	};
    private final static String[] description = {
            "Remove a problem, no matter the reason. Cannot remove a problem that was never solved. Only takes NUMBERS as input.",
            "Add one or more problem(s) to the solved list. Cannot add a solve problem more than once. Only takes NUMBERS as input.",
            "Check if a problem is already solved. Only takes NUMBERS as input.",
            "Get a list of problem(s) successfully solved so far. Count the number of problem(s) solved.",
            "Sort solved problem(s) in numerical order. Currently implementing the in-situ selection algorithm.",
			"Give a terrible brief description of the program.",
			"Add the numbers between m to n inclusively to the list. WARNING: Do NOT abuse."
    };
	private final static String[] example = {
			"> java Checklist remove 2 (will remove 2 from list)",
			"> java Checklist solved 2 (will add 2 to list)",
			"> java Checklist contain 2 (will check if 2 is in the list)",
			"> java Checklist list", // (will list out all numbers)",
			"> java Checklist sort", // (will sort the numbers from smallest to biggest)",
			"> java Checklist info (will give a terribly simple description of program)",
			"> java Checklist array 2 10 (will add 2 to 10 to the list)"
	};

    private static void printCommands() {

        System.out.println("Commands are:\n");
        for (int i = 0; i < commands.length; i++) {
            System.out.println("	- " + commands[i] + ": " + description[i]);
			System.out.println("		Ex: " + example[i] + "\n");
        }
    }

    private static void  list() {
		
		ArrayList<Integer> tempList = new ArrayList<>(list);
		
		System.out.println("Solved the following problems:");
		int i = 0;
		int count = 0;
		
		for (Integer n : tempList) {
			System.out.print(n + " ");
			count++;
			i++;
			
			if (i == 20) {
				System.out.println();
				i = 0;
			}
		
		}

		System.out.print("\n" + count + " problems solved until now!");
    }

    private static void sort() {

	    long lastnow = System.currentTimeMillis();
		
		ArrayList<Integer> tempList = new ArrayList<>(list);

        int min = Integer.MAX_VALUE, minPointer = 0;
        int pointer = 0;
        boolean switched = true;

        while (switched) {
            switched = false;

            for (int j = pointer; j < tempList.size(); j++) {
				if (tempList.get(j) < min) {
                    min = tempList.get(j);
                    minPointer = j;
                    switched = true;
                    //System.out.println("New min between old " + min + " and new " + tempList[j]);
                }
            }

            if (switched) {
                int temp = tempList.get(pointer);
                tempList.set(pointer, min);
				tempList.set(minPointer, temp);
                //System.out.println("Switching between new min + " + min + " and front pointer " + temp);
            }

            pointer++;
            min = Integer.MAX_VALUE;
        }

        if (pointer == 1) {
            System.out.println("List is already sorted.");
        } else {
			long difference = System.currentTimeMillis() - lastnow;
			System.out.println("It took " + difference + " milliseconds to sort the list");
		}

       list = new LinkedList<>(tempList);
       //System.out.print(list);
    }
	
	private static void addArray(int m, int n) {
		
		ArrayList<Integer> tempList = new ArrayList<>(list);
		
		for (int j = m; j <= n; j++) {
			if ( !tempList.contains(j) ) list.addFirst(j);
			else System.out.println("You already solved problem #" + j + ".");
		}
      
	}

    public static void parse(String[] args) throws NumberFormatException {

        switch(args[0]) {

            case "commands" : printCommands(); break;

            case "remove": // can only remove one at a time
                if ((Integer) parseInt(args[1]) instanceof Integer && !list.isEmpty())
                    list.remove((Integer) parseInt(args[1]));
                break;

            case "solved": // can add more than one.
				for (int i = 1; i < args.length; i++) {
					
					if ((Integer) parseInt(args[i]) instanceof Integer) {

                        if ( !list.contains( parseInt(args[i]) ) )
                            list.add(parseInt(args[i]));
                        else
                            System.out.println("You already solved problem #" + args[i] + ".");
                    }

                }
                break;

            case "contain": // can only verify one at a time.
                if ((Integer) parseInt(args[1]) instanceof Integer) {

                    if ( list.contains( parseInt(args[1]) ) )
                        System.out.println("You solved problem #" + args[1] + ".");
                    else
                        System.out.println("You haven't solved problem #" + args[1] + " yet.");

                }
                break;

            case "list":
				list();
                break;

            case "sort":
				sort();
                break;
				
			case "info":
				System.out.println(info);
				break;
				
			case "array":
				int m = parseInt(args[1]), n = parseInt(args[2]);
				if (m > n) System.out.println("Please input the lower number first, then the second.");
				else addArray(m, n);
				break;

            default: System.out.println("\"" + args[0] + "\" is not a valid command.");
        }

    }

    public static void main(String[] args) {

        FileReader fr = null;
        BufferedReader reader = null;

        try {
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);

            String s;
			int i = 1;
            while ( (s = reader.readLine()) != null) {
				try {
					list.add( parseInt( s.split(" ")[0] ) );
				} catch (NumberFormatException e) {
					System.out.println("Error at line " + i + " in list file " + filename + ". It's not a number.");
					System.exit(1);
				}
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

		try {
			parse(args);
		} catch (NumberFormatException e) {
			System.out.println("One or more user inputs are not numbers.");
		}

		if (args.length > 1 || args[0].equals("sort")) {
			 
			FileWriter fw = null;
			BufferedWriter writer = null;
			
			try {
				fw = new FileWriter(filename);
				writer = new BufferedWriter(fw);

				for (Integer n : list) {
					writer.write("" + n);
					writer.newLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {

				try {
					writer.close();
					fw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
			
		}

    }
}