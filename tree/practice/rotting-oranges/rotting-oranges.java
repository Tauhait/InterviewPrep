class Solution {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void fillRottenOranges(int[][] grid, Deque<int[]> rottensQ){
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 2) rottensQ.addLast(new int[]{i, j});
            }
        }
    }

    private boolean hasFreshOrange(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1) return true;
            }
        }
        return false;
    }

    private int bfs(int[][] grid, Deque<int[]> rottensQ){
        int r = grid.length;
        int c = grid[0].length;
        int mins = -1;
        while(!rottensQ.isEmpty()){
            int sz = rottensQ.size();
            while(sz-- > 0){
                int[] rottenOrange = rottensQ.removeFirst();
                for(int[] dir : dirs){
                    int nextRow = dir[0] + rottenOrange[0];
                    int nextCol = dir[1] + rottenOrange[1];
                    if(nextRow >= 0 && nextRow < r && 
                       nextCol >= 0 && nextCol < c &&
                       grid[nextRow][nextCol] == 1){
                           rottensQ.addLast(new int[]{nextRow, nextCol});
                           grid[nextRow][nextCol] = 2;
                    }
                }
            }
            mins++;
        }
        return mins;
    }

    public int orangesRotting(int[][] grid) {
        Deque<int[]> rottensQ = new ArrayDeque<>();
        fillRottenOranges(grid, rottensQ);
        int ans = Math.max(0, bfs(grid, rottensQ));
        return hasFreshOrange(grid) ? -1 : ans;
    }
}