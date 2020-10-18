package faang;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        int len = grid.length;
        if(len == 0)
            return 0;
        
        for(int i = 0; i < len; i++){
            int col = grid[i].length;
            for(int j = 0; j < col; j++){
                int left, top;
                if(j > 0 && i > 0){
                    left = grid[i][j-1];
                    top = grid[i-1][j];
                } else if(j > 0){
                    left = grid[i][j-1];
                    top = -1;
                } else if(i > 0){
                    left = -1;
                    top = grid[i-1][j];
                } else {
                    left = -1;
                    top = -1;
                }
                
                if(left != -1 && top != -1){
                    grid[i][j] = grid[i][j] + (left < top ? left : top);
                } else if(left != -1){
                    grid[i][j] += left;
                } else if(top != -1){
                    grid[i][j] += top;
                } else {
                    grid[i][j] = grid[i][j];
                }
            }
        }
        return grid[len - 1][grid[len - 1].length - 1];
    }

}
