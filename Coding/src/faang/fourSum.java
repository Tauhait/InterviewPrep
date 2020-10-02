package faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
	 public List<List<Integer>> _4sum(int[] nums, int target) {
        if(nums == null || nums.length < 4) return new ArrayList<List<Integer>>();
        List<List<Integer>> quadList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int target2 = target - (nums[i] + nums[j]);
                int front = j + 1;
                int back = len - 1;
                while(front < back){
                    if(nums[front] + nums[back] < target2) ++front;
                    else if(nums[front] + nums[back] > target2) --back;
                    else {
                        List<Integer> quad = new ArrayList<Integer>();
                        quad.add(nums[i]); quad.add(nums[j]); quad.add(nums[front]); quad.add(nums[back]);
                        while(front < back && nums[front] == quad.get(2)) ++front;
                        while(front < back && nums[back] == quad.get(3)) --back;
                        quadList.add(quad);
                    }
                }                
                while(j + 1 < len && nums[j + 1] == nums[j]) ++j; 
            }
            while(i + 1 < len && nums[i + 1] == nums[i]) ++i;            
        }
        return quadList;
    }
}
