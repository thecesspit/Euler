
/**
 * Date: 3/15/11
 * Time: 10:15 PM

 Project Euler problem 14
 The following iterative sequence is defined for the set of positive integers:

    n=n/2 (n is even)
    n=3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:

    13  40  20  10  5  16  8  4  2  1
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
    Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

    Which starting number, under one million, produces the longest chain?

    NOTE: Once the chain starts the terms are allowed to go above one million.
 */

def collatz(long n)
{
    if(n%2 == 0)
    {
        n = (n/2)
        return n
    }
    else
    {   n = (n*3)+1
        return n
    }
}

// Set up
start = System.currentTimeMillis()

// x is our searcher, target is the thing we are trying to find (xth prime etc)
long range = 1000000
int length = 0
int target = 0

// Create a number list of all our numbers we want to look at.
def numberList = []

// Loop through each number, and produce the Collatz sequence.
// Ignore numbers we found already on a sequence.
(1..range).each{ n ->

    loop = 1
    long searcher = n
    size = 1
    result = [(long) n]
    while(loop)
    {
        // If we reach a number we've seen before, add the current sequence size to the list and quit
        if(searcher <= range && numberList[(int) searcher-1])
        {
            numberList[n-1] = result.size()+numberList[(int) searcher-1]-1
            loop = 0
        }
        // If we reach 1, add that to our sequence, save the size into our list, and quit
        if(searcher == 1){
            result.add(searcher)
            numberList[n-1] = result.size()-1
            loop = 0
        }
        // Add the next value to the sequence and repeat
        else
        {
            searcher = collatz(result.last())
            result.add(searcher)
        }

        // For each candidate, create the next value in the sequence

    }
}

println ("The longest Collatz sequence below ${range} is ${numberList.max()} for the number ${numberList.indexOf(numberList.max())}")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")