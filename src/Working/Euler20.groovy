package Working

import tools.eulerTools

/**
 * Date: 3/15/11
 * Time: 10:15 PM

    n! means n  (n  1)  ...  3  2  1

    For example, 10! = 10  9  ...  3  2  1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
 */

// Set up
start = System.currentTimeMillis()

helper = new eulerTools()

// Target is the number to factorial
// x is the resultant number we will add digits together for
int target = 100
BigInteger result = 0
BigInteger x = 0

x = helper.factorial(target)
println x
result = helper.totalDigits(x)

println ("The sum of $target! digit's is $result")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")