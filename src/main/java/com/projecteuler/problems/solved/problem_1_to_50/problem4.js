function palindrome(n) {
 	var str = n.toString();
    for (var i = 0; i < str.length/2; i++) {
     	if (str[i] === str[str.length - 1 - i]) {
         	continue;   
        } else {
         	return false;   
        }
    }
    
    return true;
}

var max = 0;
for (var i = 999; i > 0; i--) {
    var curr = i*i;
 	for (var j = 0; j < i; j++) {
     	if(palindrome(curr) === true && curr > max) {
            max = curr;
        }
        curr -= i;
    }
}

print(max);