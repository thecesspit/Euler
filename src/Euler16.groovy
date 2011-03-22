
/**
 * Date: 3/15/11
 * Time: 10:15 PM

2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
 */

// Set up
start = System.currentTimeMillis()

helper = new eulerTools()

// Target is the number to the power of 2 we are interested in
// x is the resultant number we will turn into a string.
int target = 1000
BigInteger result = 0
BigInteger x = 0

x = 2**target
println x
result = helper.totalDigits(x)

println ("The sum of 2^$target digit's is $result")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")