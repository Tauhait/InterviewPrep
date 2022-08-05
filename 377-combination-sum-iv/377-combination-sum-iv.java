class Solution {
    private Map<Integer,Integer> memo;
    
    private int combs(int[] nums, int remaining){
        if(remaining == 0) return 1;
        if(memo.containsKey(remaining)) return memo.get(remaining);
        
        int count = 0;
        for(int num:nums){
            if(remaining >= num)
                count += combs(nums, remaining-num);
            else break;//optimization; early stopping
        }
        memo.put(remaining, count);
        return count;
    }
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);//optimization; will enhance unique combinations
        memo = new HashMap<>();
        return combs(nums, target);
    }
}