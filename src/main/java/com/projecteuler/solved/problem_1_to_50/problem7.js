// Problem 7

/*
	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

	What is the 10 001st prime number?
*/

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

function prime(idx) {
	// this function looks for the idx-nth prime.
	
	var tabPrimes = [2];
	var n = 3;
	
	while (true) {
		
		var primesTOrF = true; // a number is prime until proven otherwise

		for (var i = 0; i < tabPrimes.length; i++) {
			if (n % tabPrimes[i] == 0) { // this number n is not a prime number ;A;
				primesTOrF = false;		 // gotta put a label on them... NOT PRIME
				break;				     // next candidate! for n
			}
		}
		
		// Survived natural selection... all of n's fellow were exterminated and are not prime.
		tabPrimes.push(n); 	// gotta give it the label PRIME for surviving the battle of the fittest.
	
		if (tabPrimes.length == idx) { // If we reached the idx-nth prime, return it because we're done!
			return tabPrimes.pop();
		}
		
		n++; // next candidate! for n
		
		d = new Date();
		timeAcc += d.getTime() - start - last;
		last = d.getTime() - start;
		
		if (timeAcc/1000 > 1) {
			timeAcc -= 1000;
			console.clear();
			console.log(Math.floor(last/1000) + " seconds have passed.");
		}
	}
	
	return -1;
}

function main() {
	var n = 10001;
	console.log("Result: " + prime(n));
	console.log("It took " + (last/1000) + " seconds.");
}

main();