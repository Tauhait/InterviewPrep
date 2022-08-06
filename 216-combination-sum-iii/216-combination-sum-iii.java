class Solution {
    private void backtrack(int index, int len, int k, int remain,
                           LinkedList<Integer> comb, List<List<Integer>> ans){
        if(remain < 0 || len > k) return;
        if(len == k){
            if(remain == 0) ans.add(new ArrayList<>(comb));
            return;
        }
        for(int pos = index; pos <= 9; pos++){
            comb.add(pos);
            backtrack(pos+1, len+1, k, remain-pos, comb, ans);
            comb.removeLast();            
        }        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(1, 0, k, n, comb, ans);
        return ans;
    }
    //time complexity = O()
}