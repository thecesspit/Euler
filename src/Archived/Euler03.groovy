package Archived

import tools.eulerTools

/**
 * Created by IntelliJ IDEA.User: Chris
  PROBLEM :
  The prime factors of 13195 are 5, 7, 13 and 29.

  What is the largest prime factor of the number 600851475143 ?
 */

// Set up
start = System.currentTimeMillis()
helper = new eulerTools()

// x is our searcher, target is the thing we are trying to find (xth prime etc)
int x = 0
long target = 600851475143
boolean flag = true

// Find the factors of the target
fList = helper.factorFinder(target)

println fList

// Starting from the end walk backwards down the list of factors till we hit the first prime.
x = (fList.size())
while(flag)
{
    x=x-1
    if(helper.isPrime(fList[x])){flag = false}
    else{fList[x]=0}
}

println ("The largest prime factor of ${target} is ${fList.max()}")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")