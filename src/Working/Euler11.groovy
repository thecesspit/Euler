package Working

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 6/8/11
 * Time: 9:20 PM
 In the 20x20 grid at Eulerfiles/euler11.txt, four numbers along a diagonal line have been marked in red.

    The product of these numbers is 26  63  78  14 = 1788696.

    What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally)
    in the 20x20 grid?
 */

// Set up
start = System.currentTimeMillis()

helper = new tools.eulerTools()

// Target is the largest multiplier found so far.
// targetList is 4 numbers that make that biggest number
// Grid is the 20x20 grid we need to tranverse.
int target = 0
List targetList = []
def Grid = []

// Populate GRID with contents of the file euler11.txt
File file = new File("EulerFiles\\euler11.txt")
file.eachLine { line -> Grid.add(line.split(" ")) }

// First lets look at each line
Grid.each{ line ->
    (0..line.size()-4).each{
        int x = 1
        // Look at each 4 item segement of the line
        line[it..it+3].each{ x = x * it.toInteger() }
        if(x > target) { target = x; targetList = [x, line, it] }
        }
    }

// Next look at the columns
def segment = []
int i, j
for(i = 0; i < 17; i++)
    {
        for(j = 0; j < 20; j++)
        {
            int x = 1
            (0..3).each{ segment.add(Grid[i+it][j])}
            segment.each{ x = x * it.toInteger() }
            if(x > target) { target = x; targetList = [x, segment, i, j] }
            segment = []
        }
    }

// Finally look at the diagonals
for(i = 0; i < 17; i++)
    {
        for(j = 0; j < 17; j++)
        {   // First going down and left
            int x = 1
            (0..3).each{ segment.add(Grid[i+it][j+it])}
            segment.each{ x = x * it.toInteger() }
            if(x > target) { target = x; targetList = [x, segment, i, j] }
            segment = []

            x = 1
            (0..3).each{ segment.add(Grid[i+it][j+3-it])}
            segment.each{ x = x * it.toInteger() }
            if(x > target) { target = x; targetList = [x, segment, i, j] }
            segment = []
        }
    }


// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
println ("Biggest product = $target, Location = $targetList ")