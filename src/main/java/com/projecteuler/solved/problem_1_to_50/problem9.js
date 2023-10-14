// Problem 9

/*
	A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

							a^2 + b^2 = c^2
							
	For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc.
*/

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

function problem9() {
	
	var c;
	
	// Search all combinations of a and b.
	for (var a = 1; a < 1000; a++) {
		for (var b = 2; b < 1000; b++) {
			
			if ( a < b ) { // If respects first condition
				c = Math.sqrt(a*a + b*b); // Initialise c.
				
				if (c % 1 != 0) { // if c is not an integer, skip.
					continue;
				}
				
				if ( a + b + c == 1000) { // If respects specific condition, we found our solution.
					return [a*b*c, a, b, c]; 
				}
				
			} else { // Else, change b (next combination). 
				continue;
			}
			
			d = new Date();
			timeAcc += d.getTime() - start - last;
			last = d.getTime() - start;
			
			if (timeAcc/1000 > 1) {
				timeAcc -= 1000;
				console.clear();
				console.log(Math.floor(last/1000) + " seconds have passed.");
				console.log("a = " + a + ", b = " + b + ", c = " + c);
			}				
			
		}
	}
	
	return -1;
}

function main() {
	var result = problem9();
	console.log("Result: " + (result[0] == -1 ? "Error!" : result[0]) + " (Factors are " + result[1] + ", " + result[2] + " and " + result[3] + ")");
	console.log("It took " + (last/1000) + " seconds.");
}

main();