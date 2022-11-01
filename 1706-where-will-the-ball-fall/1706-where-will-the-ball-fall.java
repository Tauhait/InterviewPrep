class Solution {
    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] ans = new int[cols];
        for(int col = 0; col < cols; col++){
            int start = col;
            int row = 0;
            boolean canMove = true;
            for( ; row < rows && canMove; row++){
                if(grid[row][start] == 1){
                    if(start+1 < cols && grid[row][start+1] != -1)
                        start++;
                    else
                        canMove = false;
                }
                else {
                    if(start-1 >= 0 && grid[row][start-1] != 1)
                        start--;
                    else 
                        canMove = false;
                }
            }
            if(row == rows && canMove)
                ans[col] = start;
            else
                ans[col] = -1;
        }
        return ans;
    }
}