class Solution {    
    private void backtrack(int start, int remain, List<List<Integer>> ans, LinkedList<Integer> comb,
                            int[] candidates){
        if(remain < 0) return;
        if(remain == 0) {
            ans.add(new ArrayList<Integer>(comb));            
            return;
        }
        
        for(int pos = start; pos < candidates.length; pos++){
            if(pos > start && candidates[pos] == candidates[pos-1]) continue; // skip duplicates
            comb.add(candidates[pos]);
            backtrack(pos+1, remain-candidates[pos], ans, comb, candidates);
            comb.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(0, target, ans, comb, candidates);
        return ans;
    }
}