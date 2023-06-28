class Solution {
    private int row, col;
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void dfs(char[][] grid, int i, int j, boolean[][] vis){
        if(vis[i][j]) return;
        vis[i][j] = true;
        for(int[] dir : dirs){
            int nextRow = i + dir[0];
            int nextCol = j + dir[1];
            if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col){
                if(!vis[nextRow][nextCol] && grid[nextRow][nextCol] == '1') {
                    dfs(grid, nextRow, nextCol, vis);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, i, j, vis);
                    ++count;
                }
            }
        }
        return count;
    }
}