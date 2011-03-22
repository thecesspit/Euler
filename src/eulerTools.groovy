
/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 2/10/11
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
class eulerTools {

    //Constructor
    eulerTools()
    { assert true }
    // Returns a list of primes from 2 to x
    def primeSieve(long x)
    {
        // Using a prime sieve to create a list of primes up to x
        // Create a list of all numbers in the range
        // 0 and 1 are not prime, all non-primes are set to 0.
        def numberList = (0..x).flatten()
        numberList[0]=0; numberList[1]=0;
        // Find the maximum value we need to check values for
        def primeT = Math.sqrt(numberList.size())
        //Create all the odd numbers from 3 to primeT, plus 2 (to clean out the evens)
        //The sieve does contain non-primes but we ignore those in  the next step
        def sieve = [2,(3..primeT).step(2)].flatten()
        sieve.each{ n ->
            // Check first we haven't already sieved out this number.  If we have, we know it's a non-prime
            if(numberList[n])
            {   // Create a tempList to filter out
                int stepSize = (n==2?1:2) * n;
                int start = n*n
                int end = numberList.size
                def tempList = (start..end).step(stepSize)
                tempList.each {numberList[it] = 0 }
            }
        }
        // Return all the values that are no longer 0 (which should be the primes).
        return numberList.findAll({ it })
    }

    // Returns a list of factors
    def factorFinder(long x)
    {
        List fList = []
        long primeT = Math.sqrt(x)
        (1..primeT).each{ long test ->
            if(x%test == 0)
            {   if(!fList.contains(test)){fList.add(test)}
                long y = x/test
                if(!fList.contains(y)){fList.add(y)}
            }
        }
        return fList.sort()
    }

    // Returns TRUE if number is palindromic
    def isPalindrome = { long x ->
      String left = x.toString()
      String right = left.reverse()
      if(left == right)
      {
            return true
      }
      return false
        }

    // Returns TRUE if number is prime
    def isPrime(long x)
    {
        long primeT = Math.sqrt(x)
        def checkList = primeSieve(primeT+1)

        for(int i in checkList)
        {   if(x%i == 0){ return false } }
        return true
    }

    //Returns TRUE is the triple passed is a pythagorean triple
    def isPythag(int a, int b, int c)
    {
        if(!a || !b || !c)
        { return false }
        if( (a < b) || (a < c))
        { return false }
        if( (a*a) == (b*b + c*c))
        { return true }
        else {return false}
    }

    //Returns the total of all the digits in a number
    def totalDigits(BigInteger x)
    {
        def powerString = x.toString()
        int result = 0
        powerString.each{ result = result + it.toInteger() }
        return result
    }

    //Returns the factorial of x
    BigInteger factorial(int x)
    {
        BigInteger result = 1
        (1..x).each{ result = it * result }
        return result
    }
}
