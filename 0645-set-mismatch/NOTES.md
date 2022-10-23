Bit manipulation approach:
Another take on explaining Approach 7 Using XOR:
​
* Let N = len(nums).
* Let the repeated number by r and the missing number be m.
* A basic property of XOR is that a number XORed with itself is zero. Also, any number XORed with itself an odd number of times is itself (e.g. x = x ^ x ^ x, for any x).
* Let xor = XOR of (all elements in nums + all elements in range(1, N + 1)).
* Then, xor = r ^ m (because all other elements occur twice, r occurs thrice and m once).
* Note that there is always a 1 bit in xor since r != m (i.e. xor is never zero).
* Pick any bit in xor that is a 1. One way to do this is to pick the rightmost bit
* and that can be computed as xor & ~(xor - 1).
* For example, if xor = 10 = 0b1010, then rbit = 0b10.
* As a more complete example, let nums = range(1, 16) with 4 replacing 14 (r=4=0b0100, m=14=0b1110) or 14 replacing 4 (r=14, m=4). Then, 4 ^ 14 = 0b1010 and rbit = 0b10.
* To repeat, rbit is one bit that differs between r and m. If we AND this bit with all the elements in nums and all the elements in range(1, N + 1), then either rbit & r = 1 (and rbit & m = 0), or rbit & m = 1 (and rbit & r = 0).
* We will use this AND operation with rbit to separate out the numbers in nums and range(1, N) into two sets:
* a. One set that contains r (which occurs thrice).
* b. Another set that contains m (which occurs once).
* All other numbers in each set occurs twice (once from nums and once from range(1, N))
* We will now XOR all the numbers in these two sets separately. Say, we get xor0 and xor1
* as a result of these XOR operations.
* One of them has to be r and the other has to be m. Because all other numbers occur twice.
* In order to figure out which is which, we again iterate through nums to check if it contains
* xor0 or xor1 -- that element is r and the other one is m.
* TADA! :)