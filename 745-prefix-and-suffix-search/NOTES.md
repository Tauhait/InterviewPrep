```
Intuition and Algorithm
​
Consider the word 'apple'. For each suffix of the word, we could insert that suffix, followed by '#', followed by the word, all into the trie.
​
For example, we will insert '#apple', 'e#apple', 'le#apple', 'ple#apple', 'pple#apple', 'apple#apple' into the trie. Then for a query like prefix = "ap", suffix = "le", we can find it by querying our trie for le#ap.
```
​
```
Complexity Analysis
​
Time Complexity: O(NK^2 + QK) where N is the number of words, K is the maximum length of a word, and Q is the number of queries.
​
Space Complexity: O(NK^2) the size of the trie.
```