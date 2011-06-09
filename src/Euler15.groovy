import java.lang.reflect.Array

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 6/8/11
 * Time: 9:20 PM
Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.
How many routes are there through a 20x20 grid?

 */

// Set up
start = System.currentTimeMillis()

helper = new eulerTools()

// Result is the number of routes
// Size is the size of the grid we are testing.
BigInteger result = 0
int size = 20

// Create a Grid that is size+1 x size + 1.
List grid = []
(0..size).each{ x -> temp = []
    // For the first row, make all the values 1
    if(!x) { (0..size).each{ temp.add(1)} }
    // For the rest the value is the sum of the values above and to the left
    if(x)
    {   temp.add(1)
        (1..size).each{ y ->
        BigInteger val = grid[x-1][y] + temp[y-1]
        temp.add(val)
        }
    }
    grid.add(temp)
}

// Result is the bottom right corner of the grid
result = grid[size][size]
grid.each{ println it}

// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
println ("Number of routes = ${result} ")