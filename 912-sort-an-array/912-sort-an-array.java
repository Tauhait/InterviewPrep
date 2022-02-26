class Solution {
    public int[] sortArray(int[] nums) {
        mergeSortBottomUp(nums, 0, nums.length - 1);
        return nums;
        
    }
    private void mergeSortBottomUp(int[] arr, int start, int end){
        for(int stride = 1; stride <= end; stride *= 2){
           for(int idx = 0; idx + stride <= end; idx += 2 * stride){
               int mid = idx + stride - 1;
               int right = Math.min(end, idx + 2 * stride - 1);
                merge(arr, idx, mid, right);
            } 
        }
        
    }
    private void merge(int[] arr, int left, int mid, int right){
        int mergeArr[] = new int[right - left + 1];
        int mergeIdx = 0;
        int leftIdx = left;
        int rightIdx = mid + 1;
        while(leftIdx <= mid || rightIdx <= right){
            if(leftIdx > mid || rightIdx <= right && arr[rightIdx] < arr[leftIdx]){
                mergeArr[mergeIdx++] = arr[rightIdx++];
            }else {
                mergeArr[mergeIdx++] = arr[leftIdx++];
            }
        }
        System.arraycopy(mergeArr, 0, arr, left, right - left + 1);
    }
}