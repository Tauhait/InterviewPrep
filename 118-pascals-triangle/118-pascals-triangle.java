class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new LinkedList<List<Integer>>();
        for(int i = 0; i < numRows; i++){
            List<Integer> cols = new LinkedList<Integer>();
            if(i == 0) {
                cols.add(1);
                pascal.add(cols);
                continue;
            }
            List<Integer> prevCol = new LinkedList<Integer>();
            prevCol = pascal.get(i-1);
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