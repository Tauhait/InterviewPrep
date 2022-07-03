After you solve 4Sum II, an interviewer can follow-up with 5Sum II, 6Sum II, and so on. What they are really expecting is a generalized solution for k input arrays. Fortunately, the hashmap approach can be easily extended to handle more than 4 arrays.
​
Above, we divided 4 arrays into two equal groups, and processed each group independently. Same way, we will divide kk arrays into two groups. For the first group, we will have \frac{k}{2}
2
k
•
nested loops to count sums. Another \frac{k}{2}
2
k
•
nested loops will enumerate arrays in the second group and search for complements.
Further Thoughts
For an interview, keep in mind the generalized implementation. Even if your interviewer is OK with a simpler code, you'll get some extra points by describing how your solution can handle more than 4 arrays.
​
It's also important to discuss trade-offs with your interviewer. If we are tight on memory, we can move some arrays from the first group to the second. This, of course, will increase the time complexity.
​
In other words, the time complexity can range from \mathcal{O}(n^k)O(n
k
) to \mathcal{O}(n^{\frac{k}{2}})O(n
2
k
•
), and the memory complexity ranges from \mathcal{O}(1)O(1) to \mathcal{O}(n^{\frac{k}{2}})O(n
2
k
•
) accordingly.