class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        max_so_far = nums[0]
        min_so_far = nums[0]
        result = max_so_far

        for i in range(1, n):
            curr = nums[i]
            temp = max(curr, max_so_far*curr, min_so_far*curr)
            min_so_far = min(curr, max_so_far*curr, min_so_far*curr)
            max_so_far = temp

            result = max(max_so_far, result)
        
        return result
