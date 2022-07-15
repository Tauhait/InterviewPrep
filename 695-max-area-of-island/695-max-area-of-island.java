class Solution {
    private final int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    private boolean[][] visited;
    private int maxArea = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, DFS(grid, i, j, rows, cols));
                }
            }
        }
        return maxArea;
    }
    private int DFS(int[][] grid, int i, int j, int rows, int cols){
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0 || visited[i][j]) return 0;
        
        visited[i][j] = true;
        int area = 1;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            area += DFS(grid, x, y, rows, cols);
        }
        return area;
    }
}