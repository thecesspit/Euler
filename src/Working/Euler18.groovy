package Working

/**
 By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

 3
 7 4
 2 4 6
 8 5 9 3

 That is, 3 + 7 + 4 + 9 = 23.

 Find the maximum total from top to bottom of the triangle below:

 75
 95 64
 17 47 82
 18 35 87 10
 20 04 82 47 65
 19 01 23 75 03 34
 88 02 77 73 07 63 67
 99 65 04 28 06 16 70 92
 41 41 26 56 83 40 80 70 33
 41 48 72 33 47 32 37 16 94 29
 53 71 44 65 25 43 91 52 97 51 14
 70 11 33 28 77 73 17 78 39 68 17 57
 91 71 52 38 17 14 91 43 58 50 27 29 48
 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 */

import tools.eulerTools

/* set up the script */
start = System.currentTimeMillis()

helper = new eulerTools()

/* Read in the triangle a list of lists */
def triangle = []
File file = new File("EulerFiles\\euler18.txt")
file.eachLine { line -> triangle.add(line.split(" ")) }
println triangle

int rows = triangle.size()
int result = 0

for(int b = 0; b < (2**rows); b++) {

    int sum = 0
    String bin = Integer.toBinaryString(b)
    bin = helper.leftPad(bin,'0',rows)
    int index = 0

    List route = []
    for (int a = 0; a < rows; a++) {
        sum = sum + (triangle[a][index]).toInteger()
        route << index
        index = index + bin[a].toInteger()
    }
    if(sum > result){ result = sum;}
    println([route, sum])
}


/* run a path through the list, taking successive items from each row either from same index, or the index plus one */
/* save this path as a list of indexes */

/* try a brute force approach first */

println("The largest sum of a route top to bottom is: $result ")

// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")