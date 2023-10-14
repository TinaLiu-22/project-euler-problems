// Problem 17

/*

	If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

	If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


	NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

*/

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

const ones = ["zero", "one", "two", "three", "four",
			  "five", "six", "seven", "eight", "nine",
			  "ten", "eleven", "twelve", "thirteen", "fourteen",
			  "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"];
const tens = ["twenty", "thirty", "forty", "fifty", "sixty", "seventy",
			  "eighty", "ninety"];
const hun = "hundred", thou = "thousand";
const and = "and";

function number(n, range) {
	
	if (range == 1000) { // Thousands
		
		if (n != 0) { 
			return ones[n] + " " + thou;
		}
		
	} else if (range == 100) { // Hundreds
		
		if (n != 0) {
			return ones[n] + " " + hun;
		}
		
	} else if (range == 1) { // Tens and ones.
		
		if (n < 20) { // As defined in ones[].
			return ones[n];
		} else { // Tens: ninety, eighty, etc.
			// Find ten-unit and shift by two to the left. If has one-unit, add the ones[] else nothing.
			return tens[Math.floor(n/10) - 2] + (n % 10 == 0 ? "" : "-" + ones[n % 10]);
		}
		
	}
	
	return "";
}

function problem17(n) {
	
	var counter = 0;
	var temp;
	var string;
	var div;
	
	while (n > 0) {
		
		temp = n;
		string = "";
		div = 1000;

		for (var i = 0; i < 3; i++) {
            
            var digit = Math.floor(temp/div);
			if (digit == 0) {
                // Nothing on this unit, then skip.
            } else { 
                string +=  number(digit, div); // Get textual representation of digit in range of div.
                temp = n % div; // Get the remainder after digit. 

                if (temp == 0) { // If there's nothing after digit, then no point in finding the textual representation.
                    break;

                } else { // Else, keep going.
                    string += " " + and + " ";   
                }
            }

			
			if (i == 1) { // Next is tens and ones.
				div /= 100;
			} else { // Next is hundreds.
				div /= 10;
			}
		}
        
		// Get the length of string, exluding space and hyphens.
        for (var i = 0; i < string.length; i++) {
            if (string[i] != "-" && string[i] != " ") {
             	counter++;
            }
        }
		
		n--;
		
		d = new Date();
		timeAcc += d.getTime() - start - last;
		last = d.getTime() - start;
		
		if (timeAcc/1000 > 1) {
			timeAcc -= 1000;
			console.clear();
			console.log(Math.floor(last/1000) + " seconds have passed.");
		}
	}
	
	return counter;
}

function main() {
	var n = 1000;
	console.log("Result: " + problem17(n));
	console.log("It took " + (last/1000) + " seconds.");
}

main();