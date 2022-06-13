class Solution {
    private Integer[][] cache;
    private List<List<Integer>> triangle;
    private int n, m;
    
    private int dp(int i, int j){
        if(i == 0 && j == 0) return triangle.get(i).get(j);
        if(i < 0 || j < 0 || i >= n || j >= triangle.get(i).size()) return Integer.MAX_VALUE;
        
        if(cache[i][j] == null){
            cache[i][j] = triangle.get(i).get(j) + Math.min(dp(i-1, j), dp(i-1, j-1));;
        }
        return cache[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        
        n = triangle.size();
        m = triangle.get(triangle.size()-1).size();
        cache = new Integer[n][m];
        int minPath = Integer.MAX_VALUE;
        
        for(int j = 0; j < m; j++){
            minPath = Math.min(minPath, dp(n-1, j));
        }
        
        return minPath;
    }
}