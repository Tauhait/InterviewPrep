Time complexity: \mathcal{O}(M(4\cdot3^{L-1}))O(M(4⋅3
L−1
)), where MM is the number of cells in the board and LL is the maximum length of words.
​
It is tricky is calculate the exact number of steps that a backtracking algorithm would perform. We provide a upper bound of steps for the worst scenario for this problem. The algorithm loops over all the cells in the board, therefore we have MM as a factor in the complexity formula. It then boils down to the maximum number of steps we would need for each starting cell (i.e.4\cdot3^{L-1}4⋅3
L−1
).
​
Assume the maximum length of word is LL, starting from a cell, initially we would have at most 4 directions to explore. Assume each direction is valid (i.e. worst case), during the following exploration, we have at most 3 neighbor cells (excluding the cell where we come from) to explore. As a result, we would traverse at most 4\cdot3^{L-1}4⋅3
L−1
cells during the backtracking exploration.
​
One might wonder what the worst case scenario looks like. Well, here is an example. Imagine, each of the cells in the board contains the letter a, and the word dictionary contains a single word ['aaaa']. Voila. This is one of the worst scenarios that the algorithm would encounter. pic
​
Note that, the above time complexity is estimated under the assumption that the Trie data structure would not change once built. If we apply the optimization trick to gradually remove the nodes in Trie, we could greatly improve the time complexity, since the cost of backtracking would reduced to zero once we match all the words in the dictionary, i.e. the Trie becomes empty.
​
​
Space Complexity: \mathcal{O}(N)O(N), where NN is the total number of letters in the dictionary.
​
The main space consumed by the algorithm is the Trie data structure we build. In the worst case where there is no overlapping of prefixes among the words, the Trie would have as many nodes as the letters of all words. And optionally, one might keep a copy of words in the Trie as well. As a result, we might need 2N2N space for the Trie.
```