class Solution {
    //(pref[r+1]-pref[l]) % k = 0 is equivalent to pref[l] % k = pref[r+1] % k
    /*
    (a+(n*x))%x is same as (a%x)

For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0]. We got remainder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number which is multiple of the k. Hope this clarifies your doubt :)
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) { 
                return true;
            }
        }

        return false;
    }
}