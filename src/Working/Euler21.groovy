package Working

import tools.eulerTools

/**
 * Date: 3/15/11
 * Time: 10:15 PM

    Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
    If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.

    For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
    The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

    Evaluate the sum of all the amicable numbers under 10000.
 */

// Set up
start = System.currentTimeMillis()

// Range is how many numbers to find, target is the number of digits to stop at.
helper = new eulerTools()
def range = 10000
def amicableList = []
def resultList1 = []
def resultList2 = []

// For each number see if we can find an amicable partner
(1..range).each{ int searcher ->

    // Don't bother searching for a number we already have found as amicable
    if(!amicableList.contains(searcher))
    {
        resultList1 = helper.factorFinder(searcher)
        int x = resultList1.sum() - searcher
        // If the sum of the factors is greater than 1, do the reverse factors.
        if(x > 1)
        {   resultList2 = helper.factorFinder(x)
            int y = resultList2.sum() - x
            // If y is equal to the searcher, we have an amicable pair
            if(searcher==y && x != y)
            {amicableList.add(searcher); amicableList.add(x);println amicableList}
        }
    }
}

println amicableList

println ("The sum of all the amicable numbers below $range is ${amicableList.sum()}")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")