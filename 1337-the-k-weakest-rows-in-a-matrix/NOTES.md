Approach: Sorting
Time Complexity : O(m \cdot (n + \log \,m))O(m⋅(n+logm)).
​
For the first phase, we're calculating the "strength" of each row. Calculating the "strength" of a row (with this algorithm) and putting it into the list is O(n)O(n) in the worst case, and there are mm rows. This gives us O(n \cdot m)O(n⋅m).
​
For the second phase, we are sorting the list (which is of length mm). Sorting a list using the built-in sort is O(m \, \log \, m)O(mlogm).
​
To get our final time, we'll add the 2 complexities together. Whether n \cdot mn⋅m or m \, \log \,mmlogm is bigger depends on the relative sizes of mm and nn. This means that we have to add them, giving m \cdot n + m \, \log\,m = m \cdot (n + \log \, m))m⋅n+mlogm=m⋅(n+logm)).
​
If kk was really small, an optimization would be to use selection sort instead of the built in sort to avoid needing to sort the entire list.
​
Space Complexity : O(m)O(m).
​
Constructing the list requires O(m)O(m) space.
​
​