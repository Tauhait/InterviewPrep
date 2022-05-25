For anyone (like me) wondering why this algorithm uses its sorting scheme, consider its action on the following set of envelopes: [[4,5],[4,6],[6,7],[2,3],[1,1]]
​
Sort width ascending, then height descending for ties (accepted):
[[1, 1], [2, 3], [4, 6], [4, 5], [6, 7]]
Searching for height of 1
Result of search: -1
Inserting height at index: 0
1 0 0 0 0
l is now 1
Searching for height of 3
Result of search: -2
Inserting height at index: 1
1 3 0 0 0
l is now 2
Searching for height of 6
Result of search: -3
Inserting height at index: 2
1 3 6 0 0
l is now 3
Searching for height of 5
Result of search: -3
Inserting height at index: 2
1 3 5 0 0
l is now 3
Searching for height of 7
Result of search: -4
Inserting height at index: 3
1 3 5 7 0
l is now 4
Max number of envelopes: 4