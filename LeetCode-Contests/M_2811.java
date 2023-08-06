// The provided solution works because of the following reasoning:

// If there is a pair of adjacent elements with a sum nums[i] + nums[i + 1] >= m, we can indeed split the array. We can keep removing elements from both sides until we reach this pair, and then we split the array into two subarrays at this pair.

// By repeatedly performing this process, we can eventually split the entire array into n non-empty arrays.
class M_2811 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size() < 3) return true;
        for(int i = 0; i < nums.size() - 1; i++){
            if(nums.get(i) + nums.get(i + 1) >= m) return true;
        }
        return false;
    }
}