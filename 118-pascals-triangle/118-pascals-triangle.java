class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        pascal.add(new ArrayList<Integer>());
        pascal.get(0).add(1);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> cols = new ArrayList<Integer>();
            List<Integer> prevCol = pascal.get(i-1);
            cols.add(1);
            for(int j = 1; j < i; j++){
                int sum = prevCol.get(j-1) + prevCol.get(j);
                cols.add(sum);
            }
            cols.add(1);
            pascal.add(cols);
        }
        return pascal;
    }
}