class Solution {
    private int _merge(int[] nums, int left, int mid, int right){
        int i = left, j = mid+1;
        int reversePairs = 0;
        for(;i <= mid; i++){
            while((j <= right) && (nums[i] > (2*(long)nums[j]))) j++;
            reversePairs += (j-(mid+1));            
        }

        ArrayList<Integer> temp = new ArrayList<>(); 
        i = left; j = mid+1; 
        while(i <= mid && j<=right) {
            if(nums[i]<=nums[j]) {
                temp.add(nums[i++]); 
            }
            else {
                temp.add(nums[j++]); 
            }
        }
        
        while(i<=mid) {
            temp.add(nums[i++]); 
        }
        while(j<=right) {
            temp.add(nums[j++]); 
        }
        
        for(int k = left; k <= right; k++) {
            nums[k] = temp.get(k - left); 
        }
        return reversePairs;
    }
    private int _mergeSort(int[] nums, int low, int high){
        if(low >= high) return 0; 
        int mid = (low + high) / 2;
        int inv = 0;
        inv += _mergeSort(nums, low, mid); 
        inv += _mergeSort(nums, mid+1, high); 
        inv += _merge(nums, low, mid, high); 
        return inv;         
    }
    public int reversePairs(int[] nums) {
        return _mergeSort(nums, 0, nums.length-1);
    }
}