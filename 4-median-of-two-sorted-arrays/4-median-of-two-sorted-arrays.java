class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //try to do BS using smaller size array hence the next line of code
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;
        
        while(low <= high){
            int cut1 = (low + high) >>> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;//this works for both odd and even length arrays
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];//nums1 left half end
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];//nums2 left half end
            
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];//nums1 right half end
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];//nums2 right half end
            
            if(left1 <= right2 && left2 <= right1) { //valid
                if((n1 + n2) % 2 == 0) return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else return Math.max(left1, left2);
            }else if(left1 > right2){//reduce left half of nums1 so lower the high range to make cut1 less
                high = cut1 - 1;
            }else {//increse right half of nums1 so increase the low range to make cut1 more
                low = cut1 + 1;//cut2 depends on cut1 so work using cut1
            }
        }
        return 0.0;
    }
    
}
/**
TC= O(log2 (min(n1, n2)))
SC= O(1)
*/