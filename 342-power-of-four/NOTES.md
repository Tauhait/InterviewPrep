Let's first check if num is a power of two: x > 0 and x & (x - 1) == 0.
Now the problem is to distinguish between even powers of two (when xx is a power of four) and odd powers of two (when xx is not a power of four). In binary representation both cases are single 1-bit followed by zeros.
​
​
Hence power of four would make a zero in a bitwise AND with number (101010...10)_2
How long should be (101010...10)_2(101010...10)
2
•
if xx is a signed integer? 32 bits. To write shorter, in 8 charaters instead of 32, it's common to use hexadecimal representation: (101010...10)_2 = (aaaaaaaa)_{16}
​
x∧(aaaaaaaa)_16==0