// Problem 10

/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

// interactive environment for testing and debugging ==> codeboot.org 

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

function primes(limit) {
	// this function looks for all the primes under a chosen limit
	
	var tabPrimes = [2];
	
	var n = tabPrimes[tabPrimes.length-1]; // start looking for primes from
										   // the biggest prime already added
										   // to the table
	
	while (n < limit) { // as long as the prime is under the chosen limit
		
		var primesTOrF = true; // a number is prime until proven otherwise

		for (var i=0; i<tabPrimes.length; i++) {
			if (n % tabPrimes[i] == 0) { // this number n is not a prime number ;A;
				primesTOrF = false;		 // gotta put a label on them... NOT PRIME
				break;				     // next candidate! for n
			}
		}
		
		if (primesTOrF) { 		// if the number n is a prime (YAY! :D)
			tabPrimes.push(n); 	// gotta give it the label PRIME :D
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
	
	return tabPrimes;
}

function primesSum(limit) {
	
	var tabPrimes = primes(limit);
	console.log("It took " + (last/1000) + " seconds.");
	
	return tabPrimes.reduce(function (x,y) {return x+y;});
}

function main() {
	var number = 2000000;
	console.log("Result: " + primesSum(number));
	
}

main();