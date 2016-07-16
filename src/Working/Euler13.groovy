package Working

import tools.eulerTools

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 6/8/11
 * Time: 9:20 PM
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
(EulerFiles/euler12.txt)

 */

// Set up
start = System.currentTimeMillis()

helper = new eulerTools()

// Target is the sum of the numbers so far
BigInteger target = 0
List Grid = []

// Populate GRID with contents of the file euler11.txt
File file = new File("EulerFiles\\euler13.txt")
file.eachLine { line -> Grid.add(line.split(" ")) }

Grid.each{ target = target + it[0].toBigInteger() }

// Convert output to a string to grab the first 10 digits
String output = target.toString()

// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
println ("Biggest product = ${output[0..9]} ")