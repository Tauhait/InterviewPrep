class Solution {
    // BFS to find the shortest path in an unweighted graph with a really interesting seen array to stop searches that we know won't lead to a better solution. 
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};   // Up, right, down, left.
        Integer[][] seen = new Integer[m][n];   
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, k});      // [row, col, number of eliminations left]
        int steps = 0;
        while (queue.size() > 0) {
            // Every element in the queue is an ongoing exploration, we make one step with each exploration.
            for (int i = queue.size(); i > 0; --i) {
                int[] curr = queue.removeFirst();
                if (curr[0] == m - 1 && curr[1] == n - 1) return steps;

                for (int[] dir : dirs) {
                    int newRow = curr[0] + dir[0], newCol = curr[1] + dir[1];
                    if (0 <= newRow && newRow < m && 0 <= newCol && newCol < n) {
                        int eliminationsLeft = grid[newRow][newCol] == 1 ? curr[2] - 1 : curr[2];

                        // Only make a step in that direction if there hasn't already been a better exploration at the next position.
                        if (eliminationsLeft >= 0 && (seen[newRow][newCol] == null || seen[newRow][newCol] < eliminationsLeft)) {
                            seen[newRow][newCol] = eliminationsLeft;
                            queue.add(new int[]{newRow, newCol, eliminationsLeft});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;      // There is no path from grid[0][0] to grid[grid.length - 1][grid[0].length - 1] with <= k eliminations.
    }
}