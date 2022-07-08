return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
​
1 . In Java this approach is limited by the length of the input strings a and b. Once the string is long enough, the result of conversion into integers will not fit into Integer, Long or BigInteger:
​
33 1-bits - and b doesn't fit into Integer.
​
65 1-bits - and b doesn't fit into Long.
​
500000001 1-bits - and b doesn't fit into BigInteger.
​
To fix the issue, one could use standard Bit-by-Bit Computation approach which is suitable for quite long input strings.
​
2 . This method has quite low performance in the case of large input numbers.
​
One could use Bit Manipulation approach to speed up the solution.