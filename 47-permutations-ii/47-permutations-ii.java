class Solution {
    private List<List<Integer>> result;
    private int[] nums;
    private Map<Integer, Integer> numFreq;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList();
        this.nums = nums;
        numFreq = new HashMap();
        for(int n : nums){
            numFreq.put(n, numFreq.getOrDefault(n, 0) + 1);
        }
        backtrack(new LinkedList<Integer>());
        return result;
    }
    private void backtrack(LinkedList<Integer> combList){
        if(combList.size() == nums.length){
            result.add(new ArrayList<Integer>(combList));
            return;
        }
        for(Map.Entry<Integer, Integer> entry : numFreq.entrySet()){
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            
            if(count == 0){
                continue;
            }
            
            combList.addLast(num);
            numFreq.put(num, count - 1);
            
            backtrack(combList);
            
            combList.removeLast();
            numFreq.put(num, count);            
        }
    }
}