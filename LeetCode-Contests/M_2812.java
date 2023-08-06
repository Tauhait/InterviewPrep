// https://leetcode.com/problems/find-the-safest-path-in-a-grid/description/
class M_2812 {
    public int maximumSafenessFactor(List<List<Integer>> grid) {      
        int n = grid.size();
        final int[] MOVES = {1, 0, -1, 0, 1};  

        // first find the thieves & their location & put it in a queue;     
        Deque<int[]> dque = new LinkedList<>();
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid.get(row).get(col) == 1) { 
                    dque.offer(new int[]{row, col});
                }
            }
        }

        // find safeness factor for every grid cell re-using grid List space; 
        while(!dque.isEmpty()){
            int[] pqueEntry = dque.poll();
            int row = pqueEntry[0];
            int col = pqueEntry[1];
            for(int m = 0; m < 4; m++){
                int x = row + MOVES[m];
                int y = col + MOVES[m + 1];
                if( Math.min(x, y) >= 0 && 
                    Math.max(x, y) < n  && 
                    (grid.get(x).get(y) == 0 || grid.get(x).get(y) > grid.get(row).get(col) + 1)){
                    
                    grid.get(x).set(y, grid.get(row).get(col) + 1);
                    dque.offer(new int[]{x, y});
                }
            }
        }

        // Use Dijkstra to calc the maximum of all min safeness factor grid;
        PriorityQueue<int[]> pque = new PriorityQueue<>((A, B) -> B[0] - A[0]);
        pque.add(new int[]{grid.get(0).get(0), 0, 0});

        while(pque.peek()[1] < n - 1 || pque.peek()[2] < n - 1){
            int[] pqueEntry = pque.poll();
            int sf  = pqueEntry[0];
            int row = pqueEntry[1];
            int col = pqueEntry[2];
            if(grid.get(row).get(col) == -1) continue;
            grid.get(row).set(col, -1);
            for(int m = 0; m < 4; m++){
                int x = row + MOVES[m];
                int y = col + MOVES[m + 1];
                if( Math.min(x, y) >= 0 && Math.max(x, y) < n && grid.get(x).get(y) != -1){
                    pque.add(new int[]{Math.min(sf, grid.get(x).get(y)), x, y});
                }
            }
        }
        return pque.peek()[0] - 1;
    }
}