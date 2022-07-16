class Solution {
    private Set<String> seenIslands;
    private int[][] grid;
    private int rows, cols;
    private boolean[][] visited;
    private StringBuilder currentIsland;
    
    private void dfs(int i, int j, char move){
        if(i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;
        currentIsland.append(move);
        dfs(i+1, j, 'D');
        dfs(i-1, j, 'U');
        dfs(i, j+1, 'R');
        dfs(i, j-1, 'L');
        currentIsland.append('0');
        return;
    }
    public int numDistinctIslands(int[][] grid) {
        seenIslands = new HashSet<String>();
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        visited = new boolean[rows][cols];
        int ans = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    currentIsland = new StringBuilder();
                    dfs(i, j, '0');
                    String pattern = currentIsland.toString();
                    // System.out.println(pattern);
                    if(!seenIslands.contains(pattern)) {
                        ans++;
                        seenIslands.add(pattern);
                    }
                }
            }
        }
        return ans;
    }
}