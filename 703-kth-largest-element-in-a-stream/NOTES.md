In other words, for each node in a BST, if m nodes in the right subtree, the node itself is the m + 1 largest element in the existed array.
​
Think about the problem by yourself first. Feel free to store more than one value in a tree node. You might also want a counter in each node to indicate how many nodes there are in the subtree rooted at this node.
​
By using a BST, the time complexity for insertion and search are both O(h). The time complexity of performing all the operations will be O(N*h). That is, O(N^2) in the worst case and O(NlogN) ideally
​
If the BST is well organized, you can always keep h = logN, where h is the height of the tree and N is the total number of nodes. In that case, you can reduce the time complexity of search, insertion and deletion to O(logN) which is really a considerable solution in many cases. That's the idea of the height-balanced BST.
​
this algorithm is suitable if we have to handle both insertion and search operations.
​