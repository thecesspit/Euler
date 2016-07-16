package Working

/**
 * Date: 3/15/11
 * Time: 10:15 PM

The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?
 */

// Set up
start = System.currentTimeMillis()

// Range is how many numbers to find, target is the number of digits to stop at.
int target = 100

// Create a fibonacci sequence.

BigInteger x = 1
BigInteger y = 1

int searcher = 2

while(x.toString().size() < target)
{
    searcher++
    BigInteger newValue = x+y
    y = x
    x = newValue
    println ("$x , ${x.toString().size()}")
}

println ("First number with $target digits is $x at term $searcher")
// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")