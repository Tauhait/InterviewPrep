Algorithm
​
Set pointer pA to point at headA.
Set pointer pB to point at headB.
While pA and pB are not pointing at the same node:
If pA is pointing to a null, set pA to point to headB.
Else, set pA to point at pA.next.
If pB is pointing to a null, set pB to point to headA.
Else, set pB to point at pB.next.
return the value pointed to by pA (or by pB; they're the same now).
​
​
Let NN be the length of list A and MM be the length of list B.
​
Time complexity : O(N + M)O(N+M).
​
In the worst case, each list is traversed twice giving 2 \cdot M + 2 \cdot N2⋅M+2⋅N, which is equivalent to O(N + M)O(N+M). This is because the pointers firstly go down each list so that they can be "lined up" and then in the second iteration, the intersection node is searched for.
​
An interesting observation you might have made is that when the lists are of the same length, this algorithm only traverses each list once. This is because the pointers are already "lined up" from the start, so the additional pass is unnecessary.
​
Space complexity : O(1)O(1).
​
We aren't allocating any additional data structures, so the amount of extra space used does not grow with the size of the input. For this reason, Approach 3 is better than Approach 2.
​
​