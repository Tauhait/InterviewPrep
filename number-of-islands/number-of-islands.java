class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int islandCount = 0;
        int n = grid.length;
        for(int i=0; i < n; i++){
            int m = grid[i].length;
            for(int j=0; j < m; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return islandCount;
    }
    public void dfs(char[][] grid, int x, int y, int row, int col){
        if(grid[x][y] == '0')
            return;
        
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
            if(x + 1 < row)
                dfs(grid, x + 1, y, row, col);
            if(x - 1 >= 0)
                dfs(grid, x - 1, y, row, col);
            if(y - 1 >= 0)
                dfs(grid, x, y - 1, row, col);
            if(y + 1 < col)
                dfs(grid, x, y + 1, row, col);
            
        }
    }
}