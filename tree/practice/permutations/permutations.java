class Solution {
    private List<List<Integer>> permuts;

    private void backtracking(int[] nums, List<Integer> l, Set<Integer> indices){
        if(l.size() == nums.length){
            permuts.add(new ArrayList<>(l));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(indices.contains(i)) continue;
                l.add(nums[i]);
                indices.add(i);
                backtracking(nums, l, indices);
                l.remove(l.size()-1);
                indices.remove(i);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permuts = new ArrayList<>();
        backtracking(nums, new ArrayList<Integer>(), new HashSet<>());
        return permuts;
    }
}