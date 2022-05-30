Doing this question "properly", following all the rules given, makes this one of our most difficult medium-level questions.
​
int quotient = 0;
/* Once the divisor is bigger than the current dividend,
* we can't fit any more copies of the divisor into it. */
while (dividend >= divisor) {
/* Now that we're in the loop, we know it'll fit at least once as
* divivend >= divisor */
int powerOfTwo = 1;
int value = divisor;
/* Check if double the current value is too big. If not, continue doubling.
* If it is too big, stop doubling and continue with the next step */
while (value + value < dividend) {
value += value;
powerOfTwo += powerOfTwo;
}
// We have been able to subtract divisor another powerOfTwo times.
quotient += powerOfTwo;
// Remove value so far so that we can continue the process with remainder.
dividend -= value;
}
​
return quotient;
​
This algorithm is known as exponential search and is commonly used for searching sorted spaces of unknown size for the first value that past a particular condition. It it a lot like binary search, having the same time complexity
​