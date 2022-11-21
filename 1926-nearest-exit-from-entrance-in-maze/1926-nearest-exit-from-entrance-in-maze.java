class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Deque<int[]> deque = new ArrayDeque<int[]>();
        int dist = 0;        
        if(maze[entrance[0]][entrance[1]] == '+')
            return -1;
        
        int[] move = {entrance[0], entrance[1], 0};
        deque.add(move);
        
        final int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        while(!deque.isEmpty()){
            int[] pos = deque.pollFirst();
            if( !(pos[0] == entrance[0] && pos[1] == entrance[1]) && 
               (pos[0] == n-1 || pos[1] == m-1 || pos[0] == 0 || pos[1] == 0))
                return pos[2];
            if(maze[pos[0]][pos[1]] == '.'){
                maze[pos[0]][pos[1]] = '#';
                for(int[] dir : dirs){
                    int x = dir[0] + pos[0];
                    int y = dir[1] + pos[1];
                    if(x < n && x >= 0 && y < m && y >= 0 && 
                       maze[x][y] != '+' && maze[x][y] != '#'){
                        deque.add(new int[]{x,y,pos[2]+1});
                    }
                }
            }            
        }
        return -1;
    }
}