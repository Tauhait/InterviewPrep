class Solution {
    private int bsToFindSmallestGreaterThanEqNum(List<Integer> subseq, int num){
        int left = 0;
        int right = subseq.size();
        while(left < right){
            int mid = left + (right-left)/2;
            if(subseq.get(mid) == num) return mid;
            else if(subseq.get(mid) < num) left = mid+1;
            else right = mid;
        }
        return left;
    }
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;

        List<Integer> subseq = new ArrayList<Integer>();
        subseq.add(nums[0]);

        for(int i = 1; i < len; i++){
            if(nums[i] > subseq.get(subseq.size()-1)){
                subseq.add(nums[i]);
            } else {
                int indexToReplace = bsToFindSmallestGreaterThanEqNum(subseq, nums[i]);
                subseq.set(indexToReplace, nums[i]);
            }
        }
        return subseq.size();
    }
}