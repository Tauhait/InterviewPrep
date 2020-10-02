package faang;

import java.util.ArrayList;
//Modified Merge Sort
//https://leetcode.com/problems/reverse-pairs/solution/


public class ReversePairs {
	//Brute force approach take one element and traverse rest of the elements in the array and find reverse pairs.   TC - O(n*n)                    SC - O(1)
    //Optimal approach would be to use merge sort algorithm and count along the reverse pairs before the merge step. TC - O(n lg n) + O(n) + O(n)   SC - O(n)
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }
    private int mergesort(int[] nums, int low, int high){        
        if(low >= high) return 0;
        int mid = low + (high - low)/2;
        int inv = 0;
        inv += mergesort(nums, low, mid);
        inv += mergesort(nums, mid + 1, high);
        inv += merge(nums, low, mid, high);        
        return inv;
    }
    private int merge(int[] nums, int low, int mid, int high){
        int revCnt = 0;
        for(int i = low, j = mid + 1; i <= mid; i++) {
            long y = 2 * nums[j];
            long x = nums[i];
            while((j + 1) <= high && x > y) { // keep on iterating for all reverse pairs y of x
                j++;
                y = 2 * nums[j];                
            }
            revCnt += (j - (mid + 1));
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low, right = mid + 1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]) temp.add(nums[left++]);
            else temp.add(nums[right++]);
        }
        while(left <= mid) temp.add(nums[left++]);
        while(right <= high) temp.add(nums[right++]);
        
        for(int i = low; i <= high; i++) nums[i] = temp.get(i - low);
        
        return revCnt;
    }
}
