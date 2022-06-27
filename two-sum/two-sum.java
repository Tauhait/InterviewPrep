class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        Map<Integer, Set<Integer>> valueIndexMap = new HashMap<Integer, Set<Integer>>();
        
        for(int i = 0; i < nums.length; i++){
            if(!valueIndexMap.containsKey(nums[i])){
                valueIndexMap.put(nums[i], new HashSet<Integer>());
            }
            Set<Integer> indexSet = valueIndexMap.get(nums[i]);
            indexSet.add(i);
        }
        int[] ans = new int[2];
        
        for(int idx = 0; idx < nums.length; idx++){
            int val = nums[idx];
            int diff = target - nums[idx];
            if(val == diff && 
               valueIndexMap.containsKey(val) && 
               valueIndexMap.get(val).size() <= 1) continue;
            
            if(valueIndexMap.containsKey(val) && valueIndexMap.containsKey(diff)){
                Set<Integer> valIndexSet = valueIndexMap.get(val);
                ans[0] = valIndexSet.iterator().next();
                valIndexSet.remove(ans[0]);
                
                Set<Integer> diffIndexSet = valueIndexMap.get(diff);
                ans[1] = diffIndexSet.iterator().next();
                return ans;
             }
        }
        return ans;
    }
}