package faang;

public class MedianTwoSortedArrays {
	public double findMedianSortedArrays_NAIVE(int[] nums1, int[] nums2) {
        //Naive soln
        int size = nums1.length + nums2.length;
        int[] merged = new int[size];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }
        while(i < nums1.length) merged[k++] = nums1[i++];
        while(j < nums2.length) merged[k++] = nums2[j++];
        return size % 2 == 0 ? (merged[size/2 - 1] + merged[size/2])/2.0 : merged[size/2];
    }
}
