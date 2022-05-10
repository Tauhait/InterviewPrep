class Solution {
    private List<List<Integer>> ans;
    // private Set<String> combinationSet;
    private int k;
    private int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList();
        // combinationSet = new HashSet();
        this.k = k;
        this.n = n;
        boolean[] isUsed = new boolean[10];
        backtrack(0, 1, new ArrayList<Integer>(), isUsed);
        return ans;
    }
    private void backtrack(int currSum, int val, List<Integer> combinations, boolean[] isUsed){
        if(combinations.size() == k){
            if(currSum == n){
                ans.add(new ArrayList(combinations));                
            }            
        }
        
        for(int i = val; i <= 9; i++){
            if(isUsed[i]){
                continue;
            }
            combinations.add(i);
            isUsed[i] = true;
            backtrack(currSum + i, i, combinations, isUsed);
            isUsed[i] = false;
            int len = combinations.size();
            combinations.remove(len - 1);
        }
    }
}