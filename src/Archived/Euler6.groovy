package Archived
/**
 * Created by IntelliJ IDEA.User: Chris
  PROBLEM :
  The sum of the squares of the first ten natural numbers is,
  1^2 + 2^2 + ... + 10^2 = 385
  The square of the sum of the first ten natural numbers is,
  (1 + 2 + ... + 10)^2 = 552 = 3025
  Hence the difference between the sum of the squares of the first ten natural numbers
  and the square of the sum is 3025-385 = 2640.

  Find the difference between the sum of the squares of the first one hundred natural numbers
  and the square of the sum.
 */

int sumOfSq = 0
int sum = 0
(1..100).each {
  sum = sum + it
  sumOfSq = sumOfSq + (it * it)
}

total = (sumOfSq - (sum * sum)).abs()

println total