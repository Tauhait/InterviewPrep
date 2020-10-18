package faang;
/*
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
 */
public class MergeTwoSortedArrayIntoOne {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < (m + n); i++) nums1[i] = nums2[i - m];
        quicksort(nums1, 0, m + n - 1);        
    }
    private void quicksort(int[] nums, int l, int r){
        if(l < r){
            int mid = partition(nums, l, r);
            quicksort(nums, l, mid - 1);
            quicksort(nums, mid + 1, r);            
        }
    }
    private int partition(int[] nums, int l, int r){
        int pivot = nums[r];
        int i = l;
        for(int j = l; j <= r - 1; j++){
            if(nums[j] < pivot) swap(nums, j, i++);            
        }
        swap(nums, i, r);
        return i;
    }
    private void swap(int[] nums, int first, int second){
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }

}
