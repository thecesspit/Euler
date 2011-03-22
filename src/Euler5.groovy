/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 2/23/11
 * Time: 11:57 AM
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

// Set up
start = System.currentTimeMillis()
helper = new eulerTools()

// x is our searcher, we know it is a multiple of the target.
long x = 0
long step = 1
long target = 20

// Keep looping with flag is true
// check sizeOf lists and max and min item in list
// as list is sorted if max = Target and size = target, when these both are true, we've found our number
Boolean flag = true
def matchList = []

// Find the primes from 1 to target and use that as a start point to search from.
prime = helper.primeSieve(target)
prime.each { step = step * it}
x = step

while(flag == true)
{
    x = x+step
    matchList = helper.factorFinder(x)
    // Filter up to the targer
    matchList = matchList.findAll{it <= target}
    if(matchList.size == target && matchList.min() == 1 && matchList.max() == target)
    {
        println ("$x  $matchList  $matchList.size ${matchList.min()} ${matchList.max()}")
        flag = false
    }
}

println ("Lowest value with  1 to $target factors is : $x")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
