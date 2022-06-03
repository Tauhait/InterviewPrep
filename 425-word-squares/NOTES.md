Algorithm
​
* We build upon the backtracking algorithm that we listed above, and tweak two parts.
*
* In the first part, we add a new function buildTrie(words) to build a Trie out of the input words.
*
* Then in the second part, in the function getWordsWithPrefix(prefix) we simply query the Trie to retrieve all the words that possess the given prefix.
*
* Here are some sample implementations. Note that, we tweak the Trie data structure a bit, in order to further optimize the time and space complexity.
*
* Instead of labeling the word at the leaf node of the Trie, we label the word at each node so that we don't need to perform a further traversal once we reach the last node in the prefix. This trick could help us with the time complexity.
*
* Instead of storing the actual words in the Trie, we keep only the index of the word, which could greatly save the space.