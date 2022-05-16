class Solution {
    private static final int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; 
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rlen = grid.length - 1;
        int clen = grid[0].length - 1;
        if(grid[0][0] != 0 || grid[rlen][clen] != 0){
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int distance = grid[cell[0]][cell[1]];
            if(cell[0] == rlen && cell[1] == clen){
                // for(int i = 0; i <= rlen; i++){
                //     for(int j = 0; j <= clen; j++){
                //         System.out.print(grid[i][j] + "\t");
                //     }
                //     System.out.println();
                // }
                return distance;
            }
            for(int[] neighbors : getNeighbors(grid, cell, rlen, clen)){
                int neighborRow = neighbors[0];
                int neighborCol = neighbors[1];
                grid[neighborRow][neighborCol] = distance + 1;
                queue.add(new int[]{neighborRow, neighborCol});
            }
        }
        return -1;
    }
    private List<int[]> getNeighbors(int[][] grid, int[] cell, int rsize, int csize){
        List<int[]> neighbors = new ArrayList<>();
        int distance = grid[cell[0]][cell[1]];
        for(int[] dir : directions){
            int nextRow = cell[0] + dir[0];
            int nextCol = cell[1] + dir[1];
            if(nextRow < 0 || nextCol < 0 || nextRow > rsize || nextCol > csize || grid[nextRow][nextCol] != 0){
                continue;
            }
            neighbors.add(new int[]{nextRow, nextCol});
        }
        return neighbors;
    }
}