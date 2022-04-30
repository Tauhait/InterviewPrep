class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls)
    {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        char[][] grid= new char[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int[] wall : walls)
        {
            int x = wall[0], y = wall[1];
            grid[x][y] = 'W';
        }
        for(int[] guard : guards)
        {
            int x = guard[0], y = guard[1];
            grid[x][y] = 'G';
            queue.offer(guard);
        }
        while(!queue.isEmpty())
        {
            for(int dir[] : dirs)
            {
                int[] point = queue.peek();
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                while(!(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'G' || grid[x][y] == 'W'))
                {
                    grid[x][y] = 'P';
                    x += dir[0];
                    y += dir[1];
                }
            }
            queue.poll();
        }
        
        int count = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] != 'G' && grid[i][j] != 'W' && grid[i][j] != 'P')
                    count++;
        
        return count;
    }
}