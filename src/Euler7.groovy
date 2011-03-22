/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 2/23/11
 * Time: 11:57 AM
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

 * What is the 10001st prime number?
 */

// Set up
start = System.currentTimeMillis()
helper = new eulerTools()

// x is our searcher, target is the thing we are trying to find (xth prime etc)
long x = 3
int target = 10001

//  Loop until the primeList gets big enough.
//  Seed the prime List with 2 and 3... then skip ahead by 2 each time to avoid trying to work on the even numbers
Boolean flag = true
primeList = [2,3]

while(flag)
{
    x=x+2
    if(helper.isPrime(x))
    {
        primeList.add(x)
    }
    if(primeList.size() == target){flag = false}
}

println primeList.size()
println primeList[target-2]
println ("The ${target}th prime is ${primeList.max()}")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
