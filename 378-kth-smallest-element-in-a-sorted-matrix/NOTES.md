1st Approach:
The intuition for this approach is really simple. If you think about it, we can reframe the problem as finding the K^{\text{th}}K
th
smallest elements from amongst N sorted lists right? We know that the rows are sorted and so are the columns. So, we can treat each row (or column) as a sorted list in itself. Then, the problem just boils down to finding the K^{\text{th}}K
th
smallest element from amongst these N sorted lists. However, before we get to this problem, lets first talk about a simpler version of the problem which is to find the K^{\text{th}}K
th
smallest element from amongst 2 sorted lists. This is easy enough to solve since all we need are a pair of pointers which act as indices in the two lists.
​
At each step we check which element is smaller amongst the two being pointed at by the indices and progress the corresponding index accordingly. If you think about it, we just need to run the algorithm for merging two sorted lists without actually merging them. We need to keep on running this algorithm until we find our K^{\text{th}}K
th
element. Let's quickly look at how this would look like diagrammatically.
​
​
**
At each step, we remove the minimum element from the heap. The element will tell us which row should be further consumed. Using the row and column information we will add the next element to the heap. Specifically, if the current minimum element was from row r and had a column position c, then the next element to be added to the heap will be (r, c+1).
**
​
​