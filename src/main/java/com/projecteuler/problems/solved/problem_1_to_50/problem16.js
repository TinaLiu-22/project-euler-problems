// Problem 16
/*
 
    2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 
    What is the sum of the digits of the number 2^1000?
 
*/

var res = []; // Because there is a limit number of bits. Store and evaluate each digit
			  // in an array. 
var n = 1000;

res.push(1); // init

var carry;
var prod;
for(var i = 0; i < n; i++) { // Number of shifts.
    carry = 0; // reset for every evaluation.
 	for(var j = 0; j < res.length; j++) {
     	prod = res[j] * 2 + carry; // Multiple by 2 + the carry from previous digit
        res[j] = prod % 10; // Store the last digit of prod.
        prod += ""; // Convert to string for extraction of digits other than the last.
        if (prod.length > 1) { // If more than one digit, then guaranteed a carry.
         	var temp = ""; 
            for (var k = 0; k < prod.length - 1; k++) { // Extract all digits besides the last.
                temp += prod[k];
            }
            carry = +temp; // Let new carry value be the numerical value of temp.
        } else {
         	carry = 0; // No carry if prod is one digit. 
        }
        if (j == res.length - 1 && carry != 0) { // Add a digit slot.
            res.push(0);
        }
    }
}

// Sum the digits. 
var sum = 0;
for(var i = res.length - 1 ; i >= 0; i--) {
 	sum += res[i]; 
}

print(sum);