class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        def binary_search(subseq, target):
            l, r = 0, len(subseq) - 1
            while l < r:
                m = (l+r)//2
                if subseq[m] < target:
                    l = m + 1
                else:
                    r = m
            return l
        
        track = []
        for n in nums:
            if not track or n > track[-1]:
                track.append(n)
                continue
            idx = binary_search(track, n)
            track[idx] = n
        return len(track)