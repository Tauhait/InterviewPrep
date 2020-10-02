package faang;

public class UniquePathsIII {
	public int uniquePathsIII(int[][] grid) {
        int sx = -1, sy = -1, empty = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0) ++empty;
                if(grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        grid[sx][sy] = -1;
        return  backtrack(grid, sx + 1, sy, empty) + 
                backtrack(grid, sx - 1, sy, empty) + 
                backtrack(grid, sx, sy + 1, empty) + 
                backtrack(grid, sx, sy - 1, empty);      
    }
    private int backtrack(int[][] grid, int x, int y, int empty){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 0) return 0;//invalid move
        if(grid[x][y] == 2) {
            if(empty == 0) return 1;//reached final state
            else return 0;
        }
               
        grid[x][y] = -1;//visit
        --empty;
        int pathCount = 0;
        pathCount = backtrack(grid, x + 1, y, empty) + 
                    backtrack(grid, x - 1, y, empty) + 
                    backtrack(grid, x, y + 1, empty) + 
                    backtrack(grid, x, y - 1, empty);
        grid[x][y] = 0;//backtrack
        ++empty;
        
        return pathCount;
    }
}
