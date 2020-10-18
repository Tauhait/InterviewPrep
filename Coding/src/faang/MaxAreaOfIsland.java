package faang;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxArea = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = getIslandArea(grid, seen, i, j, grid.length, grid[i].length);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
    }
    public int getIslandArea(int[][] grid, boolean[][] seen, int x, int y, int r, int c){
        if(x < 0 || x >= r || y < 0 || y >= c || seen[x][y] || grid[x][y] == 0) return 0;
        seen[x][y] = true;
        return 1 + getIslandArea(grid, seen, x + 1, y, r, c) 
                 + getIslandArea(grid, seen, x - 1, y, r, c)
                 + getIslandArea(grid, seen, x, y + 1, r, c)
                 + getIslandArea(grid, seen, x, y - 1, r, c);
    }

}
