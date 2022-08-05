class Solution {    
    private void generateCombinations(int start, int remain, int[] nums,
                                            List<List<Integer>> ans, LinkedList<Integer> curr){
        if(remain < 0) return;
        if(remain == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        //pos is initialized at start to avoid duplicity of results and 
        //also enable repetition of candidates in the current sum to match the target
        for(int pos = start; pos < nums.length; pos++){
            curr.add(nums[pos]);
            generateCombinations(pos, remain-nums[pos], nums, ans, curr);
            curr.removeLast();
        }
    } 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<Integer> curr = new LinkedList<>();
        generateCombinations(0, target, candidates, ans, curr);
        return ans;
    }
}