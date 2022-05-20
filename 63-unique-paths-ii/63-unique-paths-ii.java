class Solution {
    private int[][] memo;
    private int[][] obstacles;
    private int m, n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {        
        obstacles = obstacleGrid;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        //check if obstacle is present in top-left or bottom-right corner
        if(obstacleGrid[0][0] == 1|| obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        memo = new int[m][n];
        
        initMemo();
        
        return dp(m - 1, n - 1);
    }
    
    private void initMemo(){
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }    
        
        for(int i = 0; i < m; i++){
            if(i == 0) {//starting cell for col 0
                memo[i][0] = obstacles[i][0] != 1 ? 1 : 0;
            }else {//previous cell is not obstacle and current cell is not obstacle for col 0
                memo[i][0] = memo[i - 1][0] == 1 && obstacles[i][0] != 1 ? 1 : 0; 
            } 
                       
        }
        
        for(int j = 0; j < n; j++){
            if(j == 0) {////starting cell for row 0
                memo[0][j] = obstacles[0][j] != 1 ? 1 : 0;
            }else {//previous cell is not obstacle and current cell is not obstacle for row 0
                memo[0][j] = memo[0][j - 1] == 1 && obstacles[0][j] != 1 ? 1 : 0;
            }
        }
    }
    private int dp(int i, int j){
        // if(i < 0 || j < 0){
        //     return 0;
        // }
        // if(i == 0 && j == 0){
        //     return obstacles[i][j] == 1 ? 0 : 1;
        // }
        if(memo[i][j] == -1){
            int down = 0, right = 0;
            if(i - 1 >= 0 && obstacles[i - 1][j] != 1){
                down = dp(i - 1, j);
            }
            if(j - 1 >= 0 && obstacles[i][j - 1] != 1){
                right = dp(i, j - 1);
            }
            memo[i][j] = down + right;
        }
        return memo[i][j];
    }
}