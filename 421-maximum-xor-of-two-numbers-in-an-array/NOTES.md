Time complexity : \mathcal{O}(N)O(N). It takes \mathcal{O}(L)O(L) to insert a number in Trie, and \mathcal{O}(L)O(L) to find the max XOR of the given number with all already inserted ones. L = 1 + [\log_2 M]L=1+[log
2
•
M] is defined by the maximum number in the array and could be considered as a constant here. Hence the overall time complexity is \mathcal{O}(N)O(N).
​
Space complexity : \mathcal{O}(1)O(1), since one needs at maximum \mathcal{O}(2^L) = \mathcal{O}(M)O(2
L
)=O(M) space to keep Trie, and L and M could be considered as constants here because of input limitations.