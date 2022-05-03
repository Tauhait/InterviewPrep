deque (double-ended queue), the structure which pops from / pushes to either side with the same \mathcal{O}(1)O(1) performance
​
DP
The algorithm is quite straightforward :
​
Iterate along the array in the direction left->right and build an array left.
​
Iterate along the array in the direction right->left and build an array right.
​
Build an output array as max(right[i], left[i + k - 1]) for i in range (0,