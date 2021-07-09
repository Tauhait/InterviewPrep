package faang;

import java.util.ArrayList;

public class LIS {
	public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        ArrayList<Integer> subseqList = new ArrayList<Integer>();
        subseqList.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int prev = subseqList.get(subseqList.size() - 1);
            if(nums[i] > prev){
                subseqList.add(nums[i]);
            }else {
                int lstGrEqElemIdx = findLeastGreaterOrEqualElem(subseqList, nums[i]);
                subseqList.set(lstGrEqElemIdx, nums[i]);
            }
        }
        return subseqList.size();
        
    }
    private int findLeastGreaterOrEqualElem(ArrayList<Integer> list, int item){
        int left = 0;
        int right = list.size();
        while(left <= right){
            int mid = left + (right - left)/2;
            if(list.get(mid) == item){
                return mid;
            }else if(list.get(mid) < item){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

}
