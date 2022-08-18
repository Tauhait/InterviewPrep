class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        int nthBit = 1 << n;
        for (int i = 0; i < (int)Math.pow(2, n); ++i) {
          // generate bitmask, from 0..00 to 1..11
          String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
          // append subset corresponding to that bitmask
          List<Integer> curr = new ArrayList();
          for (int j = 0; j < n; ++j) {
            if (bitmask.charAt(j) == '1') curr.add(nums[j]);
          }
          output.add(curr);
        }
        return output;
    }
    //time complexity = O(N * 2^N)
    //space complexity = O(N)
}