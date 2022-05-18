In graph theory, a cut is a partition of the vertices of a graph into two disjoint subsets. Any cut determines a cut-set, the set of edges that have one endpoint in each subset of the partition. In this problem, we are not concerned with finding the cuts in a graph: we are instead tasked with the related problems of finding all of the bridges in the graph.
​
there's a standard algorithm out there that does precisely this i.e. find the bridges in an undirected graph. This algorithm is known as the Tarjan's algorithm, and is a standard way of finding the articulation points and bridges in a graph. Here is some Wikipedia pseudo-code for the algorithm if you're interested to learn more about it.
​
An edge is a critical connection, if and only if it is not in a cycle.
​
Edges that are not a part of the cycle end up being a single route from getting from one part of the graph to the other. Why, you ask? Well if there were multiple ways, then our edge would be a part of the cycle considering this is an undirected graph. Thus, edges not belonging to any cycle end up being a critical connection for the graph.
​
Thus, the problem simply boils down to finding all the cycles in the graph and discarding all the edges belonging to such cycles. If we do that, we will only be left with edges that are critical connections in the graph.
​
So how does this rank help us in detecting cycles in the graph? Well, it works exactly like keeping a set of visited nodes would work. At each step of our traversal, we maintain the rank of the nodes we've come across until now on the current path. If at any point, we come across a neighbor that has a rank lower than the current node's rank, we know that the neighbor must have already been visited. In other words, if we started along a path with rank 0 from the root node and are currently at a node with rank m and now we discover a node that already has a rank assigned to it and that value is 0 <= n < m, then it implies the presence of a cycle.
​