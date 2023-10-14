// Problem 3

/*
The prime factors of 13195 are 5, 7, 13, 29.

What is the largest prime factor of the number 600 851 475 143?
*/

// interactive environment for testing and debugging ==> codeboot.org 

var tabPrimes = [2];

function primes(limit) {
	// this function looks for all the primes under a chosen limit
	
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
}

function maxPrimeFactor(number) {
	// this function returns the highest prime factor of a chosen integer number
	// warning: it takes a while to find the solution
	// note: can be optimized
	// note: you can test this out with the example they gave, 13195
	
	var factorsOfNum = []; // prime factors only!!
	
	primes(number);
	
	for (var i = tabPrimes.length - 1; i >= 0; i--) {
		if (number % tabPrimes[i] == 0) {
			return tabPrimes[i];
		}
	}
	
	return "False. We could not find a prime factor of " + number + " :(";
}

function main() {
	console.log("It took " + (last/1000) + " seconds.");	
	console.log("Result: " + maxPrimeFactor(600851475143));

}

main();