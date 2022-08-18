class Solution {
    List<List<Integer>> ans;
    Set<String> uniqComb;
    
    private void backtrack(int[] nums, int index, LinkedList<Integer> temp){
        if(temp.size() == nums.length) return;
        for(int i = index; i < nums.length; i++){            
            temp.add(nums[i]);
            backtrack(nums, i+1, temp);
            if(!uniqComb.contains(temp.toString())){
                // System.out.println(temp.toString());
                uniqComb.add(temp.toString());
                ans.add(new ArrayList<Integer>(temp));
            }           
            temp.removeLast();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        uniqComb = new HashSet<String>();
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList<Integer>());
        ans.add(new ArrayList<Integer>());
        return ans;
    }
}