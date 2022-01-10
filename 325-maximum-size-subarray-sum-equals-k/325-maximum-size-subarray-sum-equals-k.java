/*
a prefix sum is simply the running total of an array. For example, for nums = [1, 2, 2, 3], the prefix sum would be prefix = [1, 3, 5, 8]. For an index i, prefix[i] is the sum of all numbers in nums up to and including the number at index i.

if there is a subarray with sum k in nums, then there is a pair of numbers in prefix whose difference is k. This rephrased problem may seem familiar to you; it's basically a variation of Two Sum. In Two Sum, we must find two different numbers in an array that equal a target value when added. We can accomplish this in one pass by storing previously seen numbers in a hash table and, for each number, check if its complement has already been seen. We can adopt a similar technique to solve this problem - store the previously seen prefix sums in a hash map for quick (O(1)O(1)) checking, and check if a specific value exists in the hash map as we iterate along prefix. In this case, as we iterate from left to right along prefix, if prefix[i] - k has already been seen, then we found a pair of indices for a subarray with sum k.

Now that we've established how to detect subarrays with sum k, we need to deal with the other part of the original problem - finding the length of the longest subarray with sum k. As mentioned before, we use a hash map to check for existing numbers quickly. Similar to Two Sum, we can store indices as values in this hash map. Therefore, when we find a pair, we can use the stored index and the current index to find the length of the subarray formed by the index pair.

*/

/*

Algorithm

1.Initialize three variables:

An integer prefixSum that keeps track of the prefix sum of nums as 0.
An integer longestSubarray that will keep track of the longest subarray with sum k as 0.
A hash map indices that has keys of prefix sums seen so far and values of the first index that each key was seen.

2.Iterate through nums. At each index i, add nums[i] to prefixSum. Then, make the following checks:

If prefixSum == k, that means the sum of the array up to this index is equal to k. Update longestSubarray = i + 1 (because i is 0-indexed)
If prefixSum - k exists in indices, that means there is a subarray with sum k ending at the current i. The length will be i - indices[prefixSum - k]. If this length is greater than longestSubarray, update longestSubarray.
If the current prefixSum does not yet exist in indices, then set indices[prefixSum] = i. Only do this if it does not already exist because we only want the earliest instance of this presum.

3.Return longestSubarray.

*/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;//keeps track of the prefix sum of nums
        int maxSubArr = 0;//keep track of the longest subarray with sum k
        Map<Integer, Integer> prefixSumIndices = new HashMap<Integer, Integer>();
        //when the prefix sum is equal to k
        //we would need to find a 0 in our hash map to make a pair. Without checking for this case, 
        //our algorithm will think that no subarray exists with a sum of k or 
        //explicitly check if prefixSum == k case        
        /*
        prefixSumIndices.put(prefixSum, -1);
        */
        
        for(int idx = 0; idx < nums.length; idx++){
            prefixSum += nums[idx];
            // Check if all of the numbers seen so far sum to k.
            if (prefixSum == k) {
                maxSubArr = idx + 1;
            }
            // If any subarray seen so far sums to k, then
            // update the length of the longest_subarray. 
            if(prefixSumIndices.containsKey(prefixSum - k)){
                maxSubArr = Math.max(maxSubArr, idx - prefixSumIndices.get(prefixSum - k));
            }
            if(!prefixSumIndices.containsKey(prefixSum)){
                //put the index which comes first so that we can get longest length
                //keep the index as far to the left as possible.
                prefixSumIndices.put(prefixSum, idx);
            }
        }
        return maxSubArr;
    }
}
/*
if there exists some subarray from i to j summing to  k in nums, then we know that
prefixSum[j] - prefixSum[i] = k 
prefixSum[j] - prefixSum[i] - k = 0
prefixSum[j] - k = prefixSum[i]


Given N as the length of nums,

Time complexity: O(N)

We only make one pass through nums, each time doing a constant amount of work. All hash map operations are O(1)O(1).

Space complexity: O(N)

Our hash map can potentially hold as many key-value pairs as there are numbers in nums. An example of this is when there are no negative numbers in the array.

*/