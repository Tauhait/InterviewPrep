Complexity Analysis
​
Let KK be the number of digits in a combination.
​
Time Complexity: \mathcal{O}(\frac{9! \cdot K}{(9-K)!})O(
(9−K)!
9!⋅K
•
)
​
In a worst scenario, we have to explore all potential combinations to the very end, i.e. the sum nn is a large number (n > 9 * 9n>9∗9). At the first step, we have 99 choices, while at the second step, we have 88 choices, so on and so forth.
​
The number of exploration we need to make in the worst case would be P(9, K) = \frac{9!}{(9-K)!}P(9,K)=
(9−K)!
9!
•
, assuming that K <= 9K<=9. By the way, KK cannot be greater than 9, otherwise we cannot have a combination whose digits are all unique.
​
Each exploration takes a constant time to process, except the last step where it takes \mathcal{O}(K)O(K) time to make a copy of combination.
​
To sum up, the overall time complexity of the algorithm would be \frac{9!}{(9-K)!} \cdot \mathcal{O}(K) = \mathcal{O}(\frac{9! \cdot K}{(9-K)!})
(9−K)!
9!
•
⋅O(K)=O(
(9−K)!
9!⋅K
•
).
​
Space Complexity: \mathcal{O}(K)O(K)
​
During the backtracking, we used a list to keep the current combination, which holds up to KK elements, i.e. \mathcal{O}(K)O(K).
​
Since we employed recursion in the backtracking, we would need some additional space for the function call stack, which could pile up to KK consecutive invocations, i.e. \mathcal{O}(K)O(K).
​
Hence, to sum up, the overall space complexity would be \mathcal{O}(K)O(K).
​
Note that, we did not take into account the space for the final results in the space complexity.
​
​