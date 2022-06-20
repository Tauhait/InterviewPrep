**Building the trie:**
First, we'll construct our suffix trie by using a TrieNode class and inserting words backwards into our trie.
As we build our trie, we'll keep track of heights for each TrieNode.
​
**Depth-first search:**
Once our trie is built, we'll simply traverse the trie using DFS in order to get to the leaf nodes.
Once we're at the leaf nodes, we simply add to our size the current height to account for the number of letters. We'll also add an extra 1 to account for the #s.
We'll do this iteratively using a stack.
https://leetcode.com/problems/short-encoding-of-words/discuss/2172391/The-Key-Observation-or-JAVA-Explanation
​
​