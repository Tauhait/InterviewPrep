class Solution {
    
    public int minimumEffortPath(int[][] heights) {
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Peak> pQueue = new PriorityQueue<Peak>((a, b) -> (a.effort - b.effort));
        int[][] hikes = new int[rows][cols];
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                hikes[row][col] = Integer.MAX_VALUE;
            }
        }
        
        hikes[0][0] = 0;
        visited[0][0] = true;
        pQueue.add(new Peak(0, 0, hikes[0][0]));
        
        while(!pQueue.isEmpty()){
            Peak thisPeak = pQueue.poll();
            if(thisPeak.x == rows - 1 && thisPeak.y == cols - 1){
                return thisPeak.effort;
            }
            visited[thisPeak.x][thisPeak.y] = true;
            for(int[] dir : directions){
                int newX = thisPeak.x + dir[0];
                int newY = thisPeak.y + dir[1];
                if(isValid(newX, newY, rows, cols) && !visited[newX][newY]){
                    int hike = Math.abs(heights[thisPeak.x][thisPeak.y] - heights[newX][newY]);
                    int maxHike = Math.max(hikes[thisPeak.x][thisPeak.y], hike);
                    hikes[newX][newY] = Math.min(hikes[newX][newY], maxHike);
                    pQueue.add(new Peak(newX, newY, hikes[newX][newY]));         
                }
            }
        }
        return hikes[rows - 1][cols - 1];
    }
    
    public boolean isValid(int x, int y, int limitX, int limitY){
        return x >= 0 && x < limitX && y >= 0 && y < limitY;
    }
}
class Peak {
    int x;
    int y;
    int effort;
    
    public Peak(int x, int y, int effort){
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
}