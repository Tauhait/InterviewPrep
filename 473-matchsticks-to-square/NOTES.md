base case:
len < 4 : return false (there must be atleast 4 matchsticks)
You want to use all the matchsticks to make one square.
prevsum % 4 == 0 : return true (prefix sum)
sort all matchsticks in reverse order, will find the largest matchstick
pick matchsticks until it forms a sq or backtrack
maintain a same sized boolean array to track if a certian matchstick is used or can use a queue
try out all possibiites from the queue of matchsticks and try to form a valid config
basically we need to find out the order in which we need to pick and arrange the matchsticks in
a 4 equal sided structure
or we can say we need to group all the array elements into 4 groups each having same sum
​
We know that we will have 4 different subsets.
The sum of elements of these subsets would be 1/4 sum_{arr}
If the sum if not divisible by 4, that implies that 4 subsets of equal value are not possible and
we don't need to do any further processing on this.
The only question that remains now for us to solve is:
​
what subset a particular element belongs to?
​
If we are able to figure that out, then there's nothing else left to do. But, since we can't say which of the 44 subsets would contain a particular element, we try out all the options
​
It is possible that a matchstick can be a part of any of the 4 sides of the resulting square, but which one of these choices leads to an actual square is something we don't know.
​
This means that for every matchstick in our given array, we have 44 different options each representing the side of the square or subset that this matchstick can be a part of.
​
We try out all of them and keep on doing this recursively until we exhaust all of the possibilities or until we find an arrangement of our matchsticks such that they form the square.
​
Algorithm
​
As discussed previously, we will follow a recursive, depth first approach to solve this problem. So, we have a function that takes the current matchstick index we are to process and also the number of sides of the square that are completely formed till now.
​
If all of the matchsticks have been used up and 4 sides have been completely formed, that implies our square is completely formed. This is the base case for the recursion.
​
For the current matchstick we have 4 different options. This matchstick at indexindex can be a part of any of the sides of the square. We try out the 4 options by recursing on them.
​
If any of these recursive calls returns TrueTrue, then we return from there, else we return FalseFalse
​