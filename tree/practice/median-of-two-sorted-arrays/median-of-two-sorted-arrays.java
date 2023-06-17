class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length, n2 = nums2.length;
        int totalLen = n1 + n2;
        int halfLen = (totalLen + 1) / 2;
        
        int l = 0, r = n1;

        int aLeft, aRight, bLeft, bRight;
        while(l <= r){
            int aMid = (l + r) / 2;
            int bMid = halfLen - aMid;
            aLeft  =  (aMid == 0)  ? Integer.MIN_VALUE : nums1[aMid - 1];
            bLeft  =  (bMid == 0)  ? Integer.MIN_VALUE : nums2[bMid - 1];
            aRight =  (aMid == n1) ? Integer.MAX_VALUE : nums1[aMid];
            bRight =  (bMid == n2) ? Integer.MAX_VALUE : nums2[bMid];

            if(aLeft <= bRight && bLeft <= aRight){
                if((totalLen & 1) == 1){
                    return Math.max(aLeft, bLeft);
                } else {
                    return (Math.max(aLeft, bLeft) + 
                            Math.min(aRight, bRight) )/ 2.0;
                }
            } else if(aLeft > bRight){
                r = aMid - 1;
            } else {
                l = aMid + 1;
            }
        }
        return 0.0;
    }
}