import tools.eulerTools

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 2/23/11
 * Time: 9:00 PM
A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */

// Set up
start = System.currentTimeMillis()
helper = new eulerTools()

//Targets
py_sum = 1000
result = []

for(int a = py_sum - 2; a > 2; a --)
{   for(int b = 1; b < (py_sum - a); b++ )
    {   c = py_sum - b - a
        if(helper.isPythag(a,b,c)){ result = result + [[a,b,c]]}
    }
}

println ("The follow pythagorean triples have a sum of $py_sum")
result.each{print it; int product=1; it.each{product = product * it}; println " "+product}

// End
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
