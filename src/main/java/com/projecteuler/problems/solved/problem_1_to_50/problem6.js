// Problem 6

/*
	The sum of the squares of the first ten natural numbers is,

		12 + 22 + ... + 102 = 385
		
	The square of the sum of the first ten natural numbers is,

		(1 + 2 + ... + 10)2 = 552 = 3025
		
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

// Function returns squared x.
function square(x) {
	return x*x;
}

// Function returns the square of sums of numbers under x inclusively. 
function squareOfSum(x) {
	
	var sum = 0;
	
	// Sums.
	while (x > 0) {
		sum += x;
		x--;
	}
	
	// Square of sums.
	sum = square(sum);
	
	return sum;
}

// Function returns the sum of squares of numbers under x inclusively.
function sumOfSquare(x) {
	
	var sum = 0;
	
	// Sum of squares.
	while (x > 0) {
		sum += square(x);
		x--;
	}
	
	return sum;
}

function main() {
	var number = 100;
	var difference = squareOfSum(100) - sumOfSquare(100);
	
	d = new Date();
	last = d.getTime() - start;
	console.log("It took " + (last/1000) + " seconds.");
	
	console.log(difference);
}

main();