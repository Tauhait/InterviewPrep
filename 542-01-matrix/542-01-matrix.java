class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;//very imp statement, none of '0's would be visited
                }
            }
        }
        //System.out.println(queue.size());
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                //System.out.println(cur[0] + "/" + row + "," + cur[1] + "/" + col);
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                
                //if(mat[row][col] != 0){
                visited[row][col] = true;
                mat[row][col] = mat[cur[0]][cur[1]] + 1;
                //System.out.println(row + "," + col + "," + mat[row][col]);
                queue.offer(new int[]{row, col});
                //}          
                /*
                for(int r = 0; r < m; r++){
                    for(int c = 0; c < n; c++){
                        System.out.print(mat[r][c] + " ");
                    }
                    System.out.println();
                }
                System.out.println("===================");
                */
            }
        }
        return mat;
    }
}