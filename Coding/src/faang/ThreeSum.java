package faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<List<Integer>>();
        List<List<Integer>> tripletsList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int target = 0 - nums[i];
            int front = i + 1;
            int back = len - 1;
            while(front < back){
                if(nums[front] + nums[back] < target) ++front;
                else if(nums[front] + nums[back] > target) --back;
                else {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]); triplet.add(nums[front]); triplet.add(nums[back]);
                    while(front < back && nums[front] == triplet.get(1)) ++front;
                    while(front < back && nums[back] == triplet.get(2)) --back;
                    tripletsList.add(triplet);
                }
            }
            while(i + 1 < len && nums[i + 1] == nums[i]) ++i;            
        }
        return tripletsList;
    }
}
