// *****Codeboot.org*****

// Base 10 conversion to base factorial
// https://en.wikipedia.org/wiki/Factorial_number_system
// Reference https://www.xarg.org/puzzle/project-euler/problem-24/

// Given str, a sequence of length n where n_i in arr = {0, 1, ..., n-1} only appears once.
// Given a k-th permutation in lexicographic order. 
// Convert k (base 10) to base factorial
// Iterate on each digit of k in base factorial from left to right. 
// For each digit k_i in k base factorial, get arr[k_i] and concat it to str[n-1-i]
// Remove arr[k_i] from arr.

function factorial(n) {
 	if (n == 1) return n;
    else return factorial(n-1) * n;
}

function problem24(seq, nth) {
    if (nth >= factorial(seq.length)) return -1;
    
    var fnth = decimal_to_factorial(nth-1) + ""; // factorial base
    
    var res = 0;
    var idx = Math.pow(10, seq.length - 1);
    
	for (var i = 0; i < fnth.length; i++) {
        var next = +fnth[i]; 
     	res += seq[next] * idx;
        seq.splice(next,1); // remove this digit
        //print(seq);
        idx /= 10;
    }
    
    return res;
}

function decimal_to_factorial(n) {
    var res = 0;
    var i = 1;
    var idx = 1;
    while (n != 0) {
        var temp = n % idx;
        res += temp * i;
        
        n = Math.floor(n / idx);
        i *= 10;
        idx++;
    }
    return res;
}

function main() {
 	var seq = [0,1,2,3,4,5,6,7,8,9];
    var nth = 1000000;
    var res;
    if((res = problem24(seq, nth)) === -1) {
     	//print("error: " + nth + "th permutation doesn't exist");   
    } else {
     	//print(nth + "th permutation of length " + seq.length + " is " + res);
    }
}
main();
//print(decimal_to_factorial(463));