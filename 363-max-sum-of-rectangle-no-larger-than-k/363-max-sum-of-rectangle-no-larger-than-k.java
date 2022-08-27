class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE, rows = matrix.length, cols = matrix[0].length;
        for(int l = 0; l < cols; l++){
            int[] sum = new int[rows];
            for(int j = l; j < cols; j++){
                int kadane  = 0, maxKadane = Integer.MIN_VALUE;
                for(int i = 0; i < rows; i++){
                    sum[i]+=matrix[i][j];
                    kadane = Math.max(kadane + sum[i], sum[i]);
                    maxKadane = Integer.max(maxKadane, kadane);
                }                
                if(maxKadane <= k){
                    res = Math.max(res, maxKadane);
                    continue;
                }        
                TreeSet<Integer> set = new TreeSet<>();
                int runSum = 0;
                set.add(0);
                for(int s : sum){
                    runSum+= s;
                    Integer t = set.ceiling(runSum-k);
                    if(t != null)res = Math.max(res, runSum-t);
                    set.add(runSum);
                }
            }
        }
        return  res;
    }//Time  complexity = O(cols*cols*rows*log(rows))
     //Space complexity = O(rows)
}