If we regard a consecutive sequence as a conected component (or a disjoint set), the problem becomes to get the size of largest connected component (or set).
​
A node is a value of an element in nums in this case.
Two nodes are connected if they are consecutive.
​
O(N) time complexity is reqruired, so given nums[i], we should tell index of nums[i] - 1 if any, and nums[i] + 1 if any in O(1). That can be achieved using a map that maps value to index.
​
Please note that for duplicate elements, we count only once.