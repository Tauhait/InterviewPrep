class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);//O(n log n)
        int lo = 0;
        int hi = nums[nums.length-1] - nums[0];
        while (lo < hi) {//O(log n)
            int mid = ((hi - lo) >>> 1) + lo;
            int count = countPairs(nums, mid);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            } 
        }
        return lo;
        //O(n log n)
    }
    
    private int countPairs(int[] nums, int mid) {//O(n)
        int count = 0;
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[r] - nums[l] <= mid) {
                count += r - l;
                ++r;
            } else {
                ++l;
            }
        }
        return count;
    }
}
/**
Approach1:
1. loop thorugh every pair in nums. O(n2)
2. calc their abs diff
3. declare a max heap of size k
4. insert into max heap until size is k O(lg k)
5. if heap size is k and there is a pair whose abs diff is < top heap element then remove heap top and insert it
6. at the end after processing all pairs remove and return the top heap element.

n-1 + n-2 + n-3 + ... + 1 = n(n+!)/2 = O(n2)
TC - O(n2 log k)
SC - O(k)

Approach2:
1. sort nums. O(n log n)
2. find low and high of diff
3. Run BS between low and high
4. For every mid count the number of pairs using SlidW (nums[r] - nums[l] <= mid ? count += r - l;)
5. Depending on the pair count for every mid move low and high
*/