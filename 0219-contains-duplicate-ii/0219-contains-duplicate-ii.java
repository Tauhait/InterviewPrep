class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(valueMap.containsKey(nums[i]) && Math.abs(i - valueMap.get(nums[i])) <= k){
                return true;
            }
            valueMap.put(nums[i], i);
        }
        return false;
        /*
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]); 
            //remove element if its distance to nums[i] is not lesser than k
            
            if(!set.add(nums[i])) return true; 
            //because all still existed elements is closer than k distance to the num[i], 
            //therefore if the add() return false, it means there's a same value element already existed 
            //within the distance k, therefore return true.
        }
        return false;
        ------------------------------------------------------------------------------------------------------        
        
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (i - k <= index.getOrDefault(nums[i], -k - 1))
                    return true;
                index.put(nums[i], i);
            }
            return false;
        }
        */
    }
}