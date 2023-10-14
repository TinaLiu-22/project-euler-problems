// Problem 14

/*

	The following iterative sequence is defined for the set of positive integers:

			n → n/2 (n is even)
			n → 3n + 1 (n is odd)

	Using the rule above and starting with 13, we generate the following sequence:

			13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
			
	It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

	Which starting number, under one million, produces the longest chain?

	NOTE: Once the chain starts the terms are allowed to go above one million.

*/

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;


function problem14(n) {
	
	var max = 0;
	var length;
	var temp, counter;
	
	for (var i = 2; i < n; i++) {
		
		temp = i;
		counter = 0; // Count the number of operations done on temp.
		
		while (temp != 1) { // Keep going until temp is equal to 1.
			
			if (temp % 2 == 0) { // If temp is even.
				temp = temp/2; 
				counter++;
			} else { // If temp is odd.
				temp = 3*temp + 1;
				counter++;
			}
			
			d = new Date();
			timeAcc += d.getTime() - start - last;
			last = d.getTime() - start;
			
			if (timeAcc/1000 > 1) {
				timeAcc -= 1000;
				console.clear();
				console.log(Math.floor(last/1000) + " seconds have passed.");
			}
			
		}
		
		if (counter > max) { // If temp returns a counter bigger than the current max counter.
			max = counter;
			length = i;
		}
	}
	
	return [length, max];
}

function main() {
	var number = 1000000;
	var result = problem14(number);
	console.log("Result: " + result[0] + " (Length is " + result[1] + ")");
	console.log("It took " + (last/1000) + " seconds.");
}

main();