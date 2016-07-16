package Working

import tools.eulerTools

/**
 * Date: 3/15/11
 * Time: 10:15 PM

 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first
 * names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
 * is the 938th name in the list. So, COLIN would obtain a score of 938  53 = 49714.

 * What is the total of all the name scores in the file?
 *
 */

// Set up
start = System.currentTimeMillis()

helper = new eulerTools()

// Set up our objects.
// A list of triangular numbers, a list of words, and a count of number of hits.
List names = []
List nameValues = []
BigInteger total = 0

// Read in the text file, stripping out the "" marks
File file = new File("EulerFiles\\euler22.txt")
file.eachLine { line ->
    line.split(",").each {
        it = it.substring(1,it.size()-1)
        names.add(it)
    }
}

// Sort names into alphabetical order
names.sort()

// Score each word
names.eachWithIndex { word, x -> nameValues.add(helper.wordToInteger(word) * (x+1)) }

// Total up the score
nameValues.each { total = total + it }

println names[937]
println nameValues[937]

println ("Total Word score = $total")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")