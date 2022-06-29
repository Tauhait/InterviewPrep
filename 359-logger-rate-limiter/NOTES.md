I've a suggestion for extending second solution further for more optimization and follow up question for interview.
​
Our hash table could grow up to number of unique messages as part of second solution. This will end up using lot of memory. How do we resolve this issue ?
​
We could have a linked-list associated with map ( just like LRU cache implementation ).
[1] We store a key-value in map, where value also has a pointer to linked-list node.
[2] Every time we update a map entry, we also remove that node and move it front of linked list. O(1) operation.
[3] We can spawn another thread for periodically cleaning up map.
[4] This clean-up thread will look at back of list for stale entries and start removing those entries in the map, keeping memory usage low for map.
[5] Also having every single hash table entry protected with a mutex, instead of entire hash-table with a single mutex , helps to make things more concurrent.
​
​