package Archived
/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 2/23/11
 * Time: 11:57 AM
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.

 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

helper = new eulerTools()
int maxPalindrome = 0
start = System.currentTimeMillis()

(100..999).each{ x ->
    (x..999).each{ y ->
        if(helper.isPalindrome(x*y))
        {   if( x*y > maxPalindrome)
            {maxPalindrome = x*y}
        }
    }
}
println ("Elapsed Time = ${(System.currentTimeMillis() - start)/1000} seconds")
println helper.isPalindrome(maxPalindrome)
println maxPalindrome