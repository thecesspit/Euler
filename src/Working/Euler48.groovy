package Working

/**
 * Date: 3/15/11
 * Time: 10:15 PM

    The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

    Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

// Set up
start = System.currentTimeMillis()

// Target is the sequence to add together
// x is the resultant number we will add digits together for
int target = 1000
BigInteger result = 0

(1..target).each{ result = result + (BigInteger) it**it}
println result

String resultString = result.toString()
println resultString.size()

println ("The last ten digits are ${resultString.substring(resultString.size()-10, resultString.size())}")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")