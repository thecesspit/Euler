package Working

/**
 * Date: 3/15/11
 * Time: 10:15 PM
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

 * By converting each letter in a word to a number corresponding to its alphabetical position and
 * adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
 * If the word value is a triangle number then we shall call the word a triangle word.

 * Using euler42.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common
 * English words, how many are triangle words?
 */

// Set up
import tools.eulerTools

start = System.currentTimeMillis()

helper = new eulerTools()

// Set up our objects.
// A list of triangular numbers, a list of words, and a count of number of hits.
List triangles = []
List words = []
int count = 0

// Populate the triangles with the first 100 triangle numbers
int x = 0
(1..100).each{
    x = x + it
    triangles.add(x)
}

// Read in the text file, stripping out the "" marks
File file = new File("Working.EulerFiles\\euler42.txt")
file.eachLine { line ->
    line.split(",").each {
        it = it.substring(1,it.size()-1)
        words.add(it)
    }
}

//
words.each {
    int wordValue = helper.wordToInteger(it)
    if(triangles.contains(wordValue)){ count = count + 1; print it+" "; println wordValue }
}

println ("Triangular words found = $count")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")