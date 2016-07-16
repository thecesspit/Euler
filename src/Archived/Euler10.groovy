import tools.eulerTools

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 2/23/11
 * Time: 11:57 AM
    * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

    * Find the sum of all the primes below two million.
 */

// Set up
start = System.currentTimeMillis()
helper = new eulerTools()

// x is our searcher, target is the thing we are trying to find (xth prime etc)
int x = 5
long total = 0
long target = 2000000

//  Loop until the biggest number in the primeList is greater than target
//  Seed the prime List with 2 and 3... then skip ahead by 2 each time to avoid trying to work on the even numbers

helper.primeSieve(target).each { it -> total = total + it}

println ("The sum the primes below ${target} is ${total}")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
