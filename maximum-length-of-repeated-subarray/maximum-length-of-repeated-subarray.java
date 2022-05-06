class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] memo = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; --i) {
            for (int j = nums2.length - 1; j >= 0; --j) {
                if (nums1[i] == nums2[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) {
                        ans = memo[i][j];
                    }
                }
            }
        }
        return ans;
    }
}