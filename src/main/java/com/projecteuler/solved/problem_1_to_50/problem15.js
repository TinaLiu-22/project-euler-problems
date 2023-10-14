// refer to problem 15 of Project Euler
// https://projecteuler.net/problem=15

// interactive environment ==> codeboot.org

// we suppose grid size is squared...
const height = 20, width = 20;

var grid = [];

var count = 0;

var d = new Date();
var start = d.getTime();
var last = 0;
var timeAcc = 0;

function init() {
	for (var i = 0; i < height + 1; i++) {
		grid.push([]);
		for (var j = 0; j < width + 1; j++) {
			grid[i].push(-1);
		}
	}
}

function dynamicSolve() {
	// Fast execution, but requires O(n^2) memory.
	// Adds the number of paths from the bottom path and from the right path.
	
	init();
	console.log(grid);
	var gridSize = width;
 
	//Initialise the grid with boundary conditions
	for (var i = 0; i < gridSize; i++) { 
		grid[i][gridSize] = 1; 
		grid[gridSize][i] = 1; 
	}

   // initialise grid[gridsize-1][gridsize-1] = 0 and edges along x=gridsize-1 and along y=gridsize-1 to 1

   // Loop for [0,gridsize-2]x[0,gridsize-2]
	for (var i = gridSize - 1; i >= 0; i--) {
		for (var j = gridSize - 1; j >= 0; j--) {
			grid[i][j] = grid[i+1][j] + grid[i][j+1];
		}
	}
	
	console.log(grid[0][0]);
}

function multiplicativeSolve() {
	// Fast execution and no memory use.
	
	var paths = 1;
 
	for (var i = 0; i < width; i++) {
		paths *= (2 * width) - i;
		paths /= i + 1;
	}
	
	return paths;
}

function solve2(x, y) {
	
	// With this method, we understand that a strictly binary node with 2 children will necessarily have a different path and we ignore nodes with
	// only one children.
	d = new Date();
	timeAcc += d.getTime() - start - last;
	last = d.getTime() - start;
	
	if (timeAcc/1000 > 1) {
		timeAcc -= 1000;
		console.clear();
		console.log(Math.floor(last/1000) + " seconds have passed.");
	}
	
	if (inbound(x + 1, y) && inbound(x, y + 1)) {
		
		if (x == 0 && y == 0) {
			count++;
		}
		
		count++;
		
		solve2(x + 1, y);
		solve2(x, y + 1);
	}
	
	return
}

function solve(x, y) {
	
	// Check every possible path.
	
	//print("x:" + x + " y:" + y);

	if (x == width && y == height) {
        //print("found a path");
		count++;
        //print(count);
		return;
	}
    
    //print("case 0:" + inbound(x + 1, y) + " case 1:" + inbound(x, y + 1));
	
	for (var i = 0; i < 2; i++) {
		
		d = new Date();
		timeAcc += d.getTime() - start - last;
		last = d.getTime() - start;
		
		if (timeAcc/1000 > 1) {
			timeAcc -= 1000;
			console.clear();
			console.log(Math.floor(last/1000) + " seconds have passed.");
		}
        
		switch(i) {
			case 0: if (inbound(x + 1, y)) solve(x + 1, y  ); break;
			case 1: if (inbound(x, y + 1)) solve(x, y + 1); break;
		}
	}
    
    return;
}

function inbound(x, y) {
	return 0 <= x && 0 <= y && x <= width && y <= height;
}

function main() {
	
	// Least performant
	//solve(0, 0); console.log("Result: " + count);
	//solve2(0, 0); console.log("Result: " + count);
	
	// Best performant
	//console.log("Result: " + multiplicativeSolve());
	//dynamicSolve(); console.log("Result: " + grid[0][0]);
	console.log("It took " + (last/1000) + " seconds.");
}

main();