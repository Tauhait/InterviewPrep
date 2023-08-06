//  Minimum Time to Make Array Sum At Most x
// https://leetcode.com/problems/minimum-time-to-make-array-sum-at-most-x/description/
class H_2809 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int sumNums1 = 0, sumNums2 = 0;
        int n = nums1.size();
        int[] dp = new int[n + 1];
        List<List<Integer>> pairList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int num1 = nums1.get(i);
            int num2 = nums2.get(i);
            pairList.add(Arrays.asList(num1, num2));
            sumNums1 += num1;
            sumNums2 += num2;
        }
        Collections.sort(pairList, (n1, n2) -> Integer.compare(n1.get(1), n2.get(1)));

        for(int second = 0; second < n; second++){
            int num1 = pairList.get(second).get(0);
            int num2 = pairList.get(second).get(1);            
            for(int i = second + 1; i > 0; i--){
                //  means the maximum value we can reduce at i seconds,
                dp[i] = Math.max(dp[i], dp[i - 1] + (i * num2 + num1));
            }
        }

        for(int second = 0; second <= n; second++){
            // minimum time in which the sum of all elements of nums1 to be less than or equal to x
            // Every second, for all 0 <= i < nums1.length, value of nums1[i] is incremented by nums2[i]
            // After this is done, you can do the following operation:
                //  Choose an index 0 <= i < nums1.length and make nums1[i] = 0.
            if((second * sumNums2 + sumNums1) - dp[second] <= x) return second;
        }
        return -1;
    }
}