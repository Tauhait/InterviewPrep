In the previous three approaches, we found the maximum element in nums, and iterated from 0 to maxNumber. The problem with this idea is that in some test cases, there could be large gaps between elements that we will waste time iterating over. In all three approaches, our time complexity was O(N+k), or O(nums.length+max(nums)). This is very inefficient for a case such as nums = [1, 2, 3, 10000].
​
Approach 3 has a time complexity of O(N+k). Approach 4 has a time complexity of O(N⋅log(N)). When k is large compared to N, approach 4 is faster. When N is not large compared to k, such as in the example nums = [1, 2, 3, 4, ..., 9997, 9998, 9999], we should use approach 3.
​
It should be noted that the time complexity O(N⋅log(N)) is for the worst case. We are actually only sorting the number of keys in points, which is equal to the number of unique elements in nums. When we precompute points, we can find the number of keys n as well as k. With n and k, we can decide if approach 3 or approach 4 is faster, and then perform the faster one.
​
For approach 3, we iterate k = maxNumber times. For approach 4, we iterate n times after performing n * log(n) operations to sort. If k < n + n * log(n), then it is better to use the algorithm from approach 3. Otherwise, it might be more efficient to use the algorithm from approach 4.
​