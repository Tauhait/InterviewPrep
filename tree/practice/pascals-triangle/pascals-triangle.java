class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return null;
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows >= 1){
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            ans.add(firstRow);
        }
        if(numRows >= 2){
            List<Integer> secondRow = new ArrayList<>();
            secondRow.add(1);
            secondRow.add(1);
            ans.add(secondRow);
        }
        for(int i = 2; i < numRows; i++){
            List<Integer> prev = ans.get(i-1);
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j < prev.size()-1; j++){
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(0,1);
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }
}