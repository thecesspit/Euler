
/**
 * Date: 3/15/11
 * Time: 10:15 PM

    The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

    Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

// Set up
start = System.currentTimeMillis()

helper = new eulerTools()

primeList = helper.primeSieve(10000)

primeList.each{ x = it * it; if(((x-1)%24) != 0){  println "Aha $it fails"}}

// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")