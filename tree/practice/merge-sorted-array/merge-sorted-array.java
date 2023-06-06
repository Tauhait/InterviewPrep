class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {        
        int i = 0, j = 0;
        int[] merged = new int[m+n];
        int index = 0;
        while(i < m && j < n){
            merged[index++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(j < n){
            merged[index++] = nums2[j++];
        }
        while(i < m){
            merged[index++] = nums1[i++];
        }
        for(index = 0; index < m+n; index++) nums1[index] = merged[index];
    }
}