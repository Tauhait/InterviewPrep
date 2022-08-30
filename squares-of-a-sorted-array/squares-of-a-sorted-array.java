class Solution {
    public int[] sortedSquares(int[] nums) {
       int[] res = new int[nums.length];
       int start = 0, end = nums.length - 1;
       int resIndex = nums.length - 1;
       
       while(start <= end){
           int startSq = nums[start] * nums[start];
           int endSq = nums[end] * nums[end];
           if(startSq > endSq){
               res[resIndex--] = startSq;
               start++;
           }else {
               res[resIndex--] = endSq;
               end--;
           }
       }
       
       return res;
    }
    
}