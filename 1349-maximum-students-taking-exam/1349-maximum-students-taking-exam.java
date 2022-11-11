// https://leetcode.com/problems/maximum-students-taking-exam/discuss/503598/JAVA-DFS-with-memoization-represent-the-states-as-a-string.
class Solution {
    int m, n;
    Map<String, Integer> memo;
    int[][] dirs = {{0, 1}, {0, -1}, {1, -1}, {1, 1}};
    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        memo = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char[] row : seats) sb.append(row);
        return dfs(sb.toString());
    }
    
    private int dfs(String state) {
        if (memo.containsKey(state)) return memo.get(state);
        int res = 0;
        char[] s = state.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i * n + j] == '.') {
                    s[i * n + j] = 'x';  //pick empty seat
                    res = Math.max(res, dfs(new String(s))); //放弃seat，我们这里不+1
                    for (int[] dir : dirs) { //lock seats
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        if (s[x * n + y] == '.') s[x * n + y] = 'x';
                    }
                    res = Math.max(res, dfs(new String(s)) + 1); //1，3间隔的点在这里被覆盖到了。只有ban seat之后我们算+1
                }
            }
        }
        memo.put(state, res);
        return res;
    }
}