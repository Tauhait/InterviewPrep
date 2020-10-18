package faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return; // cannot be added to current combination list
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    /*
    The main idea reminds an approach for solving coins/knapsack problem - to store the result for all i < target and 
    create the solution from them. 
    For that for each t from 1 to our target we try every candidate which is less or equal to t in ascending order. 
    For each candidate "c" we run through all combinations for target t-c starting with the value greater or 
    equal than c to avoid duplicates and 
    store only ordered combinations.
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort candidates to try them in asc order
        Arrays.sort(candidates); 
        // dp[t] stores all combinations that add up to t
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        
        
        // build up dp
        for(int t=0; t<=target; t++) {
            // initialize
            dp[t] = new ArrayList();
            // initialize
            List<List<Integer>> combList = new ArrayList();
            
            // for each t, find possible combinations
            for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
                if(candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j])); // itself can form a list
                } else {
                    for(List<Integer> prevlist: dp[t-candidates[j]]) { // here use our dp definition
                        // i thought it makes more sense to compare with the last element
                        // only add to list when the candidates[j] >= the last element
                        // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
                        // equal is needed since we can choose the same element many times   
                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
                            List temp = new ArrayList(prevlist); // temp is needed since 
                            temp.add(candidates[j]); // cannot edit prevlist inside 4eeach looop
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    }    
    */
}
