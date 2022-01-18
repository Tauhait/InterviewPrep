class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1)
            return grid[0][0] == 1 ? -1 : 0;
        Queue<int[]> rottenOrangeQ = new LinkedList<int[]>();
        int freshOrangeCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2)
                    rottenOrangeQ.offer(new int[]{i, j});
                else if(grid[i][j] == 1)
                    ++freshOrangeCount;
            }
        }
        if(freshOrangeCount == 0){
            return 0;
        }
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int timeElaps = -1;
        while(rottenOrangeQ.size() > 0){
            int rottenOrangC = rottenOrangeQ.size();
            ++timeElaps;
            //all the neighbours of rotten oranges can rot their neighbours after every time period 
            while(rottenOrangC-- > 0){
                int[] coord = rottenOrangeQ.poll();
                for(int d[] : dirs){
                    int x = coord[0] + d[0];
                    int y = coord[1] + d[1];
                    if( x >= 0 && y >= 0 && x < grid.length && y < grid[x].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        rottenOrangeQ.offer(new int[]{x, y});
                        --freshOrangeCount;
                    }
                }                
            }                                  
        }
        return freshOrangeCount == 0 ? timeElaps : -1;
    }
}