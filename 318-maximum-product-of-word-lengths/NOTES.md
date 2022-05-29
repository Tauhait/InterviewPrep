2. Algorithm
​
Precompute bitmasks for all words and save them in the hashmap bitmask -> max word length with such a bitmask. (There could be several words with the same bitmask, for example, "a" and "aaaaaaa").
​
Compare each word with all the following words one by one. If two words have no common letters, update the maximum product maxProd. Perform "no common letters" check in a constant time with the help of precomputed hashmap of bitmasks: (x & y) == 0.
​
Return maxProd.
​
Complexity Analysis
​
Time complexity : \mathcal{O}(N^2 + L)O(N
2
+L) where N is a number of words and L is a total length of all words together. If you want to have some fun, here is a bloody discussion that all this is for "small" N only, when N < 2^{26}N<2
26
. The idea is that the number of bitmasks is not more than 2^{26}2
26
and hence for N > 2^{26}N>2
26
the complexity is \mathcal{O}(L)O(L).
​
Space complexity : \mathcal{O}(N)O(N) to keep a hashmap of N elements if N < 2^{26}N<2
26
. Otherwise, it's \mathcal{O}(2^{26})O(2
26
) = \mathcal{O}(1)O(1).