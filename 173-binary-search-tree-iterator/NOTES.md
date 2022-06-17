However, if we could simulate a controlled recursion for an inorder traversal, we wouldn't really need to use any additional space other than the space used by the stack for our recursion simulation.
​
So, this approach essentially uses a custom stack to simulate the inorder traversal i.e. we will be taking an iterative approach to inorder traversal rather than going with the recursive approach and in doing so, we will be able to easily implement the two function calls without any other additional space.
​
However, the important thing to note here is that we only make such a call for nodes which have a right child. Otherwise, we simply return. Also, even if we end up calling the helper function, it won't always process N nodes. They will be much lesser. Only if we have a skewed tree would there be N nodes for the root. But that is the only node for which we would call the helper function.
​
When analyzing amortized time complexities, I find it easiest to reason that each node gets pushed and popped exactly once in next() when iterating over all N nodes.
That comes out to 2N * O(1) over N calls to next(), making it O(1) on average, or O(1) amortized.
​
the space complexity O(H), since at any point the stack contains only H elements where H is the height of the tree.  if the tree is skewed then you would have N elements in your stack. In this case the height of the tree, H is equal to N.
So during worst case H equals N.