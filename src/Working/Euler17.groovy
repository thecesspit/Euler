package Working

/**
 * Created by Chris on 2016-07-17.
 *
 * If the numbers 1 to 5 are written out in words: one, two, three,
 * four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were
 * written out in words, how many letters would be used?
 *
 */

import tools.eulerTools

/* set up the script */
start = System.currentTimeMillis()

helper = new eulerTools()

/* Write code to change number into a word string */

def String intToWords(int x) {

    String[] numNames = [
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"]

    String[] tensNames = [
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    ];

    if((x >= 9999) || (x < 0) ) {
        return "fail"
    }

    else {
        def finalString = ""
        def intString = x.toString()

        // see how long intString is, if only 1 digit long, we can just return straight from to number
        if(intString.length() == 1)
        {
            return(numNames[x])
        }

        // Instead if intString is at least 2 digits long, lets look at the last two digits.
        def tensAndOnes = intString[-2..-1].toInteger()

        if(tensAndOnes < 20)
        {
            finalString = finalString + numNames[tensAndOnes]
        } else {
            // Instead if twenty of more, use the absolute value to find the tens and ones
            finalString = finalString + tensNames[(int) (tensAndOnes/10)]
            finalString = finalString + numNames[(tensAndOnes)%10]
        }

        if(intString.length()> 2)
        {
            def hundreds = intString[-3].toInteger()
            finalString = numNames[hundreds] + ' hundred and' + finalString
        }

        if(intString.length() > 3)
        {
            def thousands = intString[-4].toInteger()
            finalString = numNames[thousands] + ' thousand and' + finalString
        }

        return finalString
    }



}

/* Do this for 1 - 1000, and count each string */
int letterCount = 0
int total = 1000

for(def a = 1; a <= total; a++){
    def wordNumber = intToWords(a)
    letterCount += wordNumber.findAll { it != " "}.size()
    println letterCount
}

println("Number of letters in all the numbers 1 to $total is: $letterCount")


// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")


