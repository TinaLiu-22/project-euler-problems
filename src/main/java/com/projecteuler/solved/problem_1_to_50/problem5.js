// Problem 5

/*
	2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

function smallestMultiple(min, max) {
	
	var num = (max > 16) ? 12000000 : 1; // Specialised variable for this problem. 
	
	continuing:
	while (true) {
		
		d = new Date();
		timeAcc += d.getTime() - start - last;
		last = d.getTime() - start;

		if (timeAcc/1000 > 1) {
			timeAcc -= 1000;
			console.clear();
			console.log("" + num);
			console.log(Math.floor(last/1000) + " seconds have passed.");
		}
	
		// Find an integer that is divisible by numbers between 1 to 20 inclusively.
		// If program successfully finishes for-loop and breaks the while-loop, it means the integer i is divisible by [1 ... 20]
		for (var i = max; i >= min; i--) {
			if (num % i != 0) {
				num++;
				continue continuing;
			}
		}
		
		break;
	}
	
	return num;
}

function main() {
	// Takes 155 seconds to calculate [1, 20]
	var min = 1, max = 20;
	console.log("It took " + (last/1000) + " seconds.");
	console.log("Result: " + smallestMultiple(min, max));
}

main();