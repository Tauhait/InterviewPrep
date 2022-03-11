class Solution {
    private int n;
    private int k;
    private List<List<Integer>> output;
    public List<List<Integer>> combine(int n, int k) {
        //nCk output combinations
        this.n = n;
        this.k = k;
        output = new LinkedList();
        backtrack(1, new LinkedList());
        return output;
    }
    private void backtrack(int start, LinkedList<Integer> currKList){
        if(currKList.size() == k){
            output.add(new LinkedList(currKList));
            return;
        }
        
        for(int loopIdx = start; loopIdx <= n; loopIdx++){
            currKList.add(loopIdx);
            backtrack(loopIdx + 1, currKList);
            currKList.removeLast();
        }
        return;
    }
    
}