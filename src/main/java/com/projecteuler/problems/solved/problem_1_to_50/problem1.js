// Problem 1

/*
If we list all the naturals below 10 that are multiples of 3 or 5, we get 3, 5, 6, and 9.
The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

// interactive environment ==> codeboot.org

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

function sum(tab) { // tab is a table of values
 	return tab.reduce( function(x,y) {return x+y;} ); // add all the values together
}

function sumMultiples(factors, limit) {
  // function uses a table of factors (in this case 3 and 5) and a limit.
  // it evaluates all numbers under the limit value.

  var multiples = []; // record multiples of 3 or of 5

  for (var i=1; i<limit; i++) { // look into numbers below limit value
   	for (var j=0; j<factors.length; j++) { // evaluate each factor with a number i

       	if (i % factors[j] == 0) { // if i divided by a factor gives a whole number
           	multiples.push(i); // then i is a multiple of that factor
            break; // go to the next i
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
  }

  return sum(multiples);
}

function main() {
	console.log("It took " + (last/1000) + " seconds.");
	console.log("Result: " + sumMultiples([3, 5], 1000));
}

main();